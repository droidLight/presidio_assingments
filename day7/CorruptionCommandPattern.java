package day7;

public class CorruptionCommandPattern {
	public static void main(String[] args) {
		
		SevaDepartment corporationDepartment = new DeathCertificateDepartment(new Corporation(), null, null, new Police());
		SevaDepartment foodSafetyDepartment = new HotelRegistrationDepartment(null, null, new FoodSafety(), null); 
		Broker deathCertBroker = new Broker(corporationDepartment);
		Broker hotelRegBroker = new Broker(foodSafetyDepartment);
		
		deathCertBroker.getService();
		System.out.println("");
		hotelRegBroker.getService();
	}
}

class Broker {
	SevaDepartment departmentContact;

	Broker(SevaDepartment departmentContact) {
		this.departmentContact = departmentContact;
	}

	void getService() {
		departmentContact.execute();
	}
}

abstract class SevaDepartment {

	private Corporation corporation;
	private Hospital hospital;
	private FoodSafety foodSafety;
	private Police police;

	public SevaDepartment(Corporation corporation, Hospital hospital, FoodSafety foodSafety, Police police) {
		this.corporation = corporation;
		this.hospital = hospital;
		this.foodSafety = foodSafety;
		this.police = police;
	}
	
	public Corporation getCorporation() {
		return corporation;
	}

	public FoodSafety getFoodSafety() {
		return foodSafety;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public Police getPolice() {
		return police;
	}

	abstract public void execute();
}

class DeathCertificateDepartment extends SevaDepartment {

	public DeathCertificateDepartment(Corporation corporation, Hospital hospital, FoodSafety foodSafety,Police police) {
		super(corporation, hospital, foodSafety, police);
	}

	@Override
	public void execute() {
		System.out.println("death cetr department");
		getPolice().getForm();
		getCorporation().getForm();
	}

}

class HotelRegistrationDepartment extends SevaDepartment {
	
	public HotelRegistrationDepartment(Corporation corporation, Hospital hospital, FoodSafety foodSafety,Police police) {
		super(corporation, hospital, foodSafety, police);
	}

	@Override
	public void execute() {
		System.out.println("death cetr department");
		getFoodSafety().getForm();
	}

}

class Corporation {

	public void getForm() {
		System.out.println("Got form from Corporation");
	}
}

class Hospital {

	public void getForm() {
		System.out.println("Got form from Hospital");
	}
}

class FoodSafety {
	public void getForm() {
		System.out.println("Got form from food safety");
	}
}

class Police {
	public void getForm() {
		System.out.println("Got form from Police");
	}
}