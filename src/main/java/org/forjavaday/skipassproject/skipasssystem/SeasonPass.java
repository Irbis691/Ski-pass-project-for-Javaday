package org.forjavaday.skipassproject.skipasssystem;

import java.time.LocalDate;
import java.time.Month;

/**
 * Class for season passes.
 * 
 * @author Pazynych
 */
public class SeasonPass extends SkiPass {
	
	/**
	 * Field defines concrete season
	 */
	private final Season SEASON;
	
	/**
	 * Enum for all kinds of seasons.
	 * 
	 * @author Pazynych
	 */
	public enum Season {
		
		LOW_SEASON_BEFORE(LocalDate.of(LocalDate.now().getYear(), Month.NOVEMBER, 15),
				LocalDate.of(LocalDate.now().getYear() + 1, Month.JANUARY, 1)),
		HIGHT_SEASON_NEXT_YEAR(LocalDate.of(LocalDate.now().getYear() + 1, Month.JANUARY, 2),
				LocalDate.of(LocalDate.now().getYear() + 1, Month.MARCH, 9)),
		LOW_SEASON_AFTER_NEXT_YEAR(LocalDate.of(LocalDate.now().getYear() + 1, Month.MARCH, 10),
				LocalDate.of(LocalDate.now().getYear() + 1, Month.APRIL, 15));

		/**
		 * Start date of the season 
		 */
		private final LocalDate START_DATE;
		
		/**
		 * Finish date of the season 
		 */
		private final LocalDate FINISH_DATE;
		
		Season(LocalDate startDate, LocalDate finishDate) {
			this.START_DATE = startDate;
			this.FINISH_DATE = finishDate;
		}

		public LocalDate getStartDate() {
			return START_DATE;
		}

		public LocalDate getFinishDate() {
			return FINISH_DATE;
		}
				
	}
	
	SeasonPass(long skiPassId, Season season) {
		super(skiPassId, true);
		this.SEASON = season;
	}
	
	public LocalDate getStartOfSeason() {
		return SEASON.getStartDate();
	}
	
	public LocalDate getFinishOfSeason() {
		return SEASON.getFinishDate();
	}
	
	@Override
	public String additionalInformation() {
		return "START_DATE=" + getStartOfSeason() + ", FINISH_DATE=" + getFinishOfSeason();
	}

	/**
	 * Method checks is today's date is included in season
	 */
	@Override
	protected boolean specialCheck() {
		LocalDate now = LocalDate.now();
		if (now.isAfter(getStartOfSeason()) && now.isBefore(getFinishOfSeason())) {
			return true;
		}
		return false;
	}

}
