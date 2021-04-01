package rmi_services;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ControllerService extends UnicastRemoteObject implements Controller {

	List<String> classList, objectList;

	protected ControllerService() throws RemoteException, Exception {
		super();		
	}

	@Override
	public Object getObject() throws RemoteException, Exception {
		this.classList = new ArrayList<>();
		this.objectList = new ArrayList<>();
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();

		parser.parse(new File("./rmi-config.xml"), new ParsingHandler());

		Class[] classArr = new Class[this.classList.size()];
		Object[] objArr = new Object[this.objectList.size()];
		for (int i = 0; i < this.classList.size(); i++) {
			System.out.println(this.objectList.get(i) + "\t" + this.classList.get(i));
			classArr[i] = Class.forName(this.classList.get(i));
			objArr[i] = Naming.lookup(this.objectList.get(i));
		}

		BindClass bindObj = new BindClass();

		Object object = Proxy.newProxyInstance(bindObj.getClass().getClassLoader(), classArr,
				new MyInvocationHandler(objArr));
		return object;
	}

	
	class ParsingHandler extends DefaultHandler {
		Stack<String> stack;
		String value;

		ParsingHandler() {
			this.stack = new Stack<>();
			this.value = null;
		}

		@Override
		public void startDocument() throws SAXException {
			classList.clear();
			objectList.clear();
			System.out.println("parsing rmi-config.xml");
		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("parsing ended");
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			this.value = new String(ch, start, length);
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			this.stack.push(qName);
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			try {
				if (this.stack.peek().equals(qName)) {
					this.stack.pop();

					switch (qName) {
					case "name":
						classList.add(this.value);
						break;
					case "url":
						objectList.add(this.value);
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	
}

class MyInvocationHandler implements InvocationHandler, Serializable {
	Object[] objList;

	MyInvocationHandler(Object[] objList) {
		this.objList = objList;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnObj = null;
		for (Object object : this.objList) {
			if (object != null) {				
				for (Method temp : object.getClass().getDeclaredMethods()) {
					temp.setAccessible(true);
				}
				try {					
					returnObj = method.invoke(object, args);
				} catch (Exception e) {
					System.out.println("InvocationHandler:  " + e);
				}
			}
		}
		return returnObj;
	}

}

