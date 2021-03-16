package day7;

public class TemplateMethodPatternDemo {
	public static void main(String[] args) {
		MyBrand myBrand = new MyBrand();
		myBrand.buyDevice();
	}
}


abstract class OEM{
	final protected void chooseParts() {//template part method
		System.out.println("OEM has chosen parts");
	}
	
	final protected void assembleParts() {//template part method
		System.out.println("OEM has assembled the parts");
	}
	
	abstract protected void buyProduct();
	abstract protected void brandProduct();
	abstract protected void sellProduct();
	
	final public void buyDevice() {//template whole method
		buyProduct();
		brandProduct();
		sellProduct();
	}
}

class MyBrand extends OEM{

	@Override
	protected void buyProduct() {
		chooseParts();
		assembleParts();
	}

	@Override
	protected void brandProduct() {
		System.out.println("Apply company branding");
	}

	@Override
	protected void sellProduct() {
		System.out.println("Sell to my customers");
	}	
	
}