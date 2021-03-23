package deliverydate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class UserInterface {
	
	public static void main(String[] args) {
		
		//inputs from user
		
		//LocalDateTime startDateTime = LocalDateTime.now();
		LocalDateTime startDateTime = LocalDateTime.of(2020, 12, 30, 11, 28, 00);
		int travelSpeed = 60; //in kmph 
		int workingHours = 12;
		int distance = 5000; //in km
		
		System.out.println("Start date: "+startDateTime);		
		System.out.println("Travel speed: "+travelSpeed);
		System.out.println("Working hours: "+workingHours);
		System.out.println("Distance: "+distance);
		
		//choosing by road or air
		DeliveryDateInterface deliveryByRoad = new DeliveryByRoad(startDateTime, distance, workingHours, travelSpeed);
		DeliveryDateInterface deliveryByAir = new DeliveryByAir(startDateTime, distance, workingHours);
		
		CalculateDeliveryDate calculateDeliveryTime = new CalculateDeliveryDate();
		calculateDeliveryTime.setTransportMode(deliveryByRoad);
		LocalDateTime deliveryDate = calculateDeliveryTime.getDeliveryDate();
		
		System.out.println("Will be Delivered on: "+deliveryDate);
	}
}
