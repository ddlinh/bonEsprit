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
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class MyProfile_Form extends JFrame {

	private JPanel mainPanel;
	private JTextField searchTextField;
	private JButton menuButton;
	private JButton searchButton;
	private JButton homeButton;
	private JButton allPostsButton;
	private JButton allQuizzesButton;
	private JPanel profilePanel;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField workingPlace;
	private JTextField experiences;
	private ArrayList<JTextField> certificates;
	private JButton addCertificate;
	private JButton submitProfile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyProfile_Form frame = new MyProfile_Form(true);
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
	
	public JPanel createItem(String label, String info, int position, JTextField infoTextField)
	{
		JPanel newItem = new JPanel();
		newItem.setBounds(10, position, 400, 30);
		newItem.setBackground(new Color(255, 250, 240));
		newItem.setLayout(null);
		
		JLabel profileLabel = new JLabel(label + ":");
		profileLabel.setBounds(0, 5, 120, 25);
		profileLabel.setForeground(new Color(0, 0, 51));
		profileLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		infoTextField = new JTextField(info);
		infoTextField.setEditable(false);
		infoTextField.setBorder(null);
		infoTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		infoTextField.setBounds(130, 5, 180, 25);
		infoTextField.setBackground(new Color(0xE4F5F9));
		
		JButton editButton = new JButton();
		editButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editButton.setBackground(new Color(0x69BA98));
		editButton.setBounds(320, 5, 25, 25);
		try {
		    Image img = ImageIO.read(new File("./resources/edit.png"));
		    Image newimg = img.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH ) ;
		    editButton.setIcon(new ImageIcon(newimg));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		
		newItem.add(profileLabel);
		newItem.add(infoTextField);
		newItem.add(editButton);
		return newItem;
	}
	
	public JPanel createCertificate(int position, JTextField certificateTextField) {
		JPanel newCertificate = new JPanel();
		newCertificate.setBounds(10, position, 350, 30);
		newCertificate.setBackground(new Color(255, 250, 240));
		newCertificate.setLayout(null);
		
		JTextField certificateTxt = new JTextField(certificateTextField.getText());
		certificateTxt.setBounds(0, 5, 250, 25);
		certificateTxt.setBorder(null);
		certificateTxt.setEditable(false);
		certificateTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		certificateTxt.setBackground(new Color(0xE4F5F9));

		JButton editButton = new JButton();
		editButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editButton.setBackground(new Color(0x69BA98));
		editButton.setBounds(270, 5, 25, 25);
		try {
		    Image img = ImageIO.read(new File("./resources/edit.png"));
		    Image newimg = img.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH ) ;
		    editButton.setIcon(new ImageIcon(newimg));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		
		newCertificate.add(certificateTxt);
		newCertificate.add(editButton);
		return newCertificate;
	}
	
	
	public MyProfile_Form(boolean Therapist) {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 730);
		
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
		
		JLabel profileLabel = new JLabel("Your Profile Information:");
		profileLabel.setForeground(new Color(51, 102, 51));
		profileLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		profileLabel.setBounds(20, 208, 300, 30);
		mainPanel.add(profileLabel);
		
		profilePanel = new JPanel();
		profilePanel.setBounds(10, 260, 400, 150);
		profilePanel.setBackground(new Color(255, 250, 240));
		profilePanel.setLayout(null);
		
		profilePanel.add(createItem("First name", "first name", 10, this.firstName));
		profilePanel.add(createItem("Last name", "last name", 50, this.lastName));
		profilePanel.add(createItem("Email", "email", 90, this.email));
		
		if(Therapist) {
			profilePanel.setSize(400, 410);
			profilePanel.add(createItem("<html>Working place</html>", "working_place", 130, this.workingPlace));
			profilePanel.add(createItem("<html>Experience:</html>", "experience", 170, this.experiences));
			JLabel certificateLabel = new JLabel("Certificates:");
			certificateLabel.setBounds(10, 210, 120, 25);
			certificateLabel.setForeground(new Color(0, 0, 51));
			certificateLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			profilePanel.add(certificateLabel);
			
			JPanel certificatePanel = new JPanelCustom(350, 300);
			certificatePanel.setBackground(new Color(255, 250, 240));
			certificatePanel.setLocation(20,240);
			certificatePanel.setLayout(null);
			
			JScrollPane certificateScroll = new JScrollPane(certificatePanel);
			certificateScroll.setBounds(20, 240, 350, 100);
			certificateScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			certificateScroll.setBorder(null);
			profilePanel.add(certificateScroll);
			
			String[] certificateList = {"Certificate 1", "Certificate 2", "Certificate 3", "Certificate 4", "Certificate 5"};
			certificates = new ArrayList<JTextField>();
			int position = 0;
			for(int i = 0; i < certificateList.length; i++)
			{
				certificates.add(new JTextField(certificateList[i]));
			}
			for(JTextField jtf : certificates)
			{
				certificatePanel.add(createCertificate(position, jtf));
				position += 30;
			}
			
			addCertificate = new JButton();
			addCertificate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			addCertificate.setBackground(new Color(255, 250, 240));
			addCertificate.setBorder(null);
			addCertificate.setBounds(300, 350, 25, 25);
			try {
			    Image imgAdd = ImageIO.read(new File("./resources/add4.png"));
			    Image newimg = imgAdd.getScaledInstance(25, 25,  java.awt.Image.SCALE_REPLICATE ) ;
			    addCertificate.setIcon(new ImageIcon(newimg));
			  } catch (Exception ex) {
			    System.out.println(ex);
			  }
			
			submitProfile = new JButton("SUBMIT");
			submitProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			submitProfile.setBackground(new Color(0xD3DEF2));
			submitProfile.setBounds(145, 375, 100, 30);
			
			profilePanel.add(addCertificate);
			profilePanel.add(submitProfile);
		}
		
		
		mainPanel.add(profilePanel);

	}

}
