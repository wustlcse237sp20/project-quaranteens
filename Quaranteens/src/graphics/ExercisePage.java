package graphics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ExercisePage {
	
	private String exerciseOfTheDay;
	public ArrayList<String> listOfExercises;
	
	public ExercisePage() {
		this.exerciseOfTheDay="";
	}
	/*
	 * generateExerciseRec reads the "Exercises.txt" file and
	 * randomly chooses a line from the file to display.
	 */
	public String generateExerciseRec() {
		int randomExerciseIndex = (int) (Math.random() * this.listOfExercises.size());
		String exerciseToShow = this.listOfExercises.get(randomExerciseIndex);
		this.exerciseOfTheDay = exerciseToShow;
		
		return this.exerciseOfTheDay;
	}
	
	public void readExerciseFromFile() {
		this.listOfExercises = new ArrayList<String>();
		String path = "src/docs/Exercises.txt";
		try {
			BufferedReader readExerciseFile = new BufferedReader(new FileReader(path));
			String line = readExerciseFile.readLine();
			while (line != null) {
				listOfExercises.add(line);
				line = readExerciseFile.readLine();
			}
			readExerciseFile.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
