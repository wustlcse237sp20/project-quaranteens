package graphics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DiaryManager {
	
	private String path = "src/diaryEntries/diaryEntry.txt";
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
	
	public void saveDiaryEntryToFile(String contentOfDiaryEntry) {
		try {
				File diaryFile = new File(path);
				FileWriter fileWriterForDiary = new FileWriter(diaryFile, true);
				BufferedWriter diaryToFile = new BufferedWriter(fileWriterForDiary); 
				diaryToFile.write("\n" + contentOfDiaryEntry);
				diaryToFile.close();
				}
			catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public Diary prevDiaryEntry() {
			int index = this.indexOfDiaryEntry;
				index = index - 1;
			if (index < 0) {
			index = 0;
			}
			this.setIndexOfDiaryEntry(index);
			this.setIndexOfPrevEntry(index - 1);
			return this.listOfEntries.get(index);
	}
	
	public Diary nextDiaryEntry() {
		Diary nextEntry = this.listOfEntries.get(this.indexOfDiaryEntry);
		if (this.indexOfDiaryEntry + 1 < this.listOfEntries.size()) {
			int index = this.indexOfDiaryEntry;
			index = index + 1;
			nextEntry = this.listOfEntries.get(index);
			this.setIndexOfDiaryEntry(index);
			return nextEntry;
		}
		else {
			return nextEntry;
		}
	}
	
	public void deleteDiaryEntry(int indexOfDiaryEntry) {
		this.listOfEntries.remove(this.indexOfDiaryEntry);
		
	}
}