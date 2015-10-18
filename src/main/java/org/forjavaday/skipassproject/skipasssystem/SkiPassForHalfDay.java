package org.forjavaday.skipassproject.skipasssystem;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Ski-pass for half-day
 * 
 * @author Pazynych
 */
public class SkiPassForHalfDay extends SkiPass {
	
	/**
	 * Field defines half of day, first or second. 
	 */
	private final HalfOfDay HALF_OF_DAY;

	/**
	 * Enum for half of day
	 * 
	 * @author Pazynych
	 */
	public enum HalfOfDay {
		FIRST_HALF(
				LocalDateTime.of(
						LocalDate.now().getYear(),
						LocalDate.now().getMonth(),
						LocalDate.now().getDayOfMonth(),
						9, 0),
				LocalDateTime.of(
						LocalDate.now().getYear(),
						LocalDate.now().getMonth(),
						LocalDate.now().getDayOfMonth(),
						13, 0)),
		SECOND_HALF(
				LocalDateTime.of(
						LocalDate.now().getYear(),
						LocalDate.now().getMonth(),
						LocalDate.now().getDayOfMonth(),
						13, 0),
				LocalDateTime.of(
						LocalDate.now().getYear(),
						LocalDate.now().getMonth(),
						LocalDate.now().getDayOfMonth(),
						17, 0));
		
		/**
		 * Field defines start time of half
		 */
		private final LocalDateTime START_TIME;
		/**
		 * Field defines finish time of half
		 */
		private final LocalDateTime FINISH_TIME;
		
		HalfOfDay(LocalDateTime startTime, LocalDateTime finishTime) {
			this.START_TIME = startTime;
			this.FINISH_TIME = finishTime;
		}

		public LocalDateTime getStartTime() {
			return START_TIME;
		}

		public LocalDateTime getFinishTime() {
			return FINISH_TIME;
		}
				
	}
	
	SkiPassForHalfDay(long id, boolean accessForHolidays, HalfOfDay halfOfDay) {
		super(id, accessForHolidays);
		this.HALF_OF_DAY = halfOfDay;
	}
	
	public LocalDateTime getStartTime() {
		return HALF_OF_DAY.getStartTime();
	}
	
	public LocalDateTime getFinishTime() {
		return HALF_OF_DAY.getFinishTime();
	}
	
	@Override
	public String additionalInformation() {
		return "START_TIME=" + getStartTime() + ", FINISH_TIME=" + getFinishTime();
	}

	/**
	 * Method checks is current time include in corresponding half
	 */
	@Override
	protected boolean specialCheck() {
		LocalDateTime now = LocalDateTime.now();
		if (now.isAfter(getStartTime()) && now.isBefore(getFinishTime())) {
			return true;
		}
		return false;
	}

}
