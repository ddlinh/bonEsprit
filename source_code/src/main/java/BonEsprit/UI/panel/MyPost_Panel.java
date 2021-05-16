package BonEsprit.UI.panel;

import BonEsprit.Model.Problem;
import BonEsprit.Model.Quiz;
import BonEsprit.Service.ProblemService;
import BonEsprit.Service.QuizService;
import BonEsprit.UI.UserManager;
import BonEsprit.UI.form.Main_Form;
import BonEsprit.UI.form.UpdateProblem_Form;
import BonEsprit.UI.form.UpdateQuiz_Form;
import jdk.jfr.internal.tool.Main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

class YourProblem extends JPanel{
	JLabel postnameLabel;
	JButton addQuizButton;
	JPanel panelBtn;
	JButton viewBtn;
	JButton editBtn;
	JButton removeBtn;
	
	public YourProblem(int position, Problem problem, Main_Form mainForm){
		this.setBounds(10, position, 374, 38);
		this.setBackground(new Color(0xD3DEF2));
		this.setBorder(null);
		this.setLayout(null);

		postnameLabel = new JLabel(problem.getName());
		postnameLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		postnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		postnameLabel.setBounds(10, 0, 95, 38);
		this.add(postnameLabel);

//		if(problem.getQuizzes().size() == 0) {
//			addQuizButton = new JButton("Add quizz");
//			addQuizButton.setFont(new Font("SansSerif", Font.ITALIC, 16));
//			addQuizButton.setHorizontalAlignment(SwingConstants.CENTER);
//			addQuizButton.setBounds(100, 0, 95, 38);
//			addQuizButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//			addQuizButton.setBorder(null);
//			addQuizButton.setBackground(new Color(0xD3DEF2));
//			this.add(addQuizButton);
//
//			addQuizButton.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					(new UpdateQuiz_Form(new Quiz(0L), problem)).setVisible(true);
//				}
//			});
//		}

		
		panelBtn = new JPanel();
		panelBtn.setBounds(199, 0, 185, 38);
		panelBtn.setBackground(new Color(0xD3DEF2));
		this.add(panelBtn);
		panelBtn.setLayout(null);

		viewBtn = new JButton();
		viewBtn.setBackground(new Color(0x879CE7));
		viewBtn.setBounds(20, 0, 30, 30);

		Image img = null;
		try {
			img = ImageIO.read(new File("./resources/view.png"));
			Image newimg = img.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH ) ;
			viewBtn.setIcon(new ImageIcon(newimg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		viewBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainForm.changePanel(new ProblemView_Panel(problem, mainForm).getContentPanel());
			}
		});

		panelBtn.add(viewBtn);


		editBtn = new JButton();
		editBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editBtn.setBackground(new Color(0x83AB87));
		editBtn.setBounds(73, 0, 30, 30);
		try {
			img = ImageIO.read(new File("./resources/edit.png"));
			Image newimg = img.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH ) ;
			editBtn.setIcon(new ImageIcon(newimg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				(new UpdateProblem_Form(problem, UserManager.get())).setVisible(true);
			}
		});

		panelBtn.add(editBtn);
		
		removeBtn = new JButton();
		removeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		removeBtn.setBackground(new Color(0xC63636));
		removeBtn.setBounds(127, 0, 30, 30);
		try {
			img = ImageIO.read(new File("./resources/delete-icon.png"));
			Image newimg = img.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH ) ;
			removeBtn.setIcon(new ImageIcon(newimg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		removeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ProblemService.deletePost(problem.getID()))
				{
					JOptionPane.showMessageDialog(panelBtn, "Deleted This Problem");
					panelBtn.setVisible(false);
					postnameLabel.setVisible(false);
				}
			}
		});

		panelBtn.add(removeBtn);
	}
}

class YourQuizz extends JPanel{
	JLabel quiznameLabel;
	JPanel panelBtn;
	JButton viewBtn;
	JButton editBtn;
	JButton removeBtn;
	
