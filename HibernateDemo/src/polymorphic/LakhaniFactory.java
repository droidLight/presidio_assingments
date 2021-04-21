package polymorphic;

public class LakhaniFactory extends ShoeFactory{
	
	private String lakhaniName;

	public String getLakhaniName() {
		return lakhaniName;
	}

	public void setLakhaniName(String lakhaniName) {
		this.lakhaniName = lakhaniName;
	}
	
	public void visitor(Visitor visitor) {
		visitor.castInto(this);
	}
}
