package graphics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class recommendationsControllerTester {

	@Test
	void testReadMovieRecs() {
		recommendationsController rc = new recommendationsController();
		rc.readMovieRecFromFile();
		assertFalse(rc.listOfMovies.isEmpty());
	}
	
	@Test
	void testGenerateMovieRecs() {
		recommendationsController rc = new recommendationsController();
		rc.readMovieRecFromFile();
		String tip = rc.generateMovieRec();
		System.out.println(tip);
		assertEquals(String.class, tip.getClass());
	}
	
	@Test
	void testReadBookRecs() {
		recommendationsController rc = new recommendationsController();
		rc.readBookRecFromFile();
		assertFalse(rc.listOfBooks.isEmpty());
	}
	
	@Test
	void testGenerateBooksRecs() {
		recommendationsController rc = new recommendationsController();
		rc.readBookRecFromFile();
		String tip = rc.generateBookRec();
		System.out.println(tip);
		assertEquals(String.class, tip.getClass());
	}
	
	
	@Test
	void testReadMusicRecs() {
		recommendationsController rc = new recommendationsController();
		rc.readMusicRecFromFile();
		assertFalse(rc.listOfMusic.isEmpty());
	}
	
	@Test
	void testGenerateMusicRecs() {
		recommendationsController rc = new recommendationsController();
		rc.readBookRecFromFile();
		String tip = rc.generateMusicRec();
		System.out.println(tip);
		assertEquals(String.class, tip.getClass());
	}
}
