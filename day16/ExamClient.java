package day16;

import java.io.Serializable;
import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class ExamClient implements TimeListener{
	
	public static void main(String[] args) throws Exception{
		ExamClient client = new ExamClient();		
		client.startExamination();
	}
	
	
	Examination physicsExam;
	List<Question> questionList;
	
	public ExamClient() throws Exception{
		this.physicsExam = (Examination) Naming.lookup("rmi://localhost:3000/exams/physicsExam");
		this.questionList = this.physicsExam.getQuestionList();
	}
	
	private void startExamination() {
		try {
			Scanner s = new Scanner(System.in);
			this.physicsExam.startExam(Integer.valueOf(4),(TimeListener)this);
			for(Question q: this.questionList) {
				printQuestion(q);
				String str = s.next();
				this.physicsExam.setAnswerList(str);
			}
		}catch(Exception e) {System.out.println("startExam: "+e);}
		
	}
	
	private void printQuestion(Question question) {
		System.out.println("Question.No: " + question.getQuestionId());
		System.out.println(question.getQuestion());
		for (String str : question.getOptions()) {
			System.out.printf("%-5s", str);
		}
		System.out.println("\nEnter option: ");
	}
	
	
	@Override
	public void onTimeOut(int score) {
		System.out.println("Exam over, your score: "+score);
	}
}
