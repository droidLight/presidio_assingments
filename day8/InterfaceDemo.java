package day8;

import java.lang.reflect.*;

public class InterfaceDemo {
	public static void main(String[] args) {

		AlopathyMedicalCollege alopathyClg = new AlopathyMedicalCollege();
		AyurvedMedicalCollege ayurvedaClg = new AyurvedMedicalCollege();

		Human human = new Human();

		Doctor doctorHuman = (Doctor) Proxy.newProxyInstance(human.getClass().getClassLoader(),
				new Class[] { Doctor.class }, new MyInvocationHandler(new Object[] { alopathyClg, ayurvedaClg }));

		doctorHuman.doCure();
	}
}

class MyInvocationHandler implements InvocationHandler {
	Object obj[];

	public MyInvocationHandler(Object obj[]) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnObject = null;
		for (Object o : obj) {
			Method m[] = o.getClass().getDeclaredMethods();
			for (Method met : m) {
				if (met.getName().equals(method.getName())) {
					met.setAccessible(true);
					returnObject = method.invoke(o, args);
				}
			}
		}
		return returnObject;
	}
}

interface Doctor {
	void doCure();
}

class Human {
}

class AlopathyMedicalCollege implements Doctor {
	@Override
	public void doCure() {
		System.out.println("alopathy cure logic implemented...");
	}
}

class AyurvedMedicalCollege implements Doctor {
	@Override
	public void doCure() {
		System.out.println("ayurved cure logic implemented....");
	}
}