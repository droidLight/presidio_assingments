package day16;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class PhysicsExamService extends UnicastRemoteObject implements Examination{

	List<Question> questionList;
	List<String> answerList;
	private ExecutorService clockThread, examThread;
	private boolean isRunning;
	private TimeListener timerCallback;
	
	protected PhysicsExamService() throws RemoteException {
		super();
		
		this.questionList = QuestionBank.getInstance().getQuestionList();
		this.answerList = new ArrayList<>();
		this.clockThread = Executors.newFixedThreadPool(1);
		this.examThread = Executors.newFixedThreadPool(1);
		this.isRunning = false;
	}
	
	@Override
	public List<Question> getQuestionList() throws RemoteException {
		return this.questionList;
	}
	
	@Override
	public void startExam(int duration, TimeListener timerCallback) throws RemoteException {
		System.out.println("Examination started... Ends in " + duration + " mins...");
		this.isRunning = true;
		this.timerCallback = timerCallback;
		//run the clock in another thread
		clockThread.execute(()->{
			
			try {
				Thread.currentThread().sleep(duration * 60 * 1000);
				//Thread.currentThread().sleep(4000);
				PhysicsExamService.this.endExam();
			}catch(Exception e) {}
		});
	}
	
	public void endExam() {
		this.isRunning = false;
		this.clockThread.shutdown();
		this.timerCallback.onTimeOut(getScore());
	}
	
	private int getScore() {
		int score = 0;
		for(int i = 0;  i < this.answerList.size(); i++) {
			if(this.questionList.get(i).checkOption(this.answerList.get(i))) {
				score++;
			}
		}
		return score;
	}

	@Override
	public void setAnswerList(String answer) throws RemoteException {		
		this.answerList.add(answer);
		if(this.questionList.size() == this.answerList.size())
			this.timerCallback.onTimeOut(getScore());
	}

	
	
	public static void main(String[] args) throws Exception{
		PhysicsExamService service = new PhysicsExamService();
		
		LocateRegistry.createRegistry(1000);
		Naming.bind("rmi://localhost:1000/services/physicsExam", service);
	}
}
