package junitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import app.Main;

public class TimeDurationShould {

	@Test
	public void exists() {
		assert(true);
	}
	
	@Test
	public void handleZero() {
        assertEquals("now", Main.formatDuration(0));
	}
	

	@Test
	public void handleOne() {
        assertEquals("1 second", Main.formatDuration(1));
	}
	

	@Test
	public void handleOneMinute() {
        assertEquals("1 minute", Main.formatDuration(60));
	}


	@Test
	public void handleOneMinutePlusSeconds() {
        assertEquals("1 minute and 2 seconds", Main.formatDuration(62));
	}
	
	@Test
	public void handleTwoMinutes() {
        assertEquals("2 minutes", Main.formatDuration(120));
	}
	
	@Test
	public void handleOneJHour() {
        assertEquals("1 hour", Main.formatDuration(3600));
	}
	
	@Test
	public void handleOneHourPlusMinutesPlusSeconds() {
        assertEquals("1 hour, 1 minute and 2 seconds", Main.formatDuration(3662));
	}
	
}
