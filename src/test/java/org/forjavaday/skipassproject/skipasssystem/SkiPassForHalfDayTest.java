package org.forjavaday.skipassproject.skipasssystem;

import static org.junit.Assert.assertTrue;

import org.forjavaday.skipassproject.skipasssystem.SkiPassForHalfDay;
import org.junit.Test;

public class SkiPassForHalfDayTest {
	
	@Test
	public void testVerify_IsReturnTrueIfCorrespondingTimeIsNow() {
		SkiPassForHalfDay skiPassForHalfDay = new SkiPassForHalfDay(1, true, SkiPassForHalfDay.HalfOfDay.FIRST_HALF);
		assertTrue(skiPassForHalfDay.verify());
	}

}
