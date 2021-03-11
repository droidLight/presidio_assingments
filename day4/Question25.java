package day4;

public class Question25 {
	protected class base {
		String Method() {
			return "Wow";
		}
	}

	private class Dervied {
		public void useD() {
			base z = new base();
			System.out.println("base says, " + z.Method());
		}
	}
	
	public static void main(String[] args) {
		
		Derived obj = new Derived();
		
	}

}
