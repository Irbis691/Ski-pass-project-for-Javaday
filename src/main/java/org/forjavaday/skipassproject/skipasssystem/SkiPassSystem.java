package org.forjavaday.skipassproject.skipasssystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class for operating hole system. It have methods for creating ski-pass of any
 * type, store statistic of usage and can provide it.
 * 
 * @author Pazynych
 */
public class SkiPassSystem {

	/**
	 * List-register of all created ski-passes.
	 */
	private static List<SkiPass> skiPasses = new ArrayList<>();
	/**
	 * Counter of created ski-passes. Need to generate ski-pass's id.
	 */
	private static long skiPassCounter = 0;
	
	/**
	 * Class represent element of statistic stored by outer class in list "statistic".
	 * 
	 * @author Pazynych
	 */
	static class StatisticlEment {
		/**
		 * Ski-pass itself
		 */
		private final SkiPass SKI_PASS;
		/**
		 * Result of verifying ski-pass by turnstile.
		 */
		private final boolean VERIFYING_RESULT;
		/**
		 * Date of verifying.
		 */
		private final LocalDateTime DATE;
		
		public StatisticlEment(SkiPass sp, boolean verifyingResult, LocalDateTime date) {
			this.SKI_PASS = sp;
			this.VERIFYING_RESULT = verifyingResult;
			this.DATE = date;
		}

		public SkiPass getSKI_PASS() {
			return SKI_PASS;
		}

		public boolean isVERIFYING_RESULT() {
			return VERIFYING_RESULT;
		}

		public LocalDateTime getDATE() {
			return DATE;
		}
				
	}
	
	/**
	 * Statistic of usage ski-passes. 
	 */
	private static List<StatisticlEment> statistic = new ArrayList<>();
	
	public SkiPassSystem() {

	}
	
	static List<StatisticlEment> getStatistic() {
		return statistic;
	}

	/**
	 * Method for creating ski-passes. It provide simple menu for user and
	 * create concrete ski-pass according to user input.
	 * 
	 * @return SkiPass that user need.
	 */
	public SkiPass createSkiPass() {			
		int userInput;
		SkiPass sp;
		boolean accessForHolidays = isNeedAccessForHolidays();
		variantsOfSkiPass();

		while (true) {
			Scanner s = new Scanner(System.in);
			if (s.hasNextInt()) {
				userInput = s.nextInt();
				switch (userInput) {
				case 1:
					sp = new SkiPassForLifts(skiPassCounter, accessForHolidays,
							SkiPassForLifts.NumberOfLifts.TEN);
					addSkiPass(sp);
					return sp;
				case 2:
					sp = new SkiPassForLifts(skiPassCounter, accessForHolidays,
							SkiPassForLifts.NumberOfLifts.TWENTY);
					addSkiPass(sp);
					return sp;
				case 3:
					sp = new SkiPassForLifts(skiPassCounter, accessForHolidays,
							SkiPassForLifts.NumberOfLifts.FIFTY);
					addSkiPass(sp);
					return sp;
				case 4:
					sp = new SkiPassForLifts(skiPassCounter, accessForHolidays,
							SkiPassForLifts.NumberOfLifts.ONE_HUNDRED);
					addSkiPass(sp);
					return sp;
				case 5:
					sp = new SkiPassForDays(skiPassCounter, accessForHolidays, SkiPassForDays.NumberOfDays.ONE);
					addSkiPass(sp);
					return sp;
				case 6:
					sp = new SkiPassForDays(skiPassCounter, accessForHolidays, SkiPassForDays.NumberOfDays.TWO);
					addSkiPass(sp);
					return sp;
				case 7:
					sp = new SkiPassForDays(skiPassCounter, accessForHolidays,
							SkiPassForDays.NumberOfDays.FIVE);
					addSkiPass(sp);
					return sp;
				case 8:
					sp = new SeasonPass(skiPassCounter, SeasonPass.Season.LOW_SEASON_BEFORE);
					addSkiPass(sp);
					return sp;
				case 9:
					sp = new SeasonPass(skiPassCounter, SeasonPass.Season.HIGHT_SEASON_NEXT_YEAR);
					addSkiPass(sp);
					return sp;
				case 10:
					sp = new SeasonPass(skiPassCounter, SeasonPass.Season.LOW_SEASON_AFTER_NEXT_YEAR);
					addSkiPass(sp);
					return sp;
				case 11:
					sp = new SkiPassForHalfDay(skiPassCounter, accessForHolidays, SkiPassForHalfDay.HalfOfDay.FIRST_HALF);
					addSkiPass(sp);
					return sp;
				case 12:
					sp = new SkiPassForHalfDay(skiPassCounter, accessForHolidays, SkiPassForHalfDay.HalfOfDay.SECOND_HALF);
					addSkiPass(sp);
					return sp;
				default:
					System.out.println("Enter number of your variant");
				}
			} else {
				System.out.println("Enter number of your variant");
			}
		}
	}

