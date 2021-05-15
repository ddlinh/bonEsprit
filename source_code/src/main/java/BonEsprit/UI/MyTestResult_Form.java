package BonEsprit.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Panel;
import javax.swing.SwingConstants;



class ResultPanel extends JPanel{
	JLabel testnameLabel;
	JLabel resultLabel;
	
	public ResultPanel(int position, String testname, String result) {
		this.setBounds(10, position, 394, 38);
		this.setBackground(new Color(0xD3DEF2));
		this.setLayout(null);
		
		testnameLabel = new JLabel(testname);
		testnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		testnameLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		testnameLabel.setBounds(10, 0, 180, 38);
		this.add(testnameLabel);
		
		resultLabel = new JLabel(result);
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		resultLabel.setBounds(214, 0, 180, 38);
		this.add(resultLabel);
	}
}

public class MyTestResult_Form extends JFrame {

	
	private JPanel mainPanel;
	private JTextField searchTextField;
	private JButton menuButton;
	private JButton searchButton;
	private JButton homeButton;
	private JButton allPostsButton;
	private JButton allQuizzesButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyTestResult_Form frame = new MyTestResult_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyTestResult_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
	
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(0xFFFFFF));
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel homePanel = new JPanel();
		homePanel.setBounds(0, 0, 450, 60);
		homePanel.setBackground(new Color(0xFFFFFF));
		homePanel.setLayout(null);
		mainPanel.add(homePanel);
		
		menuButton = new JButton();
		menuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuButton.setBackground(new Color(0xC4C4C4));
		
		try {
		    Image img = ImageIO.read(new File("./resources/menubar.png"));
		    Image newimg = img.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
		    menuButton.setIcon(new ImageIcon(newimg));
		    
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		
		menuButton.setBounds(10, 10, 40, 40);
		homePanel.add(menuButton);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(60, 18, 260, 28);
		homePanel.add(searchTextField);
		searchTextField.setColumns(10);
		
		searchButton = new JButton();
		searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchButton.setBackground(new Color(0xD3E4F9));
		try {
		    Image img = ImageIO.read(new File("./resources/search.png"));
		    Image newimg = img.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH ) ;
		    searchButton.setIcon(new ImageIcon(newimg));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		searchButton.setBounds(320, 17, 30, 30);
		homePanel.add(searchButton);
		
		JLabel logo = new JLabel();
		try {
		    Image img = ImageIO.read(new File("./resources/brain.png"));
		    Image newimg = img.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH ) ;
		    logo.setIcon(new ImageIcon(newimg));
		    
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		logo.setBounds(365, 2, 70, 60);
		homePanel.add(logo);
		
		JPanel controlUnitPanel = new JPanel();
		controlUnitPanel.setBackground(new Color(0xFFFFFF));
		controlUnitPanel.setBounds(0, 65, 450, 30);
		mainPanel.add(controlUnitPanel);
		controlUnitPanel.setLayout(null);
		
		homeButton = new JButton("HOME");
		homeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homeButton.setBackground(new Color(0xF4B4B4));
		homeButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		homeButton.setBounds(44, 0, 90, 30);
		controlUnitPanel.add(homeButton);
		
		allQuizzesButton = new JButton("QUIZZES");
		allQuizzesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allQuizzesButton.setBackground(new Color(0xF4B4B4));
		allQuizzesButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		allQuizzesButton.setBounds(300, 0, 105, 30);
		controlUnitPanel.add(allQuizzesButton);
		
		allPostsButton = new JButton("POSTS");
		allPostsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allPostsButton.setBounds(167, 0, 100, 30);
		controlUnitPanel.add(allPostsButton);
		allPostsButton.setBackground(new Color(0xF4B4B4));
		allPostsButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		
		Image img;
		String name = "Hello";
		JLabel welcomeLabel = new JLabel(name);
		try {
			img = ImageIO.read(new File("./resources/smile.png"));
			Image newimg = img.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH ) ;
			welcomeLabel = new JLabel(name, new ImageIcon(newimg), JLabel.LEFT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		welcomeLabel.setForeground(new Color(0, 51, 51));
		welcomeLabel.setFont(new Font("Roboto", Font.ITALIC | Font.BOLD, 24));
		welcomeLabel.setBounds(10, 130, 200, 50);
		mainPanel.add(welcomeLabel);
		
//		JLabel helloLabel = new JLabel("Hello, first name");
//		helloLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
//		helloLabel.setBounds(10, 130, 200, 50);
//		mainPanel.add(helloLabel);
		
		JLabel yourtestresultLabel = new JLabel("Your Test Results");
		yourtestresultLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		yourtestresultLabel.setBounds(10, 191, 250, 30);
		mainPanel.add(yourtestresultLabel);
		
		
		JPanel resultPane = new JPanelCustom(414, 10000);
		resultPane.setLocation(10, 227);
		resultPane.setBackground(new Color(0xD3DEF2));
		resultPane.setLayout(null);
		
		JScrollPane resultScrollPane = new JScrollPane(resultPane);
		resultScrollPane.setBounds(10, 227, 414, 474);
		resultScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		resultScrollPane.setBorder(null);
		resultScrollPane.setViewportView(resultPane);
		resultScrollPane.getVerticalScrollBar().setUnitIncrement(20);
		mainPanel.add(resultScrollPane);
		
		JLabel titleoftestLabel = new JLabel("Title of test");
		titleoftestLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleoftestLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		titleoftestLabel.setBounds(10, 11, 190, 38);
		resultPane.add(titleoftestLabel);
		
		JLabel resultLabel = new JLabel("Result");
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		resultLabel.setBounds(214, 11, 190, 38);
		resultPane.add(resultLabel);
		
		JSeparator horizonSep = new JSeparator();
		horizonSep.setForeground(Color.BLACK);
		horizonSep.setBounds(10, 47, 394, 1);
		resultPane.add(horizonSep);
		
		JSeparator verticalSep = new JSeparator();
		verticalSep.setForeground(Color.BLACK);
		verticalSep.setOrientation(SwingConstants.VERTICAL);
		verticalSep.setBounds(199, 11, 1, 10000);
		resultPane.add(verticalSep);
		

				
		resultPane.add(new ResultPanel(60, "Item 1", "Item 1'")); // + 48
		resultPane.add(new ResultPanel(108, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(156, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(204, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(252, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(300, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(348, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(396, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(444, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(492, "Item 7", "Item 7'"));
		
		
	}
}
