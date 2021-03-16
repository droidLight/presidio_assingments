package day7;

public class PrototypePatternDemo {
	
	public static void main(String[] args) throws Exception{
		BuisnessLogic obj1 = BuisnessLogic.createObject();
		DataModel dataModel1 = DataModel.createObject();
		
		obj1.setDataModel(dataModel1);
		System.out.println(obj1);
		System.out.println(obj1.getDataModel());
		
		BuisnessLogic obj2 = BuisnessLogic.createObject();
		DataModel dataModel2 = DataModel.createObject();
		
		obj2.setDataModel(dataModel2);
		System.out.println(obj2);
		System.out.println(obj2.getDataModel());
	}
}


class BuisnessLogic implements Cloneable{
	private static BuisnessLogic instance;
	private DataModel dataModel;
	
	private BuisnessLogic() {
		System.out.println("BuisnessLogic cons called");
	}
	
	public static BuisnessLogic createObject() throws Exception{
		if(instance == null) {
			instance = new BuisnessLogic();
		}
		return instance.createClone();
	}
	
	private BuisnessLogic createClone() throws Exception{
		return (BuisnessLogic) super.clone();
	}
	
	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}
	
	public DataModel getDataModel() {
		return this.dataModel;
	}		
	
}


class DataModel implements Cloneable{
	private static DataModel instance;
	private DataModel() {
		System.out.println("DataModel cons called");
	}
	
	public static DataModel createObject() throws Exception{
		if(instance == null) {
			instance = new DataModel();
		}
		return instance.createClone();
	}
	
	private DataModel createClone() throws Exception{
		return (DataModel) super.clone();
	}
}
