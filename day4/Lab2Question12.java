package day4;

class Wipro {

	void branchName() {
		System.out.println("WIPRO");
	}
}

class WiproBPO extends Wipro {
	WiproBPO() {

	}

	void branchName() {
		System.out.println("WIPRO BPO");
	}
}

class WiproInfo extends Wipro {
	WiproInfo() {
	}

	void branchName() {
		System.out.println("WIPRO INFOTECH");
	}
}

public class Lab2Question12 {
	public static void main(String[] args) {
		
		WiproBPO bpo = new WiproBPO();
		WiproInfo info = new WiproInfo();
		
		Wipro[] arr = {bpo, info};
		for(Wipro t: arr) {
			t.branchName();
		}
	}
}
