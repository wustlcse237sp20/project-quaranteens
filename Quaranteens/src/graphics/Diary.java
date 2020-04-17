package graphics;

import java.util.Date;

import java.io.FileWriter;

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
	
}
