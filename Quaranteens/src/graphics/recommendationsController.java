package graphics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class recommendationsController {
	
	private String movieOfTheDay;
	private String musicOfTheDay;
	private String bookOfTheDay;
	public ArrayList<String> listOfMovies;
	public ArrayList<String> listOfMusic;
	public ArrayList<String> listOfBooks;
	
	public recommendationsController() {
		this.movieOfTheDay="";
		this.musicOfTheDay="";
		this.bookOfTheDay="";
	}
	/*
	 * generateMovieRec reads the "movieRecs.txt" file and
	 * randomly chooses a line from the file to display for the use
	 * returns the random movie rec of the day
	 */
	public String generateMovieRec() {
		int randomMovieIndex = (int) (Math.random() * this.listOfMovies.size());
		String movieToShow = this.listOfMovies.get(randomMovieIndex);
		this.movieOfTheDay = movieToShow;
		
		return this.movieOfTheDay;
	}
	
	public void readMovieRecFromFile() {
		this.listOfMovies = new ArrayList<String>();
		String path = "src/docs/MovieRecs.txt";
		try {
			BufferedReader readMovieRecsFile = new BufferedReader(new FileReader(path));
			String line = readMovieRecsFile.readLine();
			while (line != null) {
				listOfMovies.add(line);
				line = readMovieRecsFile.readLine();
			}
			readMovieRecsFile.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * generateMusicRec reads the "MusicRecs.txt" file and
	 * randomly chooses a line from the file to display for the use
	 * returns the random music rec of the day
	 */
	public String generateMusicRec() {
		int randomMusicIndex = (int) (Math.random() * this.listOfMusic.size());
		String musicToShow = this.listOfMusic.get(randomMusicIndex);
		this.musicOfTheDay = musicToShow;
		
		return this.musicOfTheDay;
	}
	
	public void readMusicRecFromFile() {
		this.listOfMusic = new ArrayList<String>();
		String path = "src/docs/MusicRecs.txt";
		try {
			BufferedReader readMusicRecsFile = new BufferedReader(new FileReader(path));
			String line = readMusicRecsFile.readLine();
			while (line != null) {
				listOfMusic.add(line);
				line = readMusicRecsFile.readLine();
			}
			readMusicRecsFile.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/*
	 * generateBookRec reads the "BookRecs.txt" file and
	 * randomly chooses a line from the file to display for the use
	 * returns the random book rec of the day
	 */
	public String generateBookRec() {
		int randomBookIndex = (int) (Math.random() * this.listOfBooks.size());
		String bookToShow = this.listOfBooks.get(randomBookIndex);
		this.bookOfTheDay = bookToShow;
		
		return this.bookOfTheDay;
	}
	
	public void readBookRecFromFile() {
		this.listOfBooks = new ArrayList<String>();
		String path = "src/docs/BookRecs.txt";
		try {
			BufferedReader readBookRecsFile = new BufferedReader(new FileReader(path));
			String line = readBookRecsFile.readLine();
			while (line != null) {
				listOfBooks.add(line);
				line = readBookRecsFile.readLine();
			}
			readBookRecsFile.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
