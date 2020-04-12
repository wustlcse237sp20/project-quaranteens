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

public class frontPage {

	private String tipOfTheDay;
	public int counterOfTheDay;
	private int progressBarPercentage;
	private String[] tipsOfTheDay = new String[5];
	
	//openingDate is when WashU kicked us out - Sad
	@SuppressWarnings("deprecation")
	public Date openingDate = new Date(120, 2, 11);
	public Date currentDate = new Date();
	
	
	public frontPage() {
		this.progressBarPercentage = 0;
		this.counterOfTheDay = 0;
		this.tipOfTheDay = "";
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
		 * generateTipOfTheDay reads the "randomTipsOfTheDay.txt" file and randomly chooses a line from the file to display for the use
		 * returns the random tip of the day
		 */
	public String generateTipOfTheDay() {
		ArrayList<String> listOfTips = new ArrayList<String>();
		String path = "src/docs/randomTipsOfTheDay.txt";
		try {
			BufferedReader readRandomTipsOfTheDayFile = new BufferedReader(new FileReader(path));
			String line = readRandomTipsOfTheDayFile.readLine();
			while (line != null) {
				listOfTips.add(line);
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int randomTipIndex = (int) (Math.random() * listOfTips.size());
		String tipToShow = listOfTips.get(randomTipIndex);
		
		return tipToShow;
	}
	
	/*
	 * updateDayCounter calculates the number of days since the user has started quarantine by subtracting the current time by the time the program was opened for the first time.
	 * returns the numnber of days since quarantine
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
	 * setRandomValueOfProgressBar randomly generates a max value for the progress bar, which never ends, meant to jump around, comedic
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

	
