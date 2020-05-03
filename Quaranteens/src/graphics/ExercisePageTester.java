package graphics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExercisePageTester {

	@Test
	void testReadExerciseRecs() {
		ExercisePage ep = new ExercisePage();
		ep.readExerciseFromFile();
		assertFalse(ep.listOfExercises.isEmpty());
	}
	
	@Test
	void testGenerateExercise() {
		ExercisePage ep = new ExercisePage();
		ep.readExerciseFromFile();
		String sampleExercise = ep.generateExerciseRec();
		System.out.println(sampleExercise);
		assertEquals(String.class, sampleExercise.getClass());
	}
	
	@Test
	void testExerciseRandom() {
		ExercisePage ep = new ExercisePage();
		ep.readExerciseFromFile();
		String sampleExercise = ep.generateExerciseRec();
		assertNotSame(sampleExercise, ep.generateExerciseRec());
		if (sampleExercise == ep.generateExerciseRec()) {
			System.out.println("The same message was generated twice. Please run the test again. If this happens a second time then something is wrong.");
		}
	}
	
}