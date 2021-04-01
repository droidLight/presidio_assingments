package day16;

import java.io.Serializable;
import java.rmi.Remote;

public interface QuestionListener extends Serializable{
	void onQuestionRecieved(Question question);
}
