package polymorphic;

public interface Visitor {
	
	public void castInto(BataFactory factory);
	public void castInto(LakhaniFactory factory);
	public void castInto(ShoeFactory factory);
}
