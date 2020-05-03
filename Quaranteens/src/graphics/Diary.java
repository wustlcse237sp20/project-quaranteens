package graphics;

import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Diary {
	
	private Date dateCreated;
	private String contentOfEntry;
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime localTimeForDateOfEntry = LocalDateTime.now();
    String currentDate = dateTimeFormatter.format(localTimeForDateOfEntry);
	
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
	
public void writeToFile(Diary diaryEntry) {
		
		try {
			File diaryEntries = new File("DiaryEntries");
			diaryEntries.createNewFile();
			FileWriter writingDiaryEntries = new FileWriter(diaryEntries, false);
			writingDiaryEntries.write(diaryEntry.getContentOfEntry());
			
			}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
