package org.forjavaday.skipassproject.skipasssystem;

import org.junit.Test;

import static org.junit.Assert.*;

import org.forjavaday.skipassproject.skipasssystem.SkiPassForLifts;

public class SkiPassForLiftsTest {
	
    @Test
    public void testVerify_IsReturnTrueIfNotBlockedAndLiftsStillHave() {
    	SkiPassForLifts skiPassForLifts = new SkiPassForLifts(1, true, SkiPassForLifts.NumberOfLifts.TEN);    	
    	assertTrue(skiPassForLifts.verify());
    }
    
    @Test
    public void testVerify_IsReturnFalseIfLiftsNotLeft() {
    	SkiPassForLifts skiPassForLifts = new SkiPassForLifts(1, true, SkiPassForLifts.NumberOfLifts.TEN);   
    	for(int i = 0; i < 10; i++) {
    		skiPassForLifts.verify();
    	}
    	assertFalse(skiPassForLifts.verify());
    }
    
    @Test
    public void testVerify_IsSetBlockIfLiftsNotLeft() {
    	SkiPassForLifts skiPassForLifts = new SkiPassForLifts(1, true, SkiPassForLifts.NumberOfLifts.TEN);   
    	for(int i = 0; i < 11; i++) {
    		skiPassForLifts.verify();
    	}
    	assertTrue(skiPassForLifts.isBlocked());
    }
    
    @Test
    public void testGetNumberOfLiftsLeft_IsWorkCorrectly() {
    	SkiPassForLifts skiPassForLifts = new SkiPassForLifts(1, true, SkiPassForLifts.NumberOfLifts.TEN);  
    	skiPassForLifts.verify();
    	int expected = 9;
    	assertEquals(expected, skiPassForLifts.getNumberOfLiftsLeft());
    }
}
