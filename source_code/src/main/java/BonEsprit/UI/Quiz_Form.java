package BonEsprit.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dialog.ModalExclusionType;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

class Question extends JPanel {
	JLabel questionLabel;
	JLabel questionContent;
	
	ButtonGroup choiceGroup;
	
	JRadioButton answerButton_1;
	JRadioButton answerButton_2;
	JRadioButton answerButton_3;
	JRadioButton answerButton_4;
	
	public Question(int position, int num, String questionContent, List<String> answers) {
		this.setBounds(5, position, 400, 275);
		this.setBackground(new Color(0xD3DEF2));
		this.setLayout(null);
		
		questionLabel = new JLabel("Question: " + num);
		questionLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		questionLabel.setBounds(10, 5, 150, 30);
		
		this.questionContent = new JLabel("<html>" + questionContent + "</html>");
		this.questionContent.setBounds(20, 40, 360, 40);
		this.questionContent.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		
		JLabel answerLabel = new JLabel("Answer: ");
		answerLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		answerLabel.setBounds(20, 90, 150, 30);
		
		answerButton_1 = new JRadioButton(answers.get(0));
		answerButton_1.setBounds(20, 125, 200, 30);
		answerButton_1.setBackground(new Color(0xD3DEF2));
		answerButton_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		answerButton_2 = new JRadioButton(answers.get(1));
		answerButton_2.setBounds(20, 160, 200, 30);
		answerButton_2.setBackground(new Color(0xD3DEF2));
		answerButton_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		answerButton_3 = new JRadioButton(answers.get(2));
		answerButton_3.setBounds(20, 195, 200, 30);
		answerButton_3.setBackground(new Color(0xD3DEF2));
		answerButton_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		answerButton_4 = new JRadioButton(answers.get(3));
		answerButton_4.setBounds(20, 230, 200, 30);
		answerButton_4.setBackground(new Color(0xD3DEF2));
		answerButton_4.setFont(new Font("SansSerif", Font.PLAIN, 16));
				
		this.add(questionLabel);
		this.add(this.questionContent);
		this.add(answerLabel);
		
		this.add(answerButton_1);
		this.add(answerButton_2);
		this.add(answerButton_3);
		this.add(answerButton_4);

	}
	
}


public class Quiz_Form extends JFrame {

	private JPanel mainPanel;
	private JTextField searchTextField;
	private JButton menuButton;
	private JButton searchButton;
	private JButton homeButton;
	private JButton allPostsButton;
	private JButton allQuizzesButton;
	private JLabel quizTitleLabel;
	private JLabel authorLabel;
	private JButton submitButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quiz_Form frame = new Quiz_Form();
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
	public Quiz_Form() {
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
		
		quizTitleLabel = new JLabel("TEST FOR DEPRESSION");
		quizTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		quizTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
		quizTitleLabel.setBounds(0, 120, 440, 30);
		mainPanel.add(quizTitleLabel);
		
		authorLabel = new JLabel("Author ");
		authorLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		authorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		authorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		authorLabel.setFont(new Font("Tahoma", Font.PLAIN | Font.ITALIC, 16));
		authorLabel.setBounds(160, 165, 250, 20);
		mainPanel.add(authorLabel);


		
        JPanel questionPanel = new JPanelCustom(425, 100000);
        questionPanel.setLocation(5, 150);
        questionPanel.setLayout(null);
        questionPanel.setBackground(new Color(0xFFFFFF));

        JScrollPane questionScroll = new JScrollPane(questionPanel);
        questionScroll.setBounds(5, 205, 425, 450);
        questionScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        questionScroll.setBorder(null);
        questionScroll.setViewportView(questionPanel);
        questionScroll.getVerticalScrollBar().setUnitIncrement(20);
        mainPanel.add(questionScroll);
        
        String question = "Question 1";
        List<String> answers = new ArrayList<String>();
        for(int i = 0; i < 4; i++)
        	answers.add("Choice " + i);
        questionPanel.add(new Question(5, 1, question, answers));
        
		submitButton = new JButton("Submit");
		submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submitButton.setBounds(155, 660, 120, 40);
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		submitButton.setBackground(new Color(102, 205, 170));
		mainPanel.add(submitButton);
	}

}
