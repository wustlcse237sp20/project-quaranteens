package graphics;

import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Diary {
	
	private Date dateCreated;
	private String contentOfEntry;
	
	
	public Diary(Date dateCreated, String contentOfEntry) {
		this.dateCreated = dateCreated;
		this.contentOfEntry = contentOfEntry;
	}
	
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	public String getContentOfEntry() {
		return this.contentOfEntry;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public void setContentOfEntry(String contentOfEntry) {
		this.contentOfEntry = contentOfEntry;
	}
	
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
	
}
