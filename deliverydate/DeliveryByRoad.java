package deliverydate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import deliverydate.Constants.Holidays;

public class DeliveryByRoad implements DeliveryDateInterface{

	LocalDateTime startDateTime;	
	int workingHours, travelSpeed, distance;
	
	DeliveryByRoad(LocalDateTime startDateTime, int distance, int workingHours, int travelSpeed){
		this.startDateTime = startDateTime;		
		this.workingHours = workingHours;
		this.travelSpeed = travelSpeed;
		this.distance = distance;
	}
	
	@Override
	public LocalDateTime calculateDelivaryDate() {
		//calculating total time in hours
		int distancePerDay = this.workingHours * this.travelSpeed;
		long totalHours = (long) Math.ceil(24 * this.distance / distancePerDay);
				
		//finding the delivery date assuming all are working days
		LocalDateTime endDateTime =startDateTime.plusHours(totalHours); 		
		
		//finding holidays
		List<LocalDate> dates = startDateTime.toLocalDate().datesUntil(endDateTime.toLocalDate()).collect(Collectors.toList());
		
		int holidays = 0;
		for(LocalDate date :  dates) {
			if(date.getDayOfWeek() == DayOfWeek.SUNDAY) {
				holidays++;
			}else {
				for(Holidays holiday: Holidays.values()) {
					if(holiday.getLocalDate().isEqual(date)) {
						holidays++;
					}
				}
			}
		}
		System.out.println("Holidays: "+holidays);

		//adding holidays to the delivery time
		endDateTime = endDateTime.plusDays(holidays);
		
		return endDateTime;
	}

}
