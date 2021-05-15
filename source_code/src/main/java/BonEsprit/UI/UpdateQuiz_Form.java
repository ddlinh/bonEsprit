package BonEsprit.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

class QuestionPanel extends JPanel {
	JLabel questionLabel;
	JTextArea questionArea;
	
	JTextField answerArea_1;
	JTextField scoreArea_1;
	
	JTextField answerArea_2;
	JTextField scoreArea_2;
	
	JTextField answerArea_3;
	JTextField scoreArea_3;
	
	JTextField answerArea_4;
	JTextField scoreArea_4;
	
	public QuestionPanel(int position, int num) {
		this.setBounds(5, position, 400, 275);
		this.setBackground(new Color(0xD3DEF2));
		this.setLayout(null);
		
		questionLabel = new JLabel("Question: " + num);
		questionLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		questionLabel.setBounds(10, 5, 150, 30);
		
		questionArea = new JTextArea();
		questionArea.setBounds(20, 40, 360, 40);
		
		
		JLabel answerLabel = new JLabel("Answer: ");
		answerLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		answerLabel.setBounds(20, 90, 150, 30);
		
		answerArea_1 = new JTextField();
		answerArea_1.setBounds(20, 125, 200, 30);
		answerArea_1.setBorder(null);
		JLabel score_1 = new JLabel("Score: ");
		score_1.setBounds(230, 125, 80, 30);
		scoreArea_1 = new JTextField();
		scoreArea_1.setBorder(null);
		scoreArea_1.setBounds(290, 125, 90, 30);
		scoreArea_1.setHorizontalAlignment(JTextField.CENTER);
		
		answerArea_2 = new JTextField();
		answerArea_2.setBorder(null);
		answerArea_2.setBounds(20, 160, 200, 30);
		JLabel score_2 = new JLabel("Score: ");
		score_2.setBounds(230, 160, 80, 30);
		scoreArea_2 = new JTextField();
		scoreArea_2.setBorder(null);
		scoreArea_2.setBounds(290, 160, 90, 30);
		scoreArea_2.setHorizontalAlignment(JTextField.CENTER);
		
		answerArea_3 = new JTextField();
		answerArea_3.setBorder(null);
		answerArea_3.setBounds(20, 195, 200, 30);
		JLabel score_3 = new JLabel("Score: ");
		score_3.setBounds(230, 195, 80, 30);
		scoreArea_3 = new JTextField();
		scoreArea_3.setBorder(null);
		scoreArea_3.setBounds(290, 195, 90, 30);
		scoreArea_3.setHorizontalAlignment(JTextField.CENTER);
		
		answerArea_4 = new JTextField();
		answerArea_4.setBorder(null);
		answerArea_4.setBounds(20, 230, 200, 30);
		JLabel score_4 = new JLabel("Score: ");
		score_4.setBounds(230, 230, 80, 30);
		scoreArea_4 = new JTextField();
		scoreArea_4.setBorder(null);
		scoreArea_4.setBounds(290, 230, 90, 30);
		scoreArea_4.setHorizontalAlignment(JTextField.CENTER);
		
		this.add(questionLabel);
		this.add(questionArea);
		this.add(answerLabel);
		
		this.add(answerArea_1);
		this.add(score_1);
		this.add(scoreArea_1);
		
		this.add(answerArea_2);
		this.add(score_2);
		this.add(scoreArea_2);
		
		this.add(answerArea_3);
		this.add(score_3);
		this.add(scoreArea_3);
		
		this.add(answerArea_4);
		this.add(score_4);
		this.add(scoreArea_4);
		
	}
	
}

public class UpdateQuiz_Form extends JFrame {
	private JPanel contentPane;
	private JTextField titleTxtField;
	
	private JButton addQuestion;
	private JButton submitButton;
	private JButton clearButton;
	private JButton cancelButton;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateQuiz_Form frame = new UpdateQuiz_Form();
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
	
	
	public UpdateQuiz_Form() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xFFFFFF));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Title:");
		titleLabel.setBounds(29, 10, 69, 47);
		titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		contentPane.add(titleLabel);
		
		titleTxtField = new JTextField();
		titleTxtField.setBounds(88, 20, 308, 25);
		titleTxtField.setFont(new Font("SansSerif", Font.PLAIN, 18));
		contentPane.add(titleTxtField);
		titleTxtField.setColumns(10);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        submitButton.setBackground(new Color(0x7FF399));
        submitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        submitButton.setBounds(83, 650, 100, 40);
        contentPane.add(submitButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancelButton.setBounds(266, 650, 100, 40);
        cancelButton.setBackground(new Color(0x8D3E3E));
        cancelButton.setForeground(new Color(0xFFFFFF));
        contentPane.add(cancelButton);
        
        JPanel questionPanel = new JPanelCustom(425, 100000);
        questionPanel.setLocation(5, 80);
        questionPanel.setLayout(null);

        JScrollPane questionScroll = new JScrollPane(questionPanel);
        questionScroll.setBounds(5, 80, 425, 500);
        questionScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        questionScroll.setBorder(null);
        questionScroll.setViewportView(questionPanel);
        questionScroll.getVerticalScrollBar().setUnitIncrement(20);
        contentPane.add(questionScroll);
        
        questionPanel.add(new QuestionPanel(5, 1));
        
        
        
        addQuestion = new JButton("Add Question");
        addQuestion.setFont(new Font("Tahoma", Font.BOLD, 15));
        addQuestion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addQuestion.setBackground(new Color(0x85DEB9));
        addQuestion.setBounds(270, 591, 150, 40);
        
        addQuestion.addActionListener(new ActionListener() {
        	int number = 2;
            int position = 290;
            int height = 290 * number;
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				questionPanel.add(new QuestionPanel(position, number));
				position += 300;
				number ++;
				
			}
		});
        contentPane.add(addQuestion);

	}
}