	public YourQuizz(int position, Quiz quiz, Main_Form mainForm){
		this.setBounds(10, position, 374, 38);
		this.setBackground(new Color(0xD3DEF2));
		this.setBorder(null);
		this.setLayout(null);

		quiznameLabel = new JLabel(quiz.getName());
		quiznameLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		quiznameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		quiznameLabel.setBounds(10, 0, 175, 38);
		this.add(quiznameLabel);
		
		panelBtn = new JPanel();
		panelBtn.setBounds(200, 0, 185, 38);
		panelBtn.setBackground(new Color(0xD3DEF2));
		this.add(panelBtn);
		panelBtn.setLayout(null);

		viewBtn = new JButton();
		viewBtn.setBackground(new Color(0x879CE7));
		viewBtn.setBounds(20, 0, 30, 30);

		Image img = null;
		try {
			img = ImageIO.read(new File("./resources/view.png"));
			Image newimg = img.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH ) ;
			viewBtn.setIcon(new ImageIcon(newimg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		viewBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainForm.changePanel(new QuizView_Panel(quiz, mainForm).getContentPanel());
			}
		});


		panelBtn.add(viewBtn);

		editBtn = new JButton();
		editBtn.setBackground(new Color(0x83AB87));
		editBtn.setBounds(73, 0, 30, 30);
		try {
			img = ImageIO.read(new File("./resources/edit.png"));
			Image newimg = img.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH ) ;
			editBtn.setIcon(new ImageIcon(newimg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		editBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				(new UpdateQuiz_Form(quiz, quiz.getProblem())).setVisible(true);
			}
		});


		panelBtn.add(editBtn);

		removeBtn = new JButton();
		removeBtn.setBackground(new Color(0xC63636));
		removeBtn.setBounds(127, 0, 30, 30);
		try {
			img = ImageIO.read(new File("./resources/delete-icon.png"));
			Image newimg = img.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH ) ;
			removeBtn.setIcon(new ImageIcon(newimg));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panelBtn.add(removeBtn);
	}
	
}


public class MyPost_Panel extends Content_Panel {

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
	 * Create the frame.
	 */
	public MyPost_Panel(Main_Form mainForm) {
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0xFFFFFF));
		contentPanel.setBounds(0, 95, 450, 800);
		contentPanel.setLayout(null);
		
		Image img;
		String name = "Hello, " + UserManager.get().getFirstName();
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
		welcomeLabel.setBounds(10, 100, 200, 50);
		contentPanel.add(welcomeLabel);
		
		///Your problem
		yourproblemLabel = new JLabel("Your Problem");
		yourproblemLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		yourproblemLabel.setBounds(20, 191, 180, 35);
		contentPanel.add(yourproblemLabel);
		
		JButton addBtn = new JButton("");
		addBtn.setBounds(210, 191, 35, 35);
		addBtn.setBackground(Color.white);
		addBtn.setBorder(null);
		addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		try {
			Image img2 = ImageIO.read(new File("./resources/add.png"));
			Image newimg = img2.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH ) ;
			addBtn.setIcon(new ImageIcon(newimg));
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		contentPanel.add(addBtn);

		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				(new UpdateProblem_Form(new Problem(0L), UserManager.get())).setVisible(true);
			}
		});
		
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
		contentPanel.add(panel_1Scroll);
		
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

		List<Problem> problems = ProblemService.readByUser(UserManager.get().getID());
		System.out.println(problems.size());
		for(int i = 0; i < problems.size(); i++) {
			panel_1.add(new YourProblem(60 + 48*i, problems.get(i), mainForm));
		}
		
		//Your Quizz
		yourquizzLabel = new JLabel("Your Quizzes");
		yourquizzLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		yourquizzLabel.setBounds(20, 457, 129, 35);
		contentPanel.add(yourquizzLabel);
		
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
		contentPanel.add(panel_2Scroll);
		
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

		List<Quiz> quizzes = QuizService.searchByAuthor(UserManager.get().getID());
		for(int i = 0; i < quizzes.size(); i++) {
			panel_2.add(new YourQuizz(60 + 48*i, quizzes.get(i), mainForm));
		}
	}
}
