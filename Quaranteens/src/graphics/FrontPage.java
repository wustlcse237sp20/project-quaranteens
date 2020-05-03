package graphics;
import java.util.Date;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class FrontPage {

	private String tipOfTheDay;
	private String movieOfTheDay;
	public int counterOfTheDay;
	public ArrayList<String> listOfTips;
	public ArrayList<String> listOfMovies;
	private int progressBarPercentage;
	
	//openingDate is when WashU kicked us out - Sad
	@SuppressWarnings("deprecation")
	public Date openingDate = new Date(120, 2, 11);
	public Date currentDate = new Date();
	
	
	public FrontPage() {
		this.progressBarPercentage = 0;
		this.counterOfTheDay = 0;
		this.tipOfTheDay = "";
		this.movieOfTheDay = "";
	}
	
	public int getCounterOfTheDay() {
		return counterOfTheDay;
	}

	public void setCounterOfTheDay(int counterOfTheDay) {
		this.counterOfTheDay = counterOfTheDay;
	}

	public int getProgressBarPercentage() {
		return progressBarPercentage;
	}


	public void setProgressBarPercentage(int progressBarPercentage) {
		this.progressBarPercentage = progressBarPercentage;
	}


	/*
	 * return randomly generated line from "readRandomTipsOfTheDay.txt"
	 */
	public String generateTipOfTheDay() {
		int randomTipIndex = (int) (Math.random() * this.listOfTips.size());
		String tipToShow = this.listOfTips.get(randomTipIndex);
		this.tipOfTheDay = tipToShow;
		
		return this.tipOfTheDay;
	}
	/*
	 * readTipFromFile reads each line of the "randomTipsOfTheDay.txt" file and 
	 * adds it to an array listOfTips 
	 */
	public void readTipFromFile() {
		this.listOfTips = new ArrayList<String>();
		String path = "src/docs/randomTipsOfTheDay.txt";
		try {
			BufferedReader readRandomTipsOfTheDayFile = new BufferedReader(new FileReader(path));
			String line = readRandomTipsOfTheDayFile.readLine();
			while (line != null) {
				listOfTips.add(line);
				line = readRandomTipsOfTheDayFile.readLine();
			}
			readRandomTipsOfTheDayFile.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	/*
	 * return the number of days in Quarantine since WashU kicked us out
	 */
	public int updateDayCounter() {
		long currentTimeInMillis = System.currentTimeMillis();
		long millisSinceProgramStarted = currentTimeInMillis - openingDate.getTime();
		long millisToSeconds = millisSinceProgramStarted / 1000;
		long secondsToMinutes = millisToSeconds / 60;
		long minutesToHours = secondsToMinutes / 60;
		int hoursToDays = (int)minutesToHours / 24;
		int numOfDaysSinceProgramStarted = hoursToDays;
		this.counterOfTheDay = numOfDaysSinceProgramStarted;
		return this.counterOfTheDay;
	}
	
	/*
	 * return randomly generated value for the progress bar, 
	 * which never ends, meant to jump around, 
	 * meant to be comedic relief
	 */
	public int setRandomValueOfProgressBar() {
		int value = ((int) (Math.random() * 100));
		while (value > this.counterOfTheDay) {
			value = ((int) (Math.random() * 100));
		}
		
		this.progressBarPercentage = value;
		return this.progressBarPercentage;
	}
	
}