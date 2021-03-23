package deliverydate;


import java.time.LocalDateTime;


public class DeliveryByAir implements DeliveryDateInterface{

	LocalDateTime startDateTime;	
	int workingHours, travelSpeed, distance;
	
	DeliveryByAir(LocalDateTime startDateTime, int distance, int workingHours){
		this.startDateTime = startDateTime;		
		this.workingHours = workingHours;
		this.travelSpeed = 900;
		this.distance = distance;
	}
	
	@Override
	public LocalDateTime calculateDelivaryDate() {
		//calculating total time in hours
		int distancePerDay = this.workingHours * this.travelSpeed;
		long totalHours = (long) Math.ceil(24 * this.distance / distancePerDay);
				
		//finding the delivery date assuming all are working days
		LocalDateTime endDateTime =startDateTime.plusHours(totalHours); 
		
		return endDateTime;
	}

}
