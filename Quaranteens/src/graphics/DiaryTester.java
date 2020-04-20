package graphics;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class DiaryTester {
	
	public Date currentDate = new Date();
	
    @Test
	void testAddDiaryEntry() {
		
	}
	
    @Test
	void testSaveDiaryEntry() {
		
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
		assertEquals(dm.listOfEntries.get(3), dm.prevDiaryEntry());
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
    	
	}
}