	/**
	 * Method for determining is user need access in holidays and weekends.
	 * 
	 * @return true if user need access in holidays and weekends, false
	 *         otherwise.
	 */
	private Boolean isNeedAccessForHolidays() {
		int userInput;
		Boolean accessForHolidays = null;
		System.out.print("Good day! Do you need access in holidays and weekends (if later you choose Season pass you"
				+ " will have it automaticly)?\n1. Yes\n2. No\nEnter number of your variant\n");
		while (accessForHolidays == null) {
			Scanner s = new Scanner(System.in);
			if (s.hasNextInt()) {
				userInput = s.nextInt();
				switch (userInput) {
				case 1:
					accessForHolidays = true;
					break;
				case 2:
					accessForHolidays = false;
					break;
				default:
					System.out.println("Enter number of your variant");
				}
			} else {
				System.out.println("Enter number of your variant");
			}
		}
		return accessForHolidays;
	}

	/**
	 * Method output to console menu of ski-passes for user.
	 */
	private void variantsOfSkiPass() {
		System.out.print("Choose kind of ski pass you need\n"
				+ "Ski-pass for lifts:\n"
				+ "1. 10 lifts\n"
				+ "2. 20 lifts\n"
				+ "3. 50 lifts\n"				
				+ "4. 100 lifts\n"
				+ "Ski-pass for days (counting begins from the date of first use):\n"
				+ "5. 1 day\n"
				+ "6. 2 days\n"
				+ "7. 5 days\n"
				+ "Season passes\n"
				+ "8. Since Nowember, 15 of current year till January, 1 of next year\n"
				+ "9. Since January, 2 of next year till March, 9 of next year\n"
				+ "10. Since March, 10 of next year till April, 15 of next year\n"
				+ "Ski-pass for half-day:\n"
				+ "11. First half (from 9:00 till 13:00)\n"
				+ "12. Second half (from 13:00 till 17:00)\n"
				+ "Enter number of your variant\n");
	}
	
	/**
	 * Add ski-pass to register and increment counter of ski-passes.
	 * 
	 * @param sp
	 */
	private void addSkiPass(SkiPass sp) {
		skiPasses.add(sp);
		skiPassCounter++;
	}
	
	/**
	 * Block some ski-pass.
	 * 
	 * @param sp ski-pass that need to block.
	 */
	public void blockSkiPass(SkiPass sp) {
		sp.setBlocked(true);
	}

	/**
	 * Output to console statistic of ski-pass usage during specified period
	 * 
	 * @param since - start of period
	 * @param till - end of period
	 */
	public void summaryStatisticsForPeriod(LocalDateTime since, LocalDateTime till) {
		statisticByType(since, till, "org.forjavaday.skipassproject.skipasssystem.SkiPass");		
	}

	/**
	 * Output to console statistic of ski-pass usage during specified period group by ski-pass's types.
	 * 
	 * @param since - start of period
	 * @param till - end of period
	 */
	public void summaryStatisticsForPeriodGroupByType(LocalDateTime since, LocalDateTime till) {
		System.out.println("Ski passes for number of lifts:");
		statisticByType(since, till, "org.forjavaday.skipassproject.skipasssystem.SkiPassForLifts");		
		System.out.println("Ski passes for number of days:");
		statisticByType(since, till, "org.forjavaday.skipassproject.skipasssystem.SkiPassForDays");	
		System.out.println("Season passes:");
		statisticByType(since, till, "org.forjavaday.skipassproject.skipasssystem.SeasonPass");	
		System.out.println("Ski passes for half-day:");
		statisticByType(since, till, "org.forjavaday.skipassproject.skipasssystem.SkiPassForHalfDay");	
	}

	/**
	 * Output to console statistic of usage ski-passes of specified type during specified period.
	 * 
	 * @param since - start of period.
	 * @param till - end of period.
	 * @param skiPassType - type of ski-passes that need to output.
	 */
	public void statisticByType(LocalDateTime since, LocalDateTime till, String skiPassType) {
		Class<?> clazz = null;
		try {
			clazz = Class.forName(skiPassType);
		} catch (ClassNotFoundException e) {
			System.out.println("No such type of ski-pass");
			e.printStackTrace();
		}
		for(StatisticlEment el: statistic) {
			LocalDateTime date = el.getDATE();
			if(date.isAfter(since) && date.isBefore(till) && clazz.isInstance(el.getSKI_PASS())) {
				skiPassVerifyingInfo(el);
			}
		}
	}

	/**
	 * Output to console element of statistic of ski-pass usage.
	 * @param el - element of statistic
	 */
	private void skiPassVerifyingInfo(StatisticlEment el) {
		System.out.println("Information about ski-pass\n" + el.getSKI_PASS().toString() + "\n" + "Access confirmed: "
				+ el.isVERIFYING_RESULT() + ". Date of verifying: " + el.getDATE());
	}

}
