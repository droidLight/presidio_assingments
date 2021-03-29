package day15;

import java.io.File;
import java.io.FilenameFilter;

class FileDemo {

//	public static void main(String args[]) throws Exception {
//		File f1 = new File("abc.properties");
//		System.out.println("file name :" + f1.getName());
//		System.out.println("path :" + f1.getPath());
//		System.out.println(f1.exists() ? "exists" : "does not exist");
//		System.out.println(f1.canWrite() ? "is writable" : "is not writable");
//		System.out.println(f1.isDirectory() ? "is a dir" : "is not a directory");		
//	}
	
	public static void main(String args[]) {
		File dir = new File("./");
		System.out.println(dir.isDirectory()? "it is directory":"no not directory");
		System.out.println("----------");
		
		String[] listOfFiles = dir.list();
		for(String str : listOfFiles) {System.out.println(str);}
		System.out.println("----------");
		
		//list only .properties file
		String[] propertyFiles = dir.list(new FilterPropertiesFiles());
		for(String str : propertyFiles) {System.out.println(str);}
	}
}


class FilterPropertiesFiles implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".properties");
	}
	
}