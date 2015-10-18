package org.forjavaday.skipassproject.skipasssystem;

import org.junit.Test;

import static org.junit.Assert.*;

import org.forjavaday.skipassproject.skipasssystem.SeasonPass;

public class SeasonPassTest {
	
	@Test
	public void testVerify_IsReturnFalseIfCorrespondingSesonIsNotNow() {
		SeasonPass seasonPass = new SeasonPass(1, SeasonPass.Season.HIGHT_SEASON_NEXT_YEAR);
		assertFalse(seasonPass.verify());
	}

	@Test
	public void testVerify_IsSetBlockIfCorrespondingSesonIsNotNow() {
		SeasonPass seasonPass = new SeasonPass(1, SeasonPass.Season.HIGHT_SEASON_NEXT_YEAR);
		seasonPass.verify();
		assertTrue(seasonPass.isBlocked());
	}
	
}
