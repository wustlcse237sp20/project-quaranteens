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
	 * return randomly chosen line from "MoviesRecs.txt" file
	 */
	public String generateMovieRec() {
		int randomMovieIndex = (int) (Math.random() * this.listOfMovies.size());
		String movieToShow = this.listOfMovies.get(randomMovieIndex);
		this.movieOfTheDay = movieToShow;
		
		return this.movieOfTheDay;
	}
	/*
	 * readMovieRecFromFile reads the file "MovieRecs.txt" and
	 * adds it to an ArrayList listOfMovies
	 */
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
	 * return random music recommendation from file "MusicRecs.txt"
	 */
	public String generateMusicRec() {
		int randomMusicIndex = (int) (Math.random() * this.listOfMusic.size());
		String musicToShow = this.listOfMusic.get(randomMusicIndex);
		this.musicOfTheDay = musicToShow;
		
		return this.musicOfTheDay;
	}
	
	/*
	 *readMusicRecFromFile reads each line of "MusicRecs.txt" file and
	 *adds it to the ArrayList ListOfMusic 
	 */
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
	 * return random book recommendation based from file "BookRecs.txt"
	 */
	public String generateBookRec() {
		int randomBookIndex = (int) (Math.random() * this.listOfBooks.size());
		String bookToShow = this.listOfBooks.get(randomBookIndex);
		this.bookOfTheDay = bookToShow;
		
		return this.bookOfTheDay;
	}
	
	/*
	 * readBookRecFromFile reads each line of the file "BookRecs.txt" and
	 * adds it to the ArrayList listOfBooks
	 */
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
