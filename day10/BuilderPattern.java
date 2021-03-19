package day10;

public class BuilderPattern {

	public static void main(String[] args) throws Exception{
		Computer computer = new Computer.ComputerBuilder("asus", "AMD ryzen").build();
		System.out.println(computer);

		Computer gamingComputer = new Computer.ComputerBuilder("asus", "AMD").setGraphicsCard("nvidia")
				.setHdd("seagate").build();
		System.out.println(gamingComputer);
		
	}
}

class Computer{

	private String motherboard, cpu;
	// optional parameters
	private String graphicsCard, hdd;
	
	private Computer(ComputerBuilder builder) {
		System.out.println("Computer cons called");
		this.motherboard = builder.motherboard;
		this.graphicsCard = builder.graphicsCard;
		this.cpu = builder.cpu;
		this.hdd = builder.hdd;
	}
	
	public String getCpu() {
		return cpu;
	}

	public String getMotherbaord() {
		return motherboard;
	}

	public String getGraphicsCard() {
		return graphicsCard;
	}

	public String getHdd() {
		return hdd;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public void setMotherboard(String motherboard) {
		this.motherboard = motherboard;
	}

	public void setGraphicsCard(String graphicsCard) {
		this.graphicsCard = graphicsCard;
	}

	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	@Override
	public String toString() {
		return "Computer [motherBoard= " + this.motherboard + "cpu = " + this.cpu + ", graphicsCard= "
				+ this.graphicsCard + ", hdd= " + this.hdd + "]";
	}
	
	//builder inner class
	static class ComputerBuilder implements Cloneable{
		private String motherboard, cpu;
		// optional parameters
		private String graphicsCard, hdd;		
		
		public ComputerBuilder(String motherboard, String cpu) {
			System.out.println("ComputerBuilder constructor called");
			this.motherboard = motherboard;
			this.cpu = cpu;
		}
		

		public Computer build() throws Exception{
			return new Computer(this);
		}
		
		public String getCpu() {
			return cpu;
		}

		public String getMotherbaord() {
			return motherboard;
		}

		public String getGraphicsCard() {
			return graphicsCard;
		}

		public String getHdd() {
			return hdd;
		}

		public ComputerBuilder setCpu(String cpu) {
			this.cpu = cpu;
			return this;
		}

		public ComputerBuilder setMotherboard(String motherboard) {
			this.motherboard = motherboard;
			return this;
		}

		public ComputerBuilder setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}

		public ComputerBuilder setHdd(String hdd) {
			this.hdd = hdd;
			return this;
		}

				
	}
}