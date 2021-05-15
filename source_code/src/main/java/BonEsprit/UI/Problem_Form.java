package BonEsprit.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dialog.ModalExclusionType;
import java.io.File;

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

import BonEsprit.Model.Problem;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.Cursor;

public class Problem_Form extends JFrame {
	private JPanel mainPanel;
	private JTextField searchTextField;
	private JButton menuButton;
	private JButton searchButton;
	private JButton homeButton;
	private JButton allPostsButton;
	private JButton allQuizzesButton;
	private JLabel postTitleLabel;
	private JLabel authorLabel;
	private JLabel descriptionLabel;
	private JPanel symptomsPanel;
	private JLabel symptomsLabel;
	private JPanel treatmentsPanel;
	private JLabel treatmentsLabel;
	private JScrollPane scrollSymptomsPanel;
	private JLabel dateLabel;
	private JScrollPane scrollTreatmentsPanel;
	
	private JButton takeQuiz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problem_Form frame = new Problem_Form();
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
	
	public JLabel createItem(String name, int position) {
		JLabel newText = new JLabel("<html>" + name + "</html>");
		newText.setBounds(10, position, 350, 20);
		newText.setFont(new Font("SansSerif", Font.PLAIN, 17));
		
		return newText;
	}
	
	public Problem_Form() {
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
		
		JPanel postContentPanel = new JPanelCustom(450, 700);
		postContentPanel.setAutoscrolls(true);
		postContentPanel.setBackground(Color.WHITE);
		postContentPanel.setLocation(0, 100);
		postContentPanel.setLayout(null);
		
		JScrollPane scrollPostPanel = new JScrollPane(postContentPanel);
		scrollPostPanel.setAutoscrolls(true);
		scrollPostPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPostPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPostPanel.setBounds(0, 100, 450, 700);
		
		postTitleLabel = new JLabel("DEPRESSION");
		postTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		postTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
		postTitleLabel.setBounds(0, 15, 440, 30);
		postContentPanel.add(postTitleLabel);
		
		descriptionLabel = new JLabel("Description:");
		descriptionLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		descriptionLabel.setBounds(30, 85, 118, 20);
		postContentPanel.add(descriptionLabel);
		
		symptomsLabel = new JLabel("Symptoms:");
		symptomsLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		symptomsLabel.setBounds(30, 250, 101, 20);
		postContentPanel.add(symptomsLabel);
		
		treatmentsLabel = new JLabel("Treatment:");
		treatmentsLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		treatmentsLabel.setBounds(30, 400, 101, 15);
		postContentPanel.add(treatmentsLabel);
		
		dateLabel = new JLabel("02/05/2021");
		dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		dateLabel.setBounds(30, 55, 111, 20);
		postContentPanel.add(dateLabel);
		
		JTextArea descriptionTextArea = new JTextArea();
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setWrapStyleWord(true);
		descriptionTextArea.setFont(new Font("SansSerif", Font.PLAIN, 17));
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setText("A sense of hopelessness, the feeling of being \u201Cweighed down,\u201D and a loss of enjoyment in things that used to bring you joy \u2014 these are some common signs of depression, one of the most widespread mental health issues in the world.");
		descriptionTextArea.setBounds(30, 115, 400, 80);
		
		JScrollPane scrollDescriptionArea = new JScrollPane (descriptionTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollDescriptionArea.setBounds(30, 115, 400, 117);
		scrollDescriptionArea.setBorder(null);
		postContentPanel.add(scrollDescriptionArea);
		
		symptomsPanel = new JPanelCustom(375, 300);
		symptomsPanel.setLayout(null);
		symptomsPanel.setLocation(30, 280);
		symptomsPanel.setBackground(Color.WHITE);
		
		scrollSymptomsPanel = new JScrollPane(symptomsPanel);
		scrollSymptomsPanel.setBounds(30, 280, 375, 100);
		scrollSymptomsPanel.setBorder(null);
		scrollSymptomsPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		postContentPanel.add(scrollSymptomsPanel);
		
		String[] symptomSample = {"A persistent feeling of loneliness or sadness", "Lack of energy", "Feelings of hopelessness"};
		int position = 0;
		for(int i = 0; i < symptomSample.length; i++)
		{
			symptomsPanel.add(createItem("-    " + symptomSample[i], position));
			position += 30;
		}
		
		
		treatmentsPanel = new JPanelCustom(375, 300);
		treatmentsPanel.setLayout(null);
		treatmentsPanel.setLocation(30, 425);
		treatmentsPanel.setBackground(Color.WHITE);		
		scrollTreatmentsPanel = new JScrollPane(treatmentsPanel);
		scrollTreatmentsPanel.setBounds(30, 425, 375, 100);
		scrollTreatmentsPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollTreatmentsPanel.setBorder(null);
		postContentPanel.add(scrollTreatmentsPanel);
		
		String[] treatmentSample = {"Cognitive behavioral therapy (CBT)", "Interpersonal therapy (IPT)", "Behavioral activation therapy (BA)"};
		position = 0;
		for(String name : treatmentSample)
		{
			treatmentsPanel.add(createItem("-    " + name, position));
			position += 30;
		}
		
		takeQuiz = new JButton("TAKE QUIZ");
		takeQuiz.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		takeQuiz.setBounds(155, 538, 120, 40);
		takeQuiz.setFont(new Font("Tahoma", Font.BOLD, 14));
		takeQuiz.setBackground(new Color(102, 205, 170));
		postContentPanel.add(takeQuiz);
		
		authorLabel = new JLabel("Author ");
		authorLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		authorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		authorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		authorLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		authorLabel.setBounds(160, 55, 250, 20);
		postContentPanel.add(authorLabel);

		mainPanel.add(scrollPostPanel);
	}
}
