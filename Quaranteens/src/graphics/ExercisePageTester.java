package graphics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class exercisePageTester {

	@Test
	void testReadExerciseRecs() {
		exercisePage ep = new exercisePage();
		ep.readExerciseFromFile();
		assertFalse(ep.listOfExercises.isEmpty());
	}
	
	@Test
	void testGenerateExercise() {
		exercisePage ep = new exercisePage();
		ep.readExerciseFromFile();
		String sampleExercise = ep.generateExerciseRec();
		System.out.println(sampleExercise);
		assertEquals(String.class, sampleExercise.getClass());
	}
	
	@Test
	void testExerciseRandom() {
		exercisePage ep = new exercisePage();
		ep.readExerciseFromFile();
		String sampleExercise = ep.generateExerciseRec();
		assertNotSame(sampleExercise, ep.generateExerciseRec());
	}
	
}