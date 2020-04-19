package graphics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DiaryManager {
	
	private String path = "src/docs.DiaryEntries/diaryEntry";
	public ArrayList<Diary> listOfEntries = new ArrayList<Diary>();
	public int indexOfDiaryEntry;
	public int indexOfPrevEntry;
	
	public DiaryManager() {
		this.indexOfDiaryEntry = 0;
		this.indexOfPrevEntry = 0;
	}
	
	
	public void addDiaryEntry(Diary entryToSave) {
		this.listOfEntries.add(entryToSave);
		this.indexOfDiaryEntry = this.indexOfDiaryEntry + 1;
	}
	
	public void saveDiaryEntry(Diary entryToSave) {
		addDiaryEntry(entryToSave);
		for (int i = 0; i < this.listOfEntries.size(); i++) {
			this.listOfEntries.get(i).writeToFile(entryToSave);
		}
	}
	
	public Diary prevDiaryEntry() {
		int index = this.indexOfDiaryEntry;
		index = index - 2;
		if (index < 0) {
			index = 0;
		}
		this.indexOfPrevEntry = index;
		return this.listOfEntries.get(index);
	}
	
	public Diary nextDiaryEntry() {
		Diary nextEntry = this.listOfEntries.get(this.indexOfDiaryEntry);
		if (this.indexOfPrevEntry >= this.indexOfDiaryEntry) {
		}
		else {
			int index = this.indexOfPrevEntry;
			index = index + 2;
			nextEntry = this.listOfEntries.get(index);
			return nextEntry;
		}
		return null;
	}
	
	public void deleteDiaryEntry(Diary entryToRemove) {
		this.listOfEntries.remove(entryToRemove);
		this.indexOfDiaryEntry = this.indexOfDiaryEntry - 1;
		
	}
}
