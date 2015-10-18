package org.forjavaday.skipassproject.skipasssystem;

import org.forjavaday.skipassproject.skipasssystem.SkiPassForDays;
import org.junit.Test;

import static org.junit.Assert.*;

import java.time.LocalDate;

public class SkiPassForDaysTest {

	@Test
	public void testVerify_IsSetStartUseAfterFirstVerifying() {
		SkiPassForDays skiPassForDays = new SkiPassForDays(1, true, SkiPassForDays.NumberOfDays.ONE);   
		skiPassForDays.verify();
    	assertTrue(skiPassForDays.isActivated());
	}
	
	@Test
	public void testVerify_IsSetBlockedDateCorrectlyAfterFirstVerifying() {
		SkiPassForDays skiPassForDays = new SkiPassForDays(1, true, SkiPassForDays.NumberOfDays.ONE);  
		skiPassForDays.verify();
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		assertEquals(tomorrow, skiPassForDays.getBlockDate());
	}
	
	@Test
    public void testVerify_IsReturnTrueIfNotBlockedAndBlockDateDoNotCome() {
		SkiPassForDays skiPassForDays = new SkiPassForDays(1, true, SkiPassForDays.NumberOfDays.ONE);    	
    	assertTrue(skiPassForDays.verify());
    }
	
	@Test
    public void testVerify_IsReturnFalseIfBlockDateCome() {
		SkiPassForDays skiPassForDays = new SkiPassForDays(1, true, SkiPassForDays.NumberOfDays.ONE);
		skiPassForDays.verify();
		skiPassForDays.getBlockDate().minusDays(1);
    	assertFalse(skiPassForDays.verify());
    }
	
	@Test
    public void testVerify_IsSetBlockIfBlockDateCome() {
		SkiPassForDays skiPassForDays = new SkiPassForDays(1, true, SkiPassForDays.NumberOfDays.ONE);
		skiPassForDays.verify();
		skiPassForDays.getBlockDate().minusDays(1);
		skiPassForDays.verify();
    	assertTrue(skiPassForDays.isBlocked());
    }
}
