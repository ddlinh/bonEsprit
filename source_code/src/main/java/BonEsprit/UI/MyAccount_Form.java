package BonEsprit.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dialog.ModalExclusionType;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

public class MyAccount_Form extends JFrame {

	private JPanel mainPanel;
	private JTextField searchTextField;
	private JButton menuButton;
	private JButton searchButton;
	private JButton homeButton;
	private JButton allPostsButton;
	private JButton allQuizzesButton;
	private JLabel accountInfo_1;
	private JLabel accountInfo_2;
	private JLabel accountInfo_3;
	private JLabel usernameLabel;
	private JLabel passwordLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyAccount_Form frame = new MyAccount_Form();
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
	
	public JLabel createPasswordLabel(String password) {
		String text = "";
		for(int i = 0; i < password.length() - 3; i++)
			text += "*";
		for(int i = password.length() - 3; i < password.length(); i++)
			text += password.charAt(i);
		return new JLabel(text);
	}
	
	public MyAccount_Form() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
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
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		welcomeLabel.setBounds(20, 120, 300, 50);
		mainPanel.add(welcomeLabel);
		
		JLabel lblYourAccountInformation = new JLabel("Your Account Information:");
		lblYourAccountInformation.setForeground(new Color(51, 102, 51));
		lblYourAccountInformation.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblYourAccountInformation.setBounds(20, 208, 300, 30);
		mainPanel.add(lblYourAccountInformation);
		
		JPanel accountPanel = new JPanel();
		accountPanel.setBounds(20, 260, 395, 247);
		accountPanel.setBackground(new Color(0xF3EDED));
		mainPanel.add(accountPanel);
		accountPanel.setLayout(null);
		
		accountInfo_1 = new JLabel("Username:");
		accountInfo_1.setBounds(10, 30, 100, 25);
		accountInfo_1.setForeground(new Color(0, 0, 51));
		accountInfo_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		accountPanel.add(accountInfo_1);
		
		accountInfo_2 = new JLabel("Password:");
		accountInfo_2.setForeground(new Color(0, 0, 51));
		accountInfo_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		accountInfo_2.setBounds(10, 95, 100, 25);
		accountPanel.add(accountInfo_2);
		
		accountInfo_3 = new JLabel("Account Type:");
		accountInfo_3.setForeground(new Color(0, 0, 51));
		accountInfo_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		accountInfo_3.setBounds(10, 160, 160, 25);
		accountPanel.add(accountInfo_3);
		
		JRadioButton accountTypeButton_Normal = new JRadioButton("Normal");
		accountTypeButton_Normal.setEnabled(false);
		accountTypeButton_Normal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		accountTypeButton_Normal.setBounds(50, 200, 120, 25);
		accountPanel.add(accountTypeButton_Normal);
		
		JRadioButton accoungTypeButton_Therapist = new JRadioButton("Therapist");
		accoungTypeButton_Therapist.setSelected(true);
		accoungTypeButton_Therapist.setFont(new Font("Tahoma", Font.PLAIN, 19));
		accoungTypeButton_Therapist.setBounds(230, 200, 120, 25);
		accountPanel.add(accoungTypeButton_Therapist);
		
		usernameLabel = new JLabel("New label");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernameLabel.setBounds(120, 30, 250, 25);
		accountPanel.add(usernameLabel);
		
		passwordLabel = createPasswordLabel("pass1111123");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordLabel.setBounds(120, 95, 250, 25);
		accountPanel.add(passwordLabel);
		
		JButton removeAccount = new JButton("REMOVE THIS ACCOUNT");
		removeAccount.setBackground(new Color(153, 0, 0));
		removeAccount.setForeground(new Color(255, 255, 255));
		removeAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		removeAccount.setBounds(70, 550, 300, 50);
		removeAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mainPanel.add(removeAccount);

	}
}
