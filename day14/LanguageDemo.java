package day14;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageDemo {
	
	public static void main(String[] args) {
		
		Locale locale = Locale.getDefault();		
		System.out.println(locale);
		
		Locale.setDefault(new Locale("ta"));
		System.out.println(Locale.getDefault());
		
		locale = Locale.getDefault();
		
		//loading from file
		ResourceBundle resBundle = ResourceBundle.getBundle("dictionary_ta", locale);
		
		
		System.out.println(resBundle.getString("hello"));
	}
}
