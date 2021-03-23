package deliverydate;

import java.time.LocalDateTime;

public class CalculateDeliveryDate {
	
	DeliveryDateInterface modeOfDelivery;
	
	CalculateDeliveryDate(){}
	
	public void setTransportMode(DeliveryDateInterface modeOfDelivery) {
		this.modeOfDelivery =  modeOfDelivery;
	}
	
	public LocalDateTime getDeliveryDate() {
		return this.modeOfDelivery.calculateDelivaryDate();
	}
	
}
