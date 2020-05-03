package graphics;

import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Diary {
	
	private Date dateCreated;
	private String contentOfEntry;
	private String filePath = "src/docs.DiaryEntries/diaryEntry.txt";
	
	public Diary(Date dateCreated, String contentOfEntry) {
		this.dateCreated = dateCreated;
		this.contentOfEntry = contentOfEntry;
	}
	
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	public String dateToString() {
		@SuppressWarnings("deprecation")
		String dateToString = this.dateCreated.toString();
		return dateToString;
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
}
