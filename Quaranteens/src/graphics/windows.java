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
	private JTextArea txtTipOfTheDay;
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
		FrontPage frontPageController = new FrontPage();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(254, 255, 223));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFont(new Font("Menlo", Font.PLAIN, 16));
		
		int daysSinceQuarantine = frontPageController.updateDayCounter();
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		JLabel lblNewLabel = new JLabel("Day " + daysSinceQuarantine );
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Menlo", Font.PLAIN, 12));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		springLayout.putConstraint(SpringLayout.NORTH, tabbedPane, 3, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, tabbedPane, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, tabbedPane, -45, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, tabbedPane, 0, SpringLayout.EAST, lblNewLabel);
		tabbedPane.setFont(new Font("Menlo", Font.PLAIN, 16));
		frame.getContentPane().add(tabbedPane);
		
		txtTipOfTheDay = new JTextArea();
		txtTipOfTheDay.setFont(new Font("Menlo", Font.PLAIN, 16));
		frontPageController.readTipFromFile();
		String tip = frontPageController.generateTipOfTheDay();
//		txtTipOfThe.orientation(SwingConstants.CENTER);
		txtTipOfTheDay.setEditable(false);
		txtTipOfTheDay.setText("Tip of the day: " + tip);
		txtTipOfTheDay.setLineWrap(true);
		txtTipOfTheDay.setWrapStyleWord(true);
		tabbedPane.addTab("Tip", null, txtTipOfTheDay, null);
		tabbedPane.setBackgroundAt(0, new Color(254, 255, 223));
		txtTipOfTheDay.setColumns(10);
		tabbedPane.setFont(new Font("Menlo", Font.PLAIN, 16));
		
		JPanel Diary = new JPanel();
		tabbedPane.addTab("Diary", null, Diary, null);
		SpringLayout sl_Diary = new SpringLayout();
		Diary.setLayout(sl_Diary);
		
		JButton addEntry = new JButton("Add Entry");
		springLayout.putConstraint(SpringLayout.NORTH, addEntry, 258, SpringLayout.SOUTH, Diary);
		springLayout.putConstraint(SpringLayout.SOUTH, addEntry, -44, SpringLayout.SOUTH, Diary);
		springLayout.putConstraint(SpringLayout.EAST, addEntry, -328, SpringLayout.EAST, Diary);
		addEntry.setHorizontalAlignment(SwingConstants.RIGHT);
		addEntry.setVerticalAlignment(SwingConstants.BOTTOM);
		addEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		Diary.add(addEntry);
		
		JTextArea contentOfDiary = new JTextArea();
		sl_Diary.putConstraint(SpringLayout.NORTH, contentOfDiary, 0, SpringLayout.NORTH, Diary);
		sl_Diary.putConstraint(SpringLayout.SOUTH, contentOfDiary, 0, SpringLayout.SOUTH, Diary);
		sl_Diary.putConstraint(SpringLayout.EAST, contentOfDiary, -10, SpringLayout.EAST, Diary);
		contentOfDiary.setLineWrap(true);
		Diary.add(contentOfDiary);
		
		JButton removeEntry = new JButton("Remove");
		sl_Diary.putConstraint(SpringLayout.NORTH, removeEntry, 1, SpringLayout.SOUTH, addEntry);
		sl_Diary.putConstraint(SpringLayout.WEST, removeEntry, 0, SpringLayout.WEST, addEntry);
		sl_Diary.putConstraint(SpringLayout.SOUTH, removeEntry, 24, SpringLayout.SOUTH, addEntry);
		sl_Diary.putConstraint(SpringLayout.EAST, removeEntry, 0, SpringLayout.EAST, addEntry);
		Diary.add(removeEntry);
		
		JButton prevEntry = new JButton("Prev Entry");
		sl_Diary.putConstraint(SpringLayout.WEST, prevEntry, 0, SpringLayout.WEST, addEntry);
		prevEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Diary.add(prevEntry);
		
		JButton nextEntry = new JButton("Next Entry");
		sl_Diary.putConstraint(SpringLayout.WEST, contentOfDiary, 2, SpringLayout.EAST, nextEntry);
		sl_Diary.putConstraint(SpringLayout.SOUTH, nextEntry, 0, SpringLayout.SOUTH, Diary);
		sl_Diary.putConstraint(SpringLayout.SOUTH, prevEntry, -6, SpringLayout.NORTH, nextEntry);
		sl_Diary.putConstraint(SpringLayout.WEST, nextEntry, 0, SpringLayout.WEST, addEntry);
		Diary.add(nextEntry);
		
		JPanel Recommendation = new JPanel();
		tabbedPane.addTab("Recommendation", null, Recommendation, null);
		tabbedPane.setBackgroundAt(2, new Color(139, 189, 187));
		
		textField = new JTextField();
		tabbedPane.addTab("Checklist", null, textField, null);
		tabbedPane.setBackgroundAt(3, new Color(172, 213, 195));
		textField.setColumns(10);
		tabbedPane.setFont(new Font("Menlo", Font.PLAIN, 16));
		
		JPanel Exercise = new JPanel();
		tabbedPane.addTab("Exercise", null, Exercise, null);
		tabbedPane.setBackgroundAt(4, new Color(114, 165, 178));
		tabbedPane.setFont(new Font("Menlo", Font.PLAIN, 16));
		
		JPanel Info = new JPanel();
		tabbedPane.addTab("Info", null, Info, null);
		tabbedPane.setBackgroundAt(5, new Color(102, 139, 164));
		tabbedPane.setFont(new Font("Menlo", Font.PLAIN, 16));
		
		int valueOfProgressBar = frontPageController.setRandomValueOfProgressBar();
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setValue(valueOfProgressBar);
		springLayout.putConstraint(SpringLayout.WEST, progressBar, 32, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, progressBar, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, progressBar, 392, SpringLayout.WEST, frame.getContentPane());
		progressBar.setFont(new Font("Menlo", Font.PLAIN, 16));
		frame.getContentPane().add(progressBar);
		
		
		
		

	}
}
