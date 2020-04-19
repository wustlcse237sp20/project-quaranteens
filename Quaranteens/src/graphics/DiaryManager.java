package graphics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DiaryManager {
	
	private String path = "src/docs.DiaryEntries/sample.txt";
	
	
	public void writeToFile() {
		
		File diaryEntries = new File(path);
		try {
			FileWriter writingDiaryEntries = new FileWriter(diaryEntries, true);
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
