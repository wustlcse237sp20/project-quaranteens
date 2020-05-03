package graphics;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class FrontPageTester {

	@Test
	void testUpdateDayCounter() {
		FrontPage fp = new FrontPage();
		fp.updateDayCounter();
		@SuppressWarnings("deprecation")
		Date openingDate = new Date(120, 2, 11);
		long currentTimeInMillis = System.currentTimeMillis();
		long millisSinceProgramStarted = currentTimeInMillis - openingDate.getTime();
		long millisToSeconds = millisSinceProgramStarted / 1000;
		long secondsToMinutes = millisToSeconds / 60;
		long minutesToHours = secondsToMinutes / 60;
		int hoursToDays = (int)minutesToHours / 24;
		int numOfDaysSinceProgramStarted = hoursToDays;
		assertEquals (numOfDaysSinceProgramStarted, fp.counterOfTheDay);
	}
	
	@Test
	void testGenerateTipOfTheDay() {
		FrontPage fp = new FrontPage();
		fp.readTipFromFile();
		String tip = fp.generateTipOfTheDay();
		System.out.println(tip);
		assertEquals(String.class, tip.getClass());
	}
	
	@Test
	void testReadTipOfTheDay() {
		FrontPage fp = new FrontPage();
		fp.readTipFromFile();
		assertFalse (fp.listOfTips.isEmpty());
	}
	
	@Test
	void testSetRandomValueOfProgressBar() {
		FrontPage fp = new FrontPage();
		int value = fp.setRandomValueOfProgressBar();
		if (value > 100) {
			fail ("This value is too high");
		}
		if (value < 0) {
			fail ("This value is too low");
		}
		if (value > fp.getCounterOfTheDay()) {
			fail ("This value is above counter of the day!");
		}
	}
}

