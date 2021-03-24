package questions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.List;
import java.util.ArrayList;

public class UserInterface implements AnswerListener, TimeListener{
	
	List<String> chosenAnswers;
	Examination examination;
	
	public static void main(String[] args) throws Exception{
		
		UserInterface obj = new UserInterface();
		obj.startExam();
	}
	UserInterface(){
		this.chosenAnswers = new ArrayList<>();
	}
	
	private void startExam() {
		try {
			List<Question> questionList = QuestionBank.getInstance().getQuestionList();			
			this.examination = Examination.createExam(questionList);
			this.examination.startExam(1, this, this); //time in mins
		}catch(Exception e) {}
			
	};
	
	//listener for answers
	@Override
	public void onQuestionAnswered(String option, boolean isCrct) {
		System.out.println(option+" "+isCrct);
		this.chosenAnswers.add(option);
	}

	//listener for timeout
	@Override
	public void onTimeOut(Examination examination) {
		examination.endExam();
		System.out.println("Exam ended");
		System.out.println("Final Score: "+this.examination.getScore(this.chosenAnswers));;
	}
	
	
}
