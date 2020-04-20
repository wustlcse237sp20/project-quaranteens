package graphics;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
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
	private JTextField textField;
	private JTextField txtTipOfTheDay;
	private JTextArea recOfTheDay;

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
		frontPage frontPageController = new frontPage();
		recommendationsController recPageController = new recommendationsController();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int daysSinceQuarantine = frontPageController.updateDayCounter();
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		JLabel lblNewLabel = new JLabel("Day " + daysSinceQuarantine );
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 3, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, -45, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, 0, SpringLayout.EAST, lblNewLabel);
		frame.getContentPane().add(tabbedPane);
		
		txtTipOfTheDay = new JTextField();
		txtTipOfTheDay.setFont(new Font("Tahoma", Font.PLAIN, 30));
		frontPageController.readTipFromFile();
		String tip = frontPageController.generateTipOfTheDay();
		txtTipOfTheDay.setHorizontalAlignment(SwingConstants.CENTER);
		txtTipOfTheDay.setEditable(false);
		txtTipOfTheDay.setText("Tip of the day: " + tip);
		tabbedPane.addTab("Tip", null, txtTipOfTheDay, null);
		tabbedPane.setBackgroundAt(0, new Color(255, 153, 224));
		txtTipOfTheDay.setColumns(10);
		
		JTextArea txtrDiary = new JTextArea();
		txtrDiary.setLineWrap(true);
		tabbedPane.addTab("Diary", null, txtrDiary, null);
		tabbedPane.setBackgroundAt(1, new Color(255, 153, 204));
		
		textField = new JTextField();
		tabbedPane.addTab("Checklist", null, textField, null);
		tabbedPane.setBackgroundAt(2, new Color(255, 153, 153));
		textField.setColumns(10);
		
		recOfTheDay = new JTextArea();
		recOfTheDay.setEditable(false);
		recOfTheDay.setLineWrap(true);
//		recOfTheDay.setHorizontalAlignment(SwingConstants.CENTER);
		tabbedPane.addTab("Recommendation", null, recOfTheDay, null);
		tabbedPane.setBackgroundAt(3, new Color(255, 153, 102));
		recPageController.readMovieRecFromFile();
		String movie = recPageController.generateMovieRec();
		recPageController.readBookRecFromFile();
		String book = recPageController.generateBookRec();
		recPageController.readMusicRecFromFile();
		String music = recPageController.generateMusicRec();
		String allRecs = "Movie of the day: " + movie + "\n \n" + 
				"Book of the day: " + book + "\n \n" +
				"Album of the day: " + music;
		recOfTheDay.setText(allRecs);
		
		JPanel Exercise = new JPanel();
		tabbedPane.addTab("Exercise", null, Exercise, null);
		tabbedPane.setBackgroundAt(4, new Color(255, 102, 51));
		
		JPanel Info = new JPanel();
		tabbedPane.addTab("Info", null, Info, null);
		tabbedPane.setBackgroundAt(5, new Color(255, 51, 51));
		
		int valueOfProgressBar = frontPageController.setRandomValueOfProgressBar();
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setValue(valueOfProgressBar);
		springLayout.putConstraint(SpringLayout.WEST, progressBar, 32, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, progressBar, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, progressBar, 392, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(progressBar);
		
		
		

	}
}
