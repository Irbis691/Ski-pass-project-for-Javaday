package org.forjavaday.skipassproject.skipasssystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Basic class for ski-pass entity. Abstract, not full.
 * Contains general fields and methods.
 * 
 * @author Pazynych
 *
 */
public abstract class SkiPass implements Cloneable {

	/**
	 * Id - unique identifier of ski-pass .
	 */
	private final long SKI_PASS_ID;
	/**
	 * Field defines is this ski-pass blocked, false after creation.
	 */
	private boolean blocked;
	/**
	 * Field responsible for access in holidays and weekends.
	 */
	private final boolean ACCESS_FOR_HOLIDAYS;
		
	/**
	 * Date of New Year holiday 
	 */
	private final LocalDate NEW_YEAR = LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, 31);
	
	/**
	 * List of holidays
	 */
	private final List<LocalDate> HOLIDAYS = new ArrayList<LocalDate>() {
		{
			add(NEW_YEAR);
		}
	};
	
	public SkiPass(long skiPassId, boolean accessForHolidays) {
		this.SKI_PASS_ID = skiPassId;
		this.blocked = false;
		this.ACCESS_FOR_HOLIDAYS = accessForHolidays;
	}

	public long getSkiPassId() {
		return SKI_PASS_ID;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public boolean isAccessForHolidays() {
		return ACCESS_FOR_HOLIDAYS;
	}
	
	/**
	 * Method add new holiday to list of holidays.
	 * 
	 * @param ld
	 */
	public void addHoliday(LocalDate holiday) {
		HOLIDAYS.add(holiday);
	}
	
	@Override
	public String toString() {
		String result = "SKI_PASS_ID=" + SKI_PASS_ID + ", blocked=" + blocked + ", ACCESS_FOR_HOLIDAYS="
				+ ACCESS_FOR_HOLIDAYS;
		result += ", " + additionalInformation();
		return result;
	}
	
	public SkiPass clone() {
		SkiPass sp = null;
		try {
			sp =  (SkiPass) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return sp;
	}

	/**
	 * Method for appending additional information about concrete type of
	 * ski-pass to standard description.
	 * 
	 * @return String with additional information
	 */
	public abstract String additionalInformation();

	/**
	 * Method check data from ski-pass for allowing or denial of pass. Also it
	 * set block field to "true" if resources of ski-pass are finished.
	 * 
	 * @return true if all correct, false otherwise.
	 */
	public boolean verify() {
		if (standartCheck()) {
			if (specialCheck()) {
				return true;
			} else {
				setBlocked(true);
			}			
		}
		return false;
	}
	
	/**
	 * Method check is ski-pass already blocked and is it has access for
	 * holidays and weekends if today holiday or weekend.
	 * 
	 * @return true if all correct, false otherwise.
	 */
	private boolean standartCheck() {
		if (isBlocked() || (checkForHolidays(LocalDate.now()) && !isAccessForHolidays())) {
			return false;
		} 
		return true;
	}
	
	/**
	 * Method check is argument weekend or holiday.
	 * 
	 * @param date - some date
	 * @return true if checked date is weekend or holiday, false otherwise.
	 */
	boolean checkForHolidays(LocalDate date) {
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		if (dayOfWeek == DayOfWeek.SUNDAY || dayOfWeek == DayOfWeek.SATURDAY || HOLIDAYS.contains(date)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Method check some specials conditions of concrete ski-pass
	 * 
	 * @return true if 
	 */
	protected abstract boolean specialCheck();
	
}
