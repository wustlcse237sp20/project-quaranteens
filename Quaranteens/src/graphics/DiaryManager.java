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
	
	public String getPath() {
		return this.path;
	}
	
	public ArrayList<Diary> getListOfEntries() {
		return this.listOfEntries;
	}
	
	public int getIndexOfDiaryEntry() {
		return this.indexOfDiaryEntry;
	}
	
	public int getIndexOfPrevEntry() {
		return this.indexOfPrevEntry;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public void setListOfEntries(ArrayList<Diary> listOfEntries) {
		this.listOfEntries = listOfEntries;
	}
	
	public void setIndexOfDiaryEntry(int indexOfDiaryEntry) {
		this.indexOfDiaryEntry = indexOfDiaryEntry;
	}
	
	public void setIndexOfPrevEntry(int indexOfPrevEntry) {
		this.indexOfPrevEntry = indexOfPrevEntry;
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
		this.setIndexOfPrevEntry(index);
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
