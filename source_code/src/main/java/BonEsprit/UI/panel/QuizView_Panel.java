package BonEsprit.UI.panel;

import BonEsprit.Model.Quiz;
import BonEsprit.UI.form.Main_Form;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import BonEsprit.Model.Question;
import BonEsprit.Model.Choice;

class QuestionItemPanel extends JPanel {
	JLabel questionLabel;
	JLabel questionContent;
	
	JRadioButton answerButton_1;
	JRadioButton answerButton_2;
	JRadioButton answerButton_3;
	JRadioButton answerButton_4;
	
	public QuestionItemPanel(int position, int num, Question question) {
		this.setBounds(5, position, 400, 275);
		this.setBackground(new Color(0xD3DEF2));
		this.setLayout(null);
		
		questionLabel = new JLabel("Question: " + num);
		questionLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		questionLabel.setBounds(10, 5, 150, 30);
		
		this.questionContent = new JLabel("<html>" + question.getContent() + "</html>");
		this.questionContent.setBounds(20, 40, 360, 40);
		this.questionContent.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		
		JLabel answerLabel = new JLabel("Answer: ");
		answerLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		answerLabel.setBounds(20, 90, 150, 30);
		
		answerButton_1 = new JRadioButton(question.getChoices().get(0).getContent());
		answerButton_1.setBounds(20, 125, 200, 30);
		answerButton_1.setBackground(new Color(0xD3DEF2));
		answerButton_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		answerButton_2 = new JRadioButton(question.getChoices().get(1).getContent());
		answerButton_2.setBounds(20, 160, 200, 30);
		answerButton_2.setBackground(new Color(0xD3DEF2));
		answerButton_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		answerButton_3 = new JRadioButton(question.getChoices().get(2).getContent());
		answerButton_3.setBounds(20, 195, 200, 30);
		answerButton_3.setBackground(new Color(0xD3DEF2));
		answerButton_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		answerButton_4 = new JRadioButton(question.getChoices().get(3).getContent());
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


public class QuizView_Panel extends Content_Panel {
	private JLabel quizTitleLabel;
	private JLabel authorLabel;
	private JButton submitButton;

	public QuizView_Panel(Quiz quiz, Main_Form mainForm) {
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0xFFFFFF));
		contentPanel.setBounds(0, 95, 450, 735);
		contentPanel.setLayout(null);
		
		quizTitleLabel = new JLabel(quiz.getName());
		quizTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		quizTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
		quizTitleLabel.setBounds(0, 120, 440, 30);
		contentPanel.add(quizTitleLabel);
		
		authorLabel = new JLabel(quiz.getAuthor().getFirstName() + " " + quiz.getAuthor().getLastName());
		authorLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		authorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		authorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		authorLabel.setFont(new Font("Tahoma", Font.PLAIN | Font.ITALIC, 16));
		authorLabel.setBounds(160, 165, 250, 20);
		contentPanel.add(authorLabel);

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
		contentPanel.add(questionScroll);

        List<Question> questions = quiz.getQuestions();
        for(int i = 0; i < questions.size(); i++) {
        	questionPanel.add(new QuestionItemPanel(5+280*i, i+1, questions.get(i)));
		}

		submitButton = new JButton("Submit");
		submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		submitButton.setBounds(155, 660, 120, 40);
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		submitButton.setBackground(new Color(102, 205, 170));

		contentPanel.add(submitButton);
	}

}
