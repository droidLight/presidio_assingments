package day9;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyFactoryDemo {
	
	public static void main(String[] args) {
		
		ManufacturerNew manufacturer = new ManufacturerNewImpl();
		SellerNew seller = new SellerNewImpl();
		
		manufacturer.manufactureItem();
		
		Object obj = Proxy.newProxyInstance(manufacturer.getClass().getClassLoader(),
				new Class[] {ManufacturerNew.class, SellerNew.class},
				new MyInvocationHandlerNew(new Object[] {manufacturer, seller}));
		
		//dynamically binding seller attributes to manufacture
		SellerNew sellerNew = (SellerNew) obj;
		sellerNew.sellItem();		
		
		ManufacturerNew newObj = (ManufacturerNew) obj;
		newObj.manufactureItem();
	}
		
}


class MyInvocationHandlerNew implements InvocationHandler{
	Object[] obj;
	MyInvocationHandlerNew(Object[] obj){
		this.obj = obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnObj = null;
		for(Object o: obj) {
			for(Method objMethod : o.getClass().getDeclaredMethods()) {
				if(objMethod.getName().equals(method.getName())) {
					objMethod.setAccessible(true);
					returnObj = method.invoke(o, args);
				}
			}
		}		
		return returnObj;
	}
	
}

interface SellerNew{
	void sellItem();
}

class SellerNewImpl implements SellerNew{

	@Override
	public void sellItem() {
		System.out.println("sellItem logic called");		
	}	
}


interface ManufacturerNew{
	
	public void manufactureItem();
}

class ManufacturerNewImpl implements ManufacturerNew{

	@Override
	public void manufactureItem() {
		System.out.println("manufacture item");
	}	
}