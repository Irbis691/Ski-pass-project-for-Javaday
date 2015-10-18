package org.forjavaday.skipassproject.skipasssystem;

import java.time.LocalDateTime;
import java.util.List;

import org.forjavaday.skipassproject.skipasssystem.SkiPassSystem.StatisticlEment;

/**
 * Class represents a turnstile that verify ski-passes and make records about
 * the use of ski-passes.
 * 
 * @author Pazynych
 */
public class Turnstile {
	
	/**
	 * Field for access to "statistic database" in SkiPassSystem class.
	 */
	private static List<StatisticlEment> statistic = SkiPassSystem.getStatistic();
	
	public Turnstile() {
		
	}
	
	/**
	 * Method verify ski-pass and  make records about verifying.
	 * 
	 * @param skiPass
	 * @return true if verifying passed and false otherwise.
	 */
	public boolean verify(SkiPass skiPass) {
		boolean verifyingResult = skiPass.verify();
		statistic.add(new SkiPassSystem.StatisticlEment(skiPass.clone(), verifyingResult, LocalDateTime.now()));
		return verifyingResult;
	}

}
