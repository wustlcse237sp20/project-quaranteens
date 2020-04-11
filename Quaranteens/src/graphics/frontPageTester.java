package graphics;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class frontPageTester {

	@Test
	void testUpdateDayCounter() {
		frontPage fp = new frontPage();
		fp.updateDayCounter();
		int dayChange = 0;
		
		//this just tests for today's date
		assertEquals (26, fp.counterOfTheDay);	
	}
	
	
	@Test
	void testGenerateTipOfTheDay() {
		frontPage fp = new frontPage();
		String tip = fp.generateTipOfTheDay();
		System.out.println(tip);
		assertEquals(String.class, tip.getClass());
	}
	

}
