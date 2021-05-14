package BonEsprit.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.io.File;
import java.util.Calendar;
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
import javax.swing.SwingConstants;

public class Therapist_Form extends JFrame {
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
					Therapist_Form frame = new Therapist_Form();
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
	
	public JLabel createCertificate(String name, int position) {
		JLabel x = new JLabel(name);
		x.setBounds(30, position, 380, 20);
		return x;
	}
	
	public JPanel createLatestPost(String name, Long milliSecond, int position) {
		JPanel newPostPanel = new JPanel();
		newPostPanel.setLayout(null);
		newPostPanel.setBounds(5, position, 380, 40);
		newPostPanel.setBackground(new Color(0xD3E4F9));
		
		JLabel titlePost = new JLabel(name);
		titlePost.setBounds(10, 0, 380, 20);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliSecond);
		int mYear = calendar.get(Calendar.YEAR);
		int mMonth = calendar.get(Calendar.MONTH);
		int mDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		String date = mDay + "/" + mMonth + "/" + mYear;
		JLabel datePost = new JLabel(date);
		datePost.setBounds(10, 20, 380, 20);
		
		newPostPanel.add(titlePost);
		newPostPanel.add(datePost);
		
		newPostPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		return newPostPanel;
	}
	
	public Therapist_Form() {
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
		
		JPanel therapistContentPanel = new JPanel();
		therapistContentPanel.setAutoscrolls(true);
		therapistContentPanel.setBackground(Color.WHITE);
		therapistContentPanel.setBounds(0, 100, 450, 700);
		therapistContentPanel.setLayout(null);
		
		JScrollPane scrollTherapistPanel = new JScrollPane(therapistContentPanel);
		scrollTherapistPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollTherapistPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTherapistPanel.setAutoscrolls(true);
		scrollTherapistPanel.setBounds(0, 100, 450, 630);
		
		mainPanel.add(scrollTherapistPanel);
		
		JLabel therapistTitleLabel = new JLabel("THERAPIST NAME");
		therapistTitleLabel.setForeground(new Color(139, 0, 0));
		therapistTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		therapistTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
		therapistTitleLabel.setBounds(0, 20, 440, 30);
		therapistContentPanel.add(therapistTitleLabel);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(new Color(255, 255, 255));
		infoPanel.setBounds(0, 74, 450, 130);
		therapistContentPanel.add(infoPanel);
		infoPanel.setLayout(null);
		
		JLabel infoLabel_1 = new JLabel("Working Place:");
		infoLabel_1.setForeground(new Color(0, 139, 139));
		infoLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		infoLabel_1.setBounds(10, 10, 125, 30);
		infoPanel.add(infoLabel_1);
		
		JLabel workingPlaceLabel = new JLabel("Working Place");
		workingPlaceLabel.setForeground(new Color(160, 82, 45));
		workingPlaceLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		workingPlaceLabel.setBounds(180, 10, 270, 30);
		infoPanel.add(workingPlaceLabel);
		
		JLabel infoLabel_2 = new JLabel("Experiences (years):");
		infoLabel_2.setForeground(new Color(0, 139, 139));
		infoLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		infoLabel_2.setBounds(10, 50, 165, 30);
		infoPanel.add(infoLabel_2);
		
		JLabel experiencesLabel = new JLabel("years");
		experiencesLabel.setForeground(new Color(160, 82, 45));
		experiencesLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		experiencesLabel.setBounds(180, 50, 134, 30);
		infoPanel.add(experiencesLabel);
		
		JLabel infoLabel_3 = new JLabel("Email:");
		infoLabel_3.setForeground(new Color(0, 139, 139));
		infoLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		infoLabel_3.setBounds(10, 90, 165, 30);
		infoPanel.add(infoLabel_3);
		
		JLabel emailLabel = new JLabel("...@.......");
		emailLabel.setForeground(new Color(160, 82, 45));
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailLabel.setBounds(180, 90, 134, 30);
		infoPanel.add(emailLabel);
		
		JLabel infoLabel_4 = new JLabel("Certificates");
		infoLabel_4.setBounds(10, 210, 125, 30);
		therapistContentPanel.add(infoLabel_4);
		infoLabel_4.setForeground(new Color(0, 139, 139));
		infoLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JPanel certificatePanel = new JPanelCustom(420, 300);
		certificatePanel.setLayout(null);
		certificatePanel.setBackground(Color.WHITE);
		certificatePanel.setLocation(10, 245);
		
		JScrollPane certificateScrollPane = new JScrollPane(certificatePanel);
		certificateScrollPane.setBounds(10, 245, 420, 135);
		certificateScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		certificateScrollPane.setBorder(null);
		therapistContentPanel.add(certificateScrollPane);
		
		JLabel infoLabel_5 = new JLabel("This therapist's latest post:");
		infoLabel_5.setForeground(new Color(0, 139, 139));
		infoLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		infoLabel_5.setBounds(10, 405, 238, 30);
		therapistContentPanel.add(infoLabel_5);
		
		JPanel latestPostPanel = new JPanelCustom(420, 300);
		latestPostPanel.setBackground(Color.WHITE);
		latestPostPanel.setLocation(10, 445);
		latestPostPanel.setLayout(null);
		
		JScrollPane latestPostScroll = new JScrollPane(latestPostPanel);
		latestPostScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		latestPostScroll.setBounds(10, 445, 420, 150);
		latestPostScroll.setBorder(null);
		therapistContentPanel.add(latestPostScroll);
		
		String[] certificateSample = {"Certificate 01", "Certificate 02", "Certificate 03", "Certificate 04", "Certificate 05"};
		int position = 5;
		for(int i = 0; i < certificateSample.length; i++)
		{
			certificatePanel.add(createCertificate("-    " + certificateSample[i], position));
			position += 30;
		}
		
		String[] namePostSample = {"Post 01", "Post 02", "Post 03", "Post 04"};
		Long[] milliSecondSample = {80000L, 70000L, 60000L, 50000L};
		
		position = 5;
		for(int i = 0; i < namePostSample.length; i++)
		{
			latestPostPanel.add(createLatestPost(namePostSample[i], milliSecondSample[i], position));
			position += 50;
		}
		
	}
}
