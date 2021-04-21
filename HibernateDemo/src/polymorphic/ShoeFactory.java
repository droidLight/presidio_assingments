package polymorphic;

public class ShoeFactory {
	
	private int sid;
	private String shoeName;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getShoeName() {
		return shoeName;
	}
	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}
	
	public void visitor(Visitor visitor) {
		visitor.castInto(this);
	}
	
}
