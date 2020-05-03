package graphics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JPanel;

public class windows {

	private JFrame frame;
	private JTextArea txtTipOfTheDay;
	private JTextArea recOfTheDay;
	private JTextArea txtInfo;
	private JTextArea exerciseOfTheDay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windows window = new windows();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public windows() {
		initialize();
	}
	/**
	 * 
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//initialize controller classes
		Date currentDate = new Date();
		FrontPage frontPageController = new FrontPage();
		recommendationsController recPageController = new recommendationsController();
		ExercisePage exercisePage = new ExercisePage();
		DiaryManager diaryManagerController = new DiaryManager();
		String startingTextForDiaryEntry = currentDate.toString() + "\n" + "Add Your Next Entry Here!" + "\n" + "Title: ";
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(254, 255, 223));
		frame.setBounds(100, 100, 539, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFont(new Font("Menlo", Font.PLAIN, 16));
		
		int daysSinceQuarantine = frontPageController.updateDayCounter();
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		JLabel counterLabel = new JLabel("Day " + daysSinceQuarantine );
		counterLabel.setFont(new Font("Menlo", Font.PLAIN, 16));
		springLayout.putConstraint(SpringLayout.NORTH, counterLabel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, counterLabel, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(counterLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Menlo", Font.PLAIN, 16));
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 3, SpringLayout.SOUTH, counterLabel);
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, -45, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, 0, SpringLayout.EAST, counterLabel);
		frame.getContentPane().add(tabbedPane);
		
		
		//TIP OF THE DAY
		txtTipOfTheDay = new JTextArea();
		txtTipOfTheDay.setFont(new Font("Menlo", Font.PLAIN, 16));
		txtTipOfTheDay.setLineWrap(true);
		frontPageController.readTipFromFile();
		String tip = frontPageController.generateTipOfTheDay();
		txtTipOfTheDay.setEditable(false);
		txtTipOfTheDay.setText("Tip of the day: " + tip);
		tabbedPane.addTab("Tip", null, txtTipOfTheDay, null);
		tabbedPane.setBackgroundAt(0, new Color(254, 255, 234));
		txtTipOfTheDay.setColumns(10);
		
		//DIARY 
		JPanel diaryPanelTab = new JPanel();
		diaryPanelTab.setToolTipText("");
		diaryPanelTab.setFont(new Font("Menlo", Font.PLAIN, 16));
		tabbedPane.addTab("Diary", null, diaryPanelTab, null);
		tabbedPane.setBackgroundAt(0, new Color(212, 234, 206));
		SpringLayout sl_diaryPanelTab = new SpringLayout();
		diaryPanelTab.setLayout(sl_diaryPanelTab);
		
		JTextArea contentOfDiaryEntry = new JTextArea();
		sl_diaryPanelTab.putConstraint(SpringLayout.WEST, contentOfDiaryEntry, 97, SpringLayout.WEST, diaryPanelTab);
		sl_diaryPanelTab.putConstraint(SpringLayout.NORTH, contentOfDiaryEntry, 0, SpringLayout.NORTH, diaryPanelTab);
		sl_diaryPanelTab.putConstraint(SpringLayout.SOUTH, contentOfDiaryEntry, 0, SpringLayout.SOUTH, diaryPanelTab);
		sl_diaryPanelTab.putConstraint(SpringLayout.EAST, contentOfDiaryEntry, 0, SpringLayout.EAST, diaryPanelTab);
		diaryPanelTab.add(contentOfDiaryEntry);
		contentOfDiaryEntry.setText(startingTextForDiaryEntry);
		
		JButton prevEntryButton = new JButton("Prev Entry");
		sl_diaryPanelTab.putConstraint(SpringLayout.WEST, prevEntryButton, 0, SpringLayout.WEST, diaryPanelTab);
		prevEntryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (diaryManagerController.listOfEntries.size() > 0) {
				Diary prevDiary = diaryManagerController.prevDiaryEntry();
				String prevDiaryString = prevDiary.getContentOfEntry();
				contentOfDiaryEntry.setText(prevDiaryString);
			}
			}
		});
		
		diaryPanelTab.add(prevEntryButton);
		
		JButton nextEntryButton = new JButton("Next Entry");
		sl_diaryPanelTab.putConstraint(SpringLayout.WEST, nextEntryButton, 0, SpringLayout.WEST, diaryPanelTab);
		nextEntryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (diaryManagerController.listOfEntries.size() > 0) {
				Diary nextDiaryEntry = diaryManagerController.nextDiaryEntry();
				contentOfDiaryEntry.setText(nextDiaryEntry.getContentOfEntry());
				}
			}
		});
		
		sl_diaryPanelTab.putConstraint(SpringLayout.SOUTH, prevEntryButton, -9, SpringLayout.NORTH, nextEntryButton);
		sl_diaryPanelTab.putConstraint(SpringLayout.SOUTH, nextEntryButton, 0, SpringLayout.SOUTH, contentOfDiaryEntry);
		diaryPanelTab.add(nextEntryButton);
		
		JButton deleteEntryButton = new JButton("Delete Entry");
		deleteEntryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (diaryManagerController.listOfEntries.size() > 0) {
				diaryManagerController.deleteDiaryEntry(diaryManagerController.indexOfDiaryEntry);
				contentOfDiaryEntry.setText(startingTextForDiaryEntry);
				}
				else {
					contentOfDiaryEntry.setText(startingTextForDiaryEntry);
				}
			}
		});
		
		sl_diaryPanelTab.putConstraint(SpringLayout.NORTH, deleteEntryButton, 29, SpringLayout.NORTH, diaryPanelTab);
		sl_diaryPanelTab.putConstraint(SpringLayout.WEST, deleteEntryButton, 0, SpringLayout.WEST, diaryPanelTab);
		sl_diaryPanelTab.putConstraint(SpringLayout.EAST, deleteEntryButton, 91, SpringLayout.WEST, diaryPanelTab);
		diaryPanelTab.add(deleteEntryButton);
		
		JButton addEntryButton = new JButton("Add Entry");
		addEntryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Diary newDiaryEntry = new Diary(currentDate, contentOfDiaryEntry.getText());
				diaryManagerController.addDiaryEntry(newDiaryEntry);
				diaryManagerController.saveDiaryEntryToFile(contentOfDiaryEntry.getText());
				contentOfDiaryEntry.setText(startingTextForDiaryEntry);
			}
		});
		sl_diaryPanelTab.putConstraint(SpringLayout.NORTH, addEntryButton, 0, SpringLayout.NORTH, diaryPanelTab);
		sl_diaryPanelTab.putConstraint(SpringLayout.WEST, addEntryButton, 0, SpringLayout.WEST, prevEntryButton);
		sl_diaryPanelTab.putConstraint(SpringLayout.EAST, addEntryButton, -6, SpringLayout.WEST, contentOfDiaryEntry);
		diaryPanelTab.add(addEntryButton);
		
		//generates the recommendation text
		recPageController.readMovieRecFromFile();
		String movie = recPageController.generateMovieRec();
		recPageController.readBookRecFromFile();
		String book = recPageController.generateBookRec();
		recPageController.readMusicRecFromFile();
		String music = recPageController.generateMusicRec();
		String allRecs = "Movie of the day: " + movie + "\n \n" + 
				"Book of the day: " + book + "\n \n" +
				"Album of the day: " + music;
		
		recOfTheDay = new JTextArea();
		recOfTheDay.setFont(new Font("Menlo", Font.PLAIN, 16));
		recOfTheDay.setEditable(false);
		recOfTheDay.setLineWrap(true);
				tabbedPane.addTab("Recommendation", null, recOfTheDay, null);
				tabbedPane.setBackgroundAt(2, new Color(139, 189, 187));
				recOfTheDay.setText(allRecs);
		
		//generates the exercise text
		exercisePage.readExerciseFromFile();
		String exercise = exercisePage.generateExerciseRec();
		String fullExercise = "The WHO recommends 150 minutes of moderate-intensity or 75 minutes of vigorous-intensity physical activity per week, or a combination of both. These recommendations can still be achieved even at home, with no special equipment and with limited space."
				+ "\n \n" + "To support individuals in staying physically active while at home, WHO/Europe has prepared a set of examples of home-based exercises."
				+ "\n \n" + exercise;
				
		exerciseOfTheDay = new JTextArea();
		exerciseOfTheDay.setFont(new Font("Menlo", Font.PLAIN, 16));
		exerciseOfTheDay.setEditable(false);
		exerciseOfTheDay.setLineWrap(true);
				tabbedPane.addTab("Exercise", null, exerciseOfTheDay, null);
				tabbedPane.setBackgroundAt(3, new Color(114, 165, 178));
				exerciseOfTheDay.setText(fullExercise);
    
		//INFO TAB
		txtInfo = new JTextArea();
		txtInfo.setFont(new Font("Menlo", Font.PLAIN, 16));
		txtInfo.setLineWrap(true);
		txtInfo.setEditable(false);
		String credit = "Project Quaranteens was created by "
				+ "Jefferson Duan, Sonia Muzemil, Miles Lee, and Willie Su "
				+ "for Doug Shook's CSE 237 class at WashU in Spring 2020. \n \n"
				+ "They wanted to create a small application to keep quarantined "
				+ "students in the US informed, safe, healthy, and entertained "
				+ "while isolated at home during the COVID-19 pandemic. \n \n"
				+ "Exercise and wellness tips are courtesy of the World Health "
				+ "Organization (Europe Office).";
		String sources = "You can find more information about COVID-19"
				+ " from WHO https://www.who.int, "
				+ "the CDC https://www.cdc.gov/coronavirus/2019-ncov/index.html";
		txtInfo.setText(credit + "\n" + "\n" + sources);
		tabbedPane.addTab("Info", null, txtInfo, null);
		tabbedPane.setBackgroundAt(4, new Color(102, 139, 164));
		
		//PROGRESS BAR
		int valueOfProgressBar = frontPageController.setRandomValueOfProgressBar();
		JProgressBar progressBar = new JProgressBar();
		springLayout.putConstraint(SpringLayout.NORTH, progressBar, 10, SpringLayout.SOUTH, tabbedPane);
		springLayout.putConstraint(SpringLayout.WEST, progressBar, 50, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, progressBar, -24, SpringLayout.EAST, frame.getContentPane());
		progressBar.setFont(new Font("Menlo", Font.PLAIN, 16));
		progressBar.setStringPainted(true);
		progressBar.setValue(valueOfProgressBar);
		frame.getContentPane().add(progressBar);
	}
}