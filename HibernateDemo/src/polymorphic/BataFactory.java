package polymorphic;

public class BataFactory extends ShoeFactory{
	
	private String bataName;

	public String getBataName() {
		return bataName;
	}

	public void setBataName(String bataName) {
		this.bataName = bataName;
	}
	
	public void visitor(Visitor visitor) {
		visitor.castInto(this);
	}
}
