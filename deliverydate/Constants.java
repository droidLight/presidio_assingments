package deliverydate;

import java.time.LocalDate;
import java.time.Month;

public class Constants {

	public static enum Holidays {
		JAN_1(LocalDate.of(2021, Month.JANUARY, 1)), JAN_26(LocalDate.of(2021, Month.JANUARY, 26)),
		AUG_15(LocalDate.of(2021, Month.AUGUST, 15)), OCT_12(LocalDate.of(2021, Month.OCTOBER, 2));

		private LocalDate localDate;

		private Holidays(LocalDate localDate) {
			this.localDate = localDate;
		}
		
		public LocalDate getLocalDate() {
			return this.localDate;
		}
	}
}
