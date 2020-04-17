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
	private JTextArea txtTipOfThe;

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
		
		txtTipOfThe = new JTextArea();
		txtTipOfThe.setFont(new Font("Menlo", Font.PLAIN, 16));
		frontPageController.readTipFromFile();
		String tip = frontPageController.generateTipOfTheDay();
//		txtTipOfThe.orientation(SwingConstants.CENTER);
		txtTipOfThe.setEditable(false);
		txtTipOfThe.setText("Tip of the day: " + tip);
		txtTipOfThe.setLineWrap(true);
		txtTipOfThe.setWrapStyleWord(true);
		tabbedPane.addTab("Tip", null, txtTipOfThe, null);
		tabbedPane.setBackgroundAt(0, new Color(254, 255, 223));
		txtTipOfThe.setColumns(10);
		
		JTextArea txtrDiary = new JTextArea();
		txtrDiary.setLineWrap(true);
		tabbedPane.addTab("Diary", null, txtrDiary, null);
		tabbedPane.setBackgroundAt(1, new Color(212, 234, 206));
		tabbedPane.setFont(new Font("Menlo", Font.PLAIN, 16));
		
		textField = new JTextField();
		tabbedPane.addTab("Checklist", null, textField, null);
		tabbedPane.setBackgroundAt(2, new Color(172, 213, 195));
		textField.setColumns(10);
		
		JPanel Recommendation = new JPanel();
		tabbedPane.addTab("Recommendation", null, Recommendation, null);
		tabbedPane.setBackgroundAt(3, new Color(139, 189, 187));
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
