package junitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import app.Main;

public class TimeDurationShould {

	@Test
	public void exists() {
		assert (true);
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
	public void handleMinutesPlusSeconds() {
		assertEquals("2 minutes and 2 seconds", Main.formatDuration(122));
	}

	@Test
	public void handleMinutesPlusSecond() {
		assertEquals("2 minutes and 1 second", Main.formatDuration(121));
	}
	
	@Test
	public void handleTwoMinutes() {
		assertEquals("2 minutes", Main.formatDuration(120));
	}

	@Test
	public void handleOneHour() {
		assertEquals("1 hour", Main.formatDuration(3600));
	}

	@Test
	public void handleTwoHours() {
		assertEquals("2 hours", Main.formatDuration(7200));
	}

	@Test
	public void handleOneHourPlusMinutesPlusSeconds() {
		assertEquals("1 hour, 1 minute and 2 seconds", Main.formatDuration(3662));
	}

	@Test
	public void handleOneHourPlusMinutesPlusOneSecond() {
		assertEquals("1 hour, 1 minute and 1 second", Main.formatDuration(3661));
	}

	@Test
	public void handleOneDayPlusHourPlusMinutesPlusSeconds() {
		assertEquals("1 day, 1 hour, 1 minute and 5 seconds", Main.formatDuration(90065));
	}

	@Test
	public void handleWeeksPlusMinutePlusSeconds() {
		assertEquals("1 week, 1 minute and 5 seconds", Main.formatDuration(604865));
	}

	@Test
	public void handleWeeksPlusMinutesPlusSeconds() {
		assertEquals("1 week, 2 minutes and 5 seconds", Main.formatDuration(604925));
	}

	@Test
	public void handleMonth() {
		assertEquals("1 month", Main.formatDuration(2628288));
	}
	
	@Test
	public void handleMonthPlusMinute() {
		assertEquals("1 month and 1 minute", Main.formatDuration(2628348));
	}
	
	@Test
	public void handleMonthPlusMinutePlusSecond() {
		assertEquals("1 month, 1 minute and 1 second", Main.formatDuration(2628349));
	}
		
}
