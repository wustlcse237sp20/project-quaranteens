package graphics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DiaryManager {
	
	private String path = "src/docs.DiaryEntries/diaryEntry";
	public ArrayList<Diary> listOfEntries = new ArrayList<Diary>();
	
	
	public void addDiaryEntry(Diary entryToSave) {
		this.listOfEntries.add(entryToSave);
	}
	
	public void saveDiaryEntry(Diary entryToSave) {
		addDiaryEntry(entryToSave);
		for (int i = 0; i < this.listOfEntries.size(); i++) {
			this.listOfEntries.get(i).writeToFile();
		}
	}
	
	public void prevDiaryEntry() {
		
	}
	public void nextDiaryEntry() {
		
	}
	
	public void deleteDiaryEntry() {
		
	}
}
