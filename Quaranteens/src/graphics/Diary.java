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
	
}
