package BonEsprit.UI.panel;

import BonEsprit.Model.Problem;
import BonEsprit.Model.Treatment;
import BonEsprit.UI.form.Main_Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class ProblemView_Panel extends Content_Panel {
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
	
	public JLabel createItem(String name, int position) {
		JLabel newText = new JLabel("<html>" + name + "</html>");
		newText.setBounds(10, position, 350, 20);
		newText.setFont(new Font("SansSerif", Font.PLAIN, 17));
		
		return newText;
	}
	
	public ProblemView_Panel(Problem problem, Main_Form mainForm) {
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0xFFFFFF));
		contentPanel.setBounds(0, 95, 450, 735);
		contentPanel.setLayout(null);
		
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
		
		postTitleLabel = new JLabel(problem.getName());
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

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(problem.getDate());

		int mYear = calendar.get(Calendar.YEAR);
		int mMonth = calendar.get(Calendar.MONTH);
		int mDay = calendar.get(Calendar.DAY_OF_MONTH);

		dateLabel = new JLabel(mDay + "/" + mMonth + "/" + mYear);
		dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
		dateLabel.setBounds(30, 55, 111, 20);
		postContentPanel.add(dateLabel);
		
		JTextArea descriptionTextArea = new JTextArea();
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setWrapStyleWord(true);
		descriptionTextArea.setFont(new Font("SansSerif", Font.PLAIN, 17));
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setText(problem.getDescription());
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
		

		int position = 0;
		for(int i = 0; i < problem.getSymptoms().size(); i++)
		{
			symptomsPanel.add(createItem("-    " + problem.getSymptoms().get(i).getContent(), position));
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
		
		position = 0;
		for(Treatment name : problem.getTreatments())
		{
			treatmentsPanel.add(createItem("-    " + name.getContent(), position));
			position += 30;
		}
		
		takeQuiz = new JButton("TAKE QUIZ");
		takeQuiz.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		takeQuiz.setBounds(155, 538, 120, 40);
		takeQuiz.setFont(new Font("Tahoma", Font.BOLD, 14));
		takeQuiz.setBackground(new Color(102, 205, 170));
		postContentPanel.add(takeQuiz);

		takeQuiz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	//			mainForm.changePanel(new QuizView_Panel(problem.getQuizzes().get(0), mainForm).getContentPanel());
			}
		});

		authorLabel = new JLabel(problem.getAuthor().getFirstName() + " " + problem.getAuthor().getLastName());
		authorLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		authorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		authorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		authorLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		authorLabel.setBounds(160, 55, 250, 20);
		postContentPanel.add(authorLabel);

		contentPanel.add(scrollPostPanel);
	}
}
