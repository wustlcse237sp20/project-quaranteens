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
		tabbedPane.setFont(new Font("Menlo", Font.PLAIN, 16));
		
		JPanel Recommendation = new JPanel();
		tabbedPane.addTab("Recommendation", null, Recommendation, null);
		tabbedPane.setBackgroundAt(1, new Color(139, 189, 187));
		
		JPanel Diary = new JPanel();
		tabbedPane.addTab("Diary", null, Diary, null);
		SpringLayout sl_Diary = new SpringLayout();
		Diary.setLayout(sl_Diary);
		
		JButton btnNewButton = new JButton("Add Entry");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 258, SpringLayout.SOUTH, Diary);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, -44, SpringLayout.SOUTH, Diary);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -328, SpringLayout.EAST, Diary);
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Diary.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		sl_Diary.putConstraint(SpringLayout.NORTH, textArea, 0, SpringLayout.NORTH, Diary);
		sl_Diary.putConstraint(SpringLayout.SOUTH, textArea, 0, SpringLayout.SOUTH, Diary);
		sl_Diary.putConstraint(SpringLayout.EAST, textArea, -10, SpringLayout.EAST, Diary);
		textArea.setLineWrap(true);
		Diary.add(textArea);
		
		JButton btnNewButton_1 = new JButton("Remove");
		sl_Diary.putConstraint(SpringLayout.NORTH, btnNewButton_1, 1, SpringLayout.SOUTH, btnNewButton);
		sl_Diary.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, btnNewButton);
		sl_Diary.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 24, SpringLayout.SOUTH, btnNewButton);
		sl_Diary.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, btnNewButton);
		Diary.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Prev Entry");
		sl_Diary.putConstraint(SpringLayout.WEST, btnNewButton_2, 0, SpringLayout.WEST, btnNewButton);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Diary.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Next Entry");
		sl_Diary.putConstraint(SpringLayout.WEST, textArea, 2, SpringLayout.EAST, btnNewButton_3);
		sl_Diary.putConstraint(SpringLayout.SOUTH, btnNewButton_3, 0, SpringLayout.SOUTH, Diary);
		sl_Diary.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -6, SpringLayout.NORTH, btnNewButton_3);
		sl_Diary.putConstraint(SpringLayout.WEST, btnNewButton_3, 0, SpringLayout.WEST, btnNewButton);
		Diary.add(btnNewButton_3);
		
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
