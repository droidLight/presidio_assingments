package questions;

import java.util.List;
import java.util.ArrayList;

public class QuestionBank {
	
	private static QuestionBank instance;
	private List<Question> questionList;
	
	private QuestionBank() {
		this.questionList = new ArrayList<>();
		
		//adding questions
		this.questionList.add(new Question(1, "Question 1", "A", "B","C", "D", "A"));
		this.questionList.add(new Question(2, "Question 2", "A", "B","C", "D", "B"));
		this.questionList.add(new Question(3, "Question 3", "A", "B","C", "D", "C"));
		this.questionList.add(new Question(4, "Question 4", "A", "B","C", "D", "D"));
		this.questionList.add(new Question(5, "Question 5", "A", "B","C", "D", "A"));
		this.questionList.add(new Question(6, "Question 6", "A", "B","C", "D", "B"));
		this.questionList.add(new Question(7, "Question 7", "A", "B","C", "D", "C"));
		this.questionList.add(new Question(8, "Question 8", "A", "B","C", "D", "D"));
		this.questionList.add(new Question(9, "Question 9", "A", "B","C", "D", "A"));
		this.questionList.add(new Question(10, "Question 10", "A", "B","C", "D", "B"));
	}
	
	public static QuestionBank getInstance(){
		if(instance == null)
			instance = new QuestionBank();
		return instance;
	}
	
	public List<Question> getQuestionList(){
		return this.questionList;
	}
}
