package polymorphic;

public class VisitorImpl implements Visitor{

	@Override
	public void castInto(BataFactory factory) {
		System.out.println("casted into bata factory");
		System.out.println(factory.getBataName()+"\t"+factory.getShoeName());
	}

	@Override
	public void castInto(LakhaniFactory factory) { 
		System.out.println("casted into lakhani factory");
		System.out.println(factory.getLakhaniName()+"\t"+factory.getShoeName());
	}

	@Override
	public void castInto(ShoeFactory factory) {
		System.out.println("casted into shoe factory");
		System.out.println(factory.getShoeName());
	}

}
