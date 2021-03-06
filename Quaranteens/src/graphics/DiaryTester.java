package graphics;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class DiaryTester {
	
	public Date currentDate = new Date();

    @Test
	void testAddDiaryEntry() {
		DiaryManager dm = new DiaryManager();
		Diary diary1 = new Diary(currentDate, "hi");
		dm.addDiaryEntry(diary1);
		assertTrue(dm.listOfEntries.contains(diary1));
		assertEquals(1, dm.getIndexOfDiaryEntry());
	}
	
    @Test
	void testSaveDiaryEntryToFile() {
    	DiaryManager dm = new DiaryManager();
    	String path = "src/diaryEntries/diaryEntry.txt";
    	dm.saveDiaryEntryToFile("test");
    	try {
    		BufferedReader readDiaryEntry = new BufferedReader (new FileReader(path));
    		String line = readDiaryEntry.readLine();
    		if (line.isEmpty()) {
    			fail("This is not empty");
    		}
    		readDiaryEntry.close();
    	}
    	catch (IOException e) {
			e.printStackTrace();
		}
    
	}
	
    @Test
	void testPrevDiaryEntry() {
	
    	DiaryManager dm = new DiaryManager();
		Diary diary1 = new Diary(currentDate, "hi");
		Diary diary2 = new Diary(currentDate, "Hello");
		Diary diary3 = new Diary(currentDate, "bye");
		Diary diary4 = new Diary(currentDate, "heya");
		Diary diary5 = new Diary(currentDate, "Bread sucks");
		dm.addDiaryEntry(diary1);
		dm.addDiaryEntry(diary2);
		dm.addDiaryEntry(diary3);
		dm.addDiaryEntry(diary4);
		dm.addDiaryEntry(diary5);
		assertEquals(dm.listOfEntries.get(4), dm.prevDiaryEntry());
		dm.setIndexOfDiaryEntry(2);
		assertEquals(dm.listOfEntries.get(1), dm.prevDiaryEntry());
	}
	
    @Test
	void testNextDiaryEntry() {
		
    	DiaryManager dm = new DiaryManager();
		Diary diary1 = new Diary(currentDate, "hi");
		Diary diary2 = new Diary(currentDate, "Hello");
		Diary diary3 = new Diary(currentDate, "bye");
		Diary diary4 = new Diary(currentDate, "heya");
		Diary diary5 = new Diary(currentDate, "Bread sucks");
		dm.addDiaryEntry(diary1);
		dm.addDiaryEntry(diary2);
		dm.addDiaryEntry(diary3);
		dm.addDiaryEntry(diary4);
		dm.addDiaryEntry(diary5);
		dm.setIndexOfDiaryEntry(3);
		dm.setIndexOfPrevEntry(2);
		assertEquals(dm.listOfEntries.get(4), dm.nextDiaryEntry());
		dm.setIndexOfDiaryEntry(1);
		dm.setIndexOfPrevEntry(0);
		assertEquals(dm.listOfEntries.get(2), dm.nextDiaryEntry());
	
	}
	
    @Test
	void testDeleteDiaryEntry() {
    	DiaryManager dm = new DiaryManager();
		Diary diary1 = new Diary(currentDate, "hi");
		Diary diary2 = new Diary(currentDate, "Hello");
		dm.addDiaryEntry(diary1);
		dm.addDiaryEntry(diary2);
		dm.setIndexOfDiaryEntry(1);
		dm.deleteDiaryEntry(dm.indexOfDiaryEntry);
		assertFalse(dm.listOfEntries.contains(diary2));
		assertEquals(1, dm.getIndexOfDiaryEntry());
	}
}