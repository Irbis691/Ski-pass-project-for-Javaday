package org.forjavaday.skipassproject.skipasssystem;

import org.junit.Test;

import static org.junit.Assert.*;

import org.forjavaday.skipassproject.skipasssystem.SkiPass;
import org.forjavaday.skipassproject.skipasssystem.SkiPassForDays;
import org.forjavaday.skipassproject.skipasssystem.SkiPassSystem;
import org.forjavaday.skipassproject.skipasssystem.Turnstile;

public class TurnstileTest {

	@Test
	public void testVerify_IsAddVerifyingToStatistic() {
		SkiPass sp = new SkiPassForDays(1, true, SkiPassForDays.NumberOfDays.ONE);
		Turnstile t = new Turnstile();
		t.verify(sp);		
		assertEquals(1, SkiPassSystem.getStatistic().size());
	}

}
