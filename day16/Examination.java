package day16;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Examination extends Remote {

	public void startExam(int duration, TimeListener timerCallback) throws RemoteException;

	public List<Question> getQuestionList() throws RemoteException;

	public void setAnswerList(String answer) throws RemoteException;
}
