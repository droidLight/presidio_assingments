package questions;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Examination implements Cloneable {

	private static Examination instance;
	private Scanner s;
	private ExecutorService clockThread, examThread;
	private boolean isRunning;
	private List<Question> questionList;
	
	private Examination() {
		s = new Scanner(System.in);
		clockThread = Executors.newFixedThreadPool(1);
		examThread = Executors.newFixedThreadPool(1);
		this.isRunning = false;		
	}
	
	private Examination setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
		return this;
	}
	
	private Examination createClone() throws Exception {
		return (Examination) super.clone();
	}

	public static Examination createExam(List<Question> questionList) throws Exception {
		if (instance == null)
			instance = new Examination();

		return instance.createClone().setQuestionList(questionList);
	}

	public void startExam(int duration, AnswerListener answerCallback,
			TimeListener timerCallback) {
		System.out.println("Examination started... Ends in " + duration + " mins...");
		this.isRunning = true;
		
		//running exam in a thread
		examThread.execute(() -> {
			
				for (Question question : this.questionList) {
					if(!isRunning) {
						break;
					}
					printQuestion(question);
					String input = s.next();
					answerCallback.onQuestionAnswered(input, question.checkOption(input));
				}
				timerCallback.onTimeOut(Examination.this);
		});
		
		//run the clock in another thread
		clockThread.execute(()->{
			
			try {
				Thread.currentThread().sleep(duration * 60 * 1000);
				//Thread.currentThread().sleep(4000);
				timerCallback.onTimeOut(Examination.this);
			}catch(Exception e) {}
		});
	}
	
	public void endExam() {
		this.isRunning = false;
		this.examThread.shutdown();
		this.clockThread.shutdown();
	}
	public int getScore(List<String> answers) {
		int score = 0;
		for(int i = 0;  i < answers.size(); i++) {
			if(this.questionList.get(i).checkOption(answers.get(i))) {
				score++;
			}
		}
		return score;
	}
	
	
	
	private void printQuestion(Question question) {
		System.out.println("Question.No: " + question.getQuestionId());
		System.out.println(question.getQuestion());
		for (String str : question.getOptions()) {
			System.out.printf("%-5s", str);
		}
		System.out.println("\nEnter option: ");
	}

}
