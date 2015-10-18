package org.forjavaday.skipassproject;

import java.time.LocalDateTime;

import org.forjavaday.skipassproject.skipasssystem.SkiPass;
import org.forjavaday.skipassproject.skipasssystem.SkiPassSystem;
import org.forjavaday.skipassproject.skipasssystem.Turnstile;

public class App 
{
    public static void main( String[] args ) {
    	SkiPassSystem sps = new SkiPassSystem();    	
    	SkiPass sp0 = sps.createSkiPass();
    	SkiPass sp1 = sps.createSkiPass();
    	SkiPass sp2 = sps.createSkiPass();
    	SkiPass sp3 = sps.createSkiPass();
    	Turnstile turnstile = new Turnstile();
    	turnstile.verify(sp0);
//    	sps.summaryStatisticsForPeriodGroupByType(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
    	turnstile.verify(sp0);
    	turnstile.verify(sp1);
    	turnstile.verify(sp2);
    	turnstile.verify(sp3);
//    	sps.summaryStatisticsForPeriodGroupByType(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
    	turnstile.verify(sp0);
//    	sps.summaryStatisticsForPeriodGroupByType(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
    	sps.summaryStatisticsForPeriod(LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1));
    }
}
