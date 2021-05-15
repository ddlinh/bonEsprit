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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

class YourProblem extends JPanel{
	JLabel postnameLabel;
	JLabel addLabel;
	JPanel panelBtn;
	JButton viewBtn;
	JButton editBtn;
	JButton removeBtn;
	
	public YourProblem(int position, String postname){
		this.setBounds(10, position, 374, 38);
		this.setBackground(new Color(0xD3DEF2));
		this.setBorder(null);
		this.setLayout(null);
		
		
		
		postnameLabel = new JLabel(postname);
		postnameLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		postnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		postnameLabel.setBounds(10, 0, 95, 38);
		this.add(postnameLabel);
		
		addLabel = new JLabel("Add quizz");
		addLabel.setFont(new Font("SansSerif", Font.ITALIC, 16));
		addLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addLabel.setBounds(100, 0, 95, 38);
		this.add(addLabel);
		
		panelBtn = new JPanel();
		panelBtn.setBounds(199, 0, 185, 38);
		panelBtn.setBackground(new Color(0xD3DEF2));
		this.add(panelBtn);
		panelBtn.setLayout(null);
			
		viewBtn = new JButton("");
		viewBtn.setBackground(new Color(0x879CE7));
		viewBtn.setBounds(20, 0, 38, 38);
		panelBtn.add(viewBtn);
		
		editBtn = new JButton("");
		editBtn.setBackground(new Color(0x83AB87));
		editBtn.setBounds(73, 0, 38, 38);
		panelBtn.add(editBtn);
		
		removeBtn = new JButton("");
		removeBtn.setBackground(new Color(0xC63636));
		removeBtn.setBounds(127, 0, 38, 38);
		panelBtn.add(removeBtn);
	}
}

class YourQuizz extends JPanel{
	JLabel quiznameLabel;
	JPanel panelBtn;
	JButton viewBtn;
	JButton editBtn;
	JButton removeBtn;
	
	public YourQuizz(int position, String quizname){
		this.setBounds(10, position, 374, 38);
		this.setBackground(new Color(0xD3DEF2));
		this.setBorder(null);
		this.setLayout(null);
		
		
		
		quiznameLabel = new JLabel(quizname);
		quiznameLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		quiznameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		quiznameLabel.setBounds(10, 0, 175, 38);
		this.add(quiznameLabel);
		
		panelBtn = new JPanel();
		panelBtn.setBounds(200, 0, 185, 38);
		panelBtn.setBackground(new Color(0xD3DEF2));
		this.add(panelBtn);
		panelBtn.setLayout(null);
			
		viewBtn = new JButton("");
		viewBtn.setBackground(new Color(0x879CE7));
		viewBtn.setBounds(20, 0, 38, 38);
		panelBtn.add(viewBtn);
		
		editBtn = new JButton("");
		editBtn.setBackground(new Color(0x83AB87));
		editBtn.setBounds(73, 0, 38, 38);
		panelBtn.add(editBtn);
		
		removeBtn = new JButton("");
		removeBtn.setBackground(new Color(0xC63636));
		removeBtn.setBounds(127, 0, 38, 38);
		panelBtn.add(removeBtn);
	}
	
}



public class MyPost_Form extends JFrame {

	private JPanel mainPanel;
	private JTextField searchTextField;
	private JButton menuButton;
	private JButton searchButton;
	private JButton homeButton;
	private JButton allPostsButton;
	private JButton allQuizzesButton;
	
