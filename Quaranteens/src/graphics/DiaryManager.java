package graphics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DiaryManager {
	
	private String path = "src/docs.DiaryEntries/diaryEntry";
	
	
	public void writeToFile() {
		
		
		try {
			File diaryEntries = new File("allDiaryEntries");
			diaryEntries.createNewFile();
			FileWriter writingDiaryEntries = new FileWriter(diaryEntries, false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addDiaryEntry() {
		
	}
	
	public void saveDiaryEntry() {
		
	}
	
	public void prevDiaryEntry() {
		
	}
	public void nextDiaryEntry() {
		
	}
	
	public void deleteDiaryEntry() {
		
	}
}
