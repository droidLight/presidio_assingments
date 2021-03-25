package day14;


import java.util.ListResourceBundle;

public class Dictionary_Tamil extends ListResourceBundle{

	Object[][] obj = {
			{"hello","vanakam"},
			{"user name", "peru enna"}
	};
	
	@Override
	protected Object[][] getContents() {
		return this.obj;
	}

	
}
