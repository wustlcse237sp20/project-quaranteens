package graphics;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class frontPageTester {

	@Test
	void testUpdateDayCounter() {
		frontPage fp = new frontPage();
		fp.updateDayCounter();
		int dayCounter = 31;
		double currentTime = System.currentTimeMillis(), nextTime;
			if ((nextTime = System.currentTimeMillis()) - currentTime >= 1000*60*60*24) {
				dayCounter = dayCounter + 1;
			}
			currentTime = nextTime;
		assertEquals (dayCounter, fp.counterOfTheDay);

	}
	
	
	@Test
	void testGenerateTipOfTheDay() {
		frontPage fp = new frontPage();
		String tip = fp.generateTipOfTheDay();
		System.out.println(tip);
		assertEquals(String.class, tip.getClass());
	}
	
	@Test
	void testSetRandomValueOfProgressBar() {
		frontPage fp = new frontPage();
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

