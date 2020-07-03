package junitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import app.Main;

public class DurationTests {

	@Test
	public void exists() {
		assert(true);
	}
	
	  @Test
	    public void exampleTests() {
	        assertEquals("1 second", Main.formatDuration(1));
	        assertEquals("1 minute and 2 seconds", Main.formatDuration(62));
	        assertEquals("2 minutes", Main.formatDuration(120));
	        assertEquals("1 hour", Main.formatDuration(3600));
	        assertEquals("1 hour, 1 minute and 2 seconds", Main.formatDuration(3662));
	    }

}
