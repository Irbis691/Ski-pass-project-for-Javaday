package org.forjavaday.skipassproject.skipasssystem;

/**
 * Ski-pass for specified number of lifts.
 * 
 * @author Pazynych
 */
public class SkiPassForLifts extends SkiPass {	
	
	/**
	 * Field defines number of lifts that have already been made.
	 */
	private int counter;
	/**
	 * Field defines number of lifts that ski-pass allows to make.
	 */
	private final NumberOfLifts NUMBER_OF_LIFTS;
	
	/**
	 * Enum for all numbers of lifts
	 * 
	 * @author Pazynych
	 */
	public enum NumberOfLifts {
		TEN(10),
		TWENTY(20),
		FIFTY(50),
		ONE_HUNDRED(100);
		
		/**
		 * Field defines number of lifts that ski-pass allows to make.
		 */
		private final int NUMBER_OF_LIFTS;
		
		NumberOfLifts(int numberOfLifts) {
			this.NUMBER_OF_LIFTS = numberOfLifts;
		}

		public int getNumberOfLifts() {
			return NUMBER_OF_LIFTS;
		}
				
	}
	
	SkiPassForLifts(long skiPassId, boolean accessForHolidays, NumberOfLifts numberOfLifts) {
		super(skiPassId, accessForHolidays);
		this.NUMBER_OF_LIFTS = numberOfLifts;
	}

	/**
	 * Method count remaining number of lifts
	 * 
	 * @return remaining number of lifts
	 */
	public int getNumberOfLiftsLeft() {
		return NUMBER_OF_LIFTS.getNumberOfLifts() - counter;
	}
	
	@Override
	public String additionalInformation() {
		return "NUMBER_OF_LIFTS=" + NUMBER_OF_LIFTS + ", NumberOfLiftsLeft=" + getNumberOfLiftsLeft();
	}
	
	/**
	 * Method checks ski-pass balance of lifts.
	 */
	@Override
	protected boolean specialCheck() {
		++counter;
		if (getNumberOfLiftsLeft() >= 0) {
			return true;
		}
		return false;
	}

}