	private JLabel yourproblemLabel;
	private JPanel panel_1;
	private JLabel yourquizzLabel;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPost_Form frame = new MyPost_Form();
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
	public MyPost_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100, 450, 750);
		
		mainPanel =  new JPanel();
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
		
		///Your problem
		yourproblemLabel = new JLabel("Your Problem");
		yourproblemLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		yourproblemLabel.setBounds(20, 191, 129, 35);
		mainPanel.add(yourproblemLabel);
		
		JButton addBtn = new JButton("");
		addBtn.setBounds(159, 191, 35, 35);
		addBtn.setBackground(Color.white);
		addBtn.setBorder(null);
		addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		try {
			Image img2 = ImageIO.read(new File("./resources/add.png"));
			Image newimg = img2.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH ) ;
			addBtn.setIcon(new ImageIcon(newimg));
		} catch (Exception e2) {
			System.out.println(e2);
		}
		mainPanel.add(addBtn);
		
		panel_1 = new JPanelCustom(394, 190);
		panel_1.setLocation(20, 249);
		panel_1.setBackground(new Color(0xD3DEF2));
		panel_1.setLayout(null);
		
		JScrollPane panel_1Scroll = new JScrollPane(panel_1);
		panel_1Scroll.setBounds(20, 249, 394, 190);
		panel_1Scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		panel_1Scroll.setBorder(null);
		panel_1Scroll.setViewportView(panel_1);
		panel_1Scroll.getVerticalScrollBar().setUnitIncrement(20);
		mainPanel.add(panel_1Scroll);
		
		JLabel titleoftestLabel = new JLabel("Title of posts");
		titleoftestLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleoftestLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		titleoftestLabel.setBounds(10, 11, 190, 38);
		panel_1.add(titleoftestLabel);
		
		JLabel resultLabel = new JLabel("Action");
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		resultLabel.setBounds(199, 11, 185, 38);
		panel_1.add(resultLabel);
		
		JSeparator horizonSep = new JSeparator();
		horizonSep.setBackground(Color.BLACK);
		horizonSep.setForeground(Color.BLACK);
		horizonSep.setBounds(10, 46, 374, 1);
		panel_1.add(horizonSep);
		
		JSeparator verticalSep = new JSeparator();
		verticalSep.setForeground(Color.BLACK);
		verticalSep.setOrientation(SwingConstants.VERTICAL);
		verticalSep.setBounds(199, 11, 1, 10000);
		panel_1.add(verticalSep);
		
		
		panel_1.add(new YourProblem(60, "Post 01")); // +48
		panel_1.add(new YourProblem(108, "Post 02"));
		
		
		//Your Quizz
		yourquizzLabel = new JLabel("Your Quizzes");
		yourquizzLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		yourquizzLabel.setBounds(20, 457, 129, 35);
		mainPanel.add(yourquizzLabel);
		
		panel_2 = new JPanelCustom(394, 190);
		panel_2.setLocation(20, 510);
		panel_2.setBackground(new Color(0xD3DEF2));
		panel_2.setLayout(null);
		
		JScrollPane panel_2Scroll = new JScrollPane(panel_2);
		panel_2Scroll.setBounds(20, 510, 394, 190);
		panel_2Scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		panel_2Scroll.setBorder(null);
		panel_2Scroll.setViewportView(panel_2);
		panel_2Scroll.getVerticalScrollBar().setUnitIncrement(20);
		mainPanel.add(panel_2Scroll);
		
		JLabel titleoftestLabel_2 = new JLabel("Title of posts");
		titleoftestLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		titleoftestLabel_2.setFont(new Font("Roboto", Font.BOLD, 20));
		titleoftestLabel_2.setBounds(10, 11, 190, 38);
		panel_2.add(titleoftestLabel_2);
		
		JLabel resultLabel_2 = new JLabel("Action");
		resultLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel_2.setFont(new Font("Roboto", Font.BOLD, 20));
		resultLabel_2.setBounds(199, 11, 185, 38);
		panel_2.add(resultLabel_2);
		
		JSeparator horizonSep_2 = new JSeparator();
		horizonSep_2.setBackground(Color.BLACK);
		horizonSep_2.setForeground(Color.BLACK);
		horizonSep_2.setBounds(10, 46, 374, 1);
		panel_2.add(horizonSep_2);
		
		JSeparator verticalSep_2 = new JSeparator();
		verticalSep_2.setForeground(Color.BLACK);
		verticalSep_2.setOrientation(SwingConstants.VERTICAL);
		verticalSep_2.setBounds(199, 11, 1, 10000);
		panel_2.add(verticalSep_2);
		

		panel_2.add(new YourQuizz(60, "Quiz 01")); // +48
		panel_2.add(new YourQuizz(108, "Quiz 02"));
	}
}
