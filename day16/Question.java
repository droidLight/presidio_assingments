package day16;

import java.util.List;
import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;

public class Question implements Serializable{
	private int questionId;
	private String question;
	private String option1, option2, option3, option4, rightOption;

	Question(int questionId, String question, String option1, String option2, String option3, String option4,
			String rightOption) {
		this.questionId = questionId;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.rightOption = rightOption;
	}

	public boolean checkOption(String option) {
		return (this.rightOption.equalsIgnoreCase(option));
	}

	public String getRightOption() {
		return this.rightOption;
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public String getQuestion() {
		return this.question;
	}

	public List<String> getOptions() {
		List<String> options = new ArrayList<>();
		options.add(this.option1);
		options.add(this.option2);
		options.add(this.option3);
		options.add(this.option4);
		return options;
	}
}
