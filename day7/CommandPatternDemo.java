package day7;

public class CommandPatternDemo {
	public static void main(String[] args) {

		TaskOne taskOne = new TaskOne();
		TaskTwo taskTwo = new TaskTwo();

		Command commandOne = new CommandOne(taskOne, taskTwo);
		Command commandTwo = new CommandTwo(taskOne, taskTwo);
		
		UniversalRemote remote = new UniversalRemote(2);
		remote.setCommand(1, commandOne);
		remote.setCommand(2, commandTwo);
		
		remote.executeCommand(2);
	}
}

//like controller
class UniversalRemote {
	Command c[];

	public UniversalRemote(int total) {
		c = new Command[total];
		for (int i = 0; i < total; i++) {
			c[i] = null;
		}
	}

	public void setCommand(int slot, Command command) {
		this.c[slot-1] = command;
	}

	public void executeCommand(int slot) {
		this.c[slot-1].execute();
	}
}

abstract class Command {

	private TaskOne taskOne;
	private TaskTwo taskTwo;

	Command(TaskOne taskOne, TaskTwo taskTwo) {
		this.taskOne = taskOne;
		this.taskTwo = taskTwo;

	}

	final public TaskOne getTaskOne() {
		return taskOne;
	}

	final public TaskTwo getTaskTwo() {
		return taskTwo;
	}

	abstract public void execute();

}

class CommandOne extends Command {

	CommandOne(TaskOne taskOne, TaskTwo taskTwo) {
		super(taskOne, taskTwo);
	}

	public void execute() {
		getTaskOne().taskOneMethod1();
		getTaskTwo().taskTwoMethod1();
	}
}

class CommandTwo extends Command {

	CommandTwo(TaskOne taskOne, TaskTwo taskTwo) {
		super(taskOne, taskTwo);
	}

	public void execute() {
		getTaskOne().taskOneMethod2();
		getTaskTwo().taskTwoMethod2();
	}
}

class TaskOne {

	public void taskOneMethod1() {
		System.out.println("taskOneMethod1");
	}

	public void taskOneMethod2() {
		System.out.println("taskOneMethod2");
	}

}

class TaskTwo {

	public void taskTwoMethod1() {
		System.out.println("taskTwoMethod1");
	}

	public void taskTwoMethod2() {
		System.out.println("taskTwoMethod2");
	}

}
