package org.forjavaday.skipassproject.skipasssystem;

import static org.junit.Assert.*;

import org.forjavaday.skipassproject.skipasssystem.SkiPass;
import org.forjavaday.skipassproject.skipasssystem.SkiPassForDays;
import org.junit.Test;

public class SkiPassTest {

	@Test
	public void testVerify_IsReturnFalseIfAlreadyBlocked() {
		SkiPass skiPassForDays = new SkiPassForDays(1, false, SkiPassForDays.NumberOfDays.ONE);
		skiPassForDays.setBlocked(true);
    	assertFalse(skiPassForDays.verify());
	}
	
	@Test
	public void testVerify_IsReturnTrueIfAccessForHolidaysIsTrue() {
		SkiPass skiPassForDays = new SkiPassForDays(1, true, SkiPassForDays.NumberOfDays.ONE);
    	assertTrue(skiPassForDays.verify());
	}
}
