package day10;

public class BuilderPatternWithPrototype {

	public static void main(String[] args) throws Exception{
		ComputerNew computer = ComputerNew.ComputerBuilderNew.getBuilder("gigabyte", "intel").build();
		System.out.println(computer);

		ComputerNew gamingComputer = ComputerNew.ComputerBuilderNew.getBuilder("msi", "AMD").setGraphicsCard("nvidia").setHdd("seagate").build();
		System.out.println(gamingComputer);		
		
		gamingComputer.setCpu("intel");
		System.out.println(gamingComputer);
	}
}

class ComputerNew implements Cloneable{

	private String motherboard, cpu;
	// optional parameters
	private String graphicsCard, hdd;
	private static ComputerNew instance;
	
	private ComputerNew() {
		System.out.println("ComputerNew constructor called");	
	}
	
	public static ComputerNew getInstance() throws Exception{
		if(instance == null) {
			instance = new ComputerNew();
		}
		return instance.createClone();
	}
	
	private ComputerNew createClone() throws Exception{
		return (ComputerNew) super.clone();
	}
	
	private ComputerNew setVariables(ComputerBuilderNew builder) {
		this.motherboard = builder.motherboard;
		this.graphicsCard = builder.graphicsCard;
		this.cpu = builder.cpu;
		this.hdd = builder.hdd;
		return this;
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
		return "\nComputer [motherBoard= " + this.motherboard + "\ncpu = " + this.cpu + "\ngraphicsCard= "
				+ this.graphicsCard + "\nhdd= " + this.hdd + "]";
	}
	
	//builder inner class
	static class ComputerBuilderNew implements Cloneable{
		private String motherboard, cpu;
		// optional parameters
		private String graphicsCard, hdd;		
		private static ComputerBuilderNew instance;
		
	
		private ComputerBuilderNew() {
			System.out.println("ComputerBuilderNew constructor called");
		}
		
		public static ComputerBuilderNew getBuilder(String motherboard, String cpu) throws Exception{			
			if(instance == null)
				instance = new ComputerBuilderNew();
			return instance.createClone().setMotherboard(motherboard).setCpu(cpu);//here i change the attributes of cloned obj
		}
		
		private ComputerBuilderNew createClone() throws Exception{
			return (ComputerBuilderNew) super.clone();
		}
		
		public ComputerNew build() throws Exception{
			return ComputerNew.getInstance().setVariables(this);
		}
		
		//setters and getters
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

		public ComputerBuilderNew setCpu(String cpu) {
			this.cpu = cpu;
			return this;
		}

		public ComputerBuilderNew setMotherboard(String motherboard) {
			this.motherboard = motherboard;
			return this;
		}

		public ComputerBuilderNew setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}

		public ComputerBuilderNew setHdd(String hdd) {
			this.hdd = hdd;
			return this;
		}

				
	}
}