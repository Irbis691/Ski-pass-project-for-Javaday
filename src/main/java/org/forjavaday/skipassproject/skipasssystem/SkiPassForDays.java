package org.forjavaday.skipassproject.skipasssystem;

import java.time.LocalDate;

/**
 * Ski-pass for specified number of days. 
 * Counting begins from the date of first use.
 * 
 * @author Pazynych
 */
public class SkiPassForDays extends SkiPass {

	/**
	 * Field defines is this ski-pass been activated.
	 */
	private boolean activated;	
	/**
	 * Field defines number of days during which ski-pass will work.
	 */
	private final NumberOfDays NUMBER_OF_DAYS;
	/**
	 * Field defines date when ski-pass stop work.
	 */
	private LocalDate blockDate;	
	
	/**
	 * Enum for all variants of ski-pass for days.
	 * 
	 * @author Pazynych
	 */
	public enum NumberOfDays {
		ONE(1),
		TWO(2),
		FIVE(5);
		
		/**
		 * Number of days during which ski-pass will work.
		 */
		private final int numberOfDays;
		
		NumberOfDays(int numberOfDays) {
			this.numberOfDays = numberOfDays;
		}

		public int getNumberOfDays() {
			return numberOfDays;
		}
		
	}
	
	SkiPassForDays(long skiPassId, boolean accessForHolidays, NumberOfDays numberOfDays) {
		super(skiPassId, accessForHolidays);
		this.NUMBER_OF_DAYS = numberOfDays; 
	}

	public LocalDate getBlockDate() {
		return blockDate;
	}
	
	public int getNumberOfDays() {
		return NUMBER_OF_DAYS.getNumberOfDays();
	}
	
	public boolean isActivated() {
		return activated;
	}
	
	@Override
	public String additionalInformation() {
		return "NUMBER_OF_DAYS=" + NUMBER_OF_DAYS + ", blockDate=" + blockDate;
	}

	/**
	 * Method activate ski-pass if it is its first check. Then it checks is todays's
	 * date before block date.
	 */
	@Override
	protected boolean specialCheck() {
		if (!isActivated()) {
			activate();
		}
		if (LocalDate.now().isBefore(getBlockDate())) {
			return true;
		}
		return false;
	}
	

	/**
	 * Method activate ski-pass, set field blockDate. If this ski-pass hasn't
	 * access for holidays additional number of days counted and added to block
	 * date. In this way ski-pass will work correct number of days excluding
	 * holidays.
	 */
	private void activate() {
		setStartUse(true);
		if(isAccessForHolidays()) {
			this.blockDate = LocalDate.now().plusDays(NUMBER_OF_DAYS.getNumberOfDays());
		} else {
			this.blockDate = LocalDate.now().plusDays(NUMBER_OF_DAYS.getNumberOfDays() + countAdditionalDays());
		}
		
	}
	
	private void setStartUse(boolean startUse) {
		this.activated = startUse;
	}

	/**
	 * Method defines is days during which ski-pass will work are holidays and
	 * if it is increment counter for increasing block date.
	 * 
	 * @return number of additional days
	 */
	private int countAdditionalDays() {
		int additionalDays = 0;
		for(int i = 0; i < getNumberOfDays(); i++) {
			while(checkForHolidays(LocalDate.now().plusDays(i))) {
				additionalDays++;
				i++;
			}
		}
		return additionalDays;
	}	
	
}
