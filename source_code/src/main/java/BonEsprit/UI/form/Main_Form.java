package BonEsprit.UI.form;

import BonEsprit.Model.User;
import BonEsprit.Model.UserType;
import BonEsprit.UI.UserManager;
import BonEsprit.UI.panel.*;

import java.awt.*;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main_Form extends JFrame {

	private JPanel mainPanel;
	private JTextField searchTextField;
	private JButton menuButton;
	private JButton searchButton;
	private JButton homeButton;
	private JButton allPostsButton;
	private JButton allQuizzesButton;

	private JPanel menuPanel;
	private JButton myAccountButton;
	private JButton myProfileButton;
	private JButton myTestResultsButton;
	private JButton myPostsButton;
	private JButton signOutButton;

	private JPanel contentPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Main_Form frame = new Main_Form();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_Form() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 850);
		
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
		menuButton.setBackground(new Color(0xC4C4C4));
		
		try {
		    Image img = ImageIO.read(new File("./resources/menubar.png"));
		    Image newimg = img.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH ) ;
		    menuButton.setIcon(new ImageIcon(newimg));
		    
		  } catch (Exception ex) {
		    ex.printStackTrace();
		  }

		menuButton.setBounds(10, 10, 40, 40);
		menuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		homePanel.add(menuButton);

		menuPanel = new JPanel();
		menuPanel.setBounds(10, 5, 300, 500);
		menuPanel.setLayout(null);
		menuPanel.setVisible(false);
		menuPanel.setBackground(new Color(0xF0F3F1));

		myAccountButton = new JButton("MY ACCOUNTS");
		myAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		myAccountButton.setFont(new Font("Sans Serif", Font.BOLD, 20));
		myAccountButton.setBounds(20, 100, 260, 50);
		myAccountButton.setBackground(new Color(0xC5D4CB));
		myAccountButton.setBorder(null);
		menuPanel.add(myAccountButton);

		myProfileButton = new JButton("MY PROFILE");
		myProfileButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		myProfileButton.setFont(new Font("Sans Serif", Font.BOLD, 20));
		myProfileButton.setBounds(20, 170, 260, 50);
		myProfileButton.setBackground(new Color(0xC5D4CB));
		myProfileButton.setBorder(null);
		menuPanel.add(myProfileButton);

		myTestResultsButton = new JButton("MY TEST RESULTS");
		myTestResultsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		myTestResultsButton.setFont(new Font("Sans Serif", Font.BOLD, 20));
		myTestResultsButton.setBounds(20, 240, 260, 50);
		myTestResultsButton.setBackground(new Color(0xC5D4CB));
		myTestResultsButton.setBorder(null);
		menuPanel.add(myTestResultsButton);

		myPostsButton = new JButton("MY POSTS");
		myPostsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		myPostsButton.setFont(new Font("Sans Serif", Font.BOLD, 20));
		myPostsButton.setBounds(20, 310, 260, 50);
		myPostsButton.setBackground(new Color(0xC5D4CB));
		myPostsButton.setBorder(null);
		menuPanel.add(myPostsButton);

		signOutButton = new JButton("SIGN OUT");
		signOutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signOutButton.setFont(new Font("Sans Serif", Font.BOLD, 20));
		signOutButton.setBounds(20, 380, 260, 50);
		signOutButton.setBackground(new Color(0xCFCECE));
		signOutButton.setBorder(null);

		signOutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserManager.set(new User(0L));
			}
		});

		menuPanel.add(signOutButton);

		mainPanel.add(menuPanel);

		menuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(menuPanel.isVisible())
					menuPanel.setVisible(false);
				else
					menuPanel.setVisible(true);
			}
		});

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
		    ex.printStackTrace();
		  }
		searchButton.setBounds(320, 17, 30, 30);
		homePanel.add(searchButton);
		
		JLabel logo = new JLabel();
		try {
		    Image img = ImageIO.read(new File("./resources/brain.png"));
		    Image newimg = img.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH ) ;
		    logo.setIcon(new ImageIcon(newimg));
		    
		  } catch (Exception ex) {
		    ex.printStackTrace();
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
		homeButton.setBounds(45, 0, 90, 30);
		controlUnitPanel.add(homeButton);
		
		allPostsButton = new JButton("POSTS");
		allPostsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allPostsButton.setBackground(new Color(0xF4B4B4));
		allPostsButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		allPostsButton.setBounds(170, 0, 100, 30);
		controlUnitPanel.add(allPostsButton);
		
		allQuizzesButton = new JButton("QUIZZES");
		allQuizzesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allQuizzesButton.setBackground(new Color(0xF4B4B4));
		allQuizzesButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		allQuizzesButton.setBounds(300, 0, 110, 30);
		controlUnitPanel.add(allQuizzesButton);

		contentPanel = new Home_Panel(this).getContentPanel();
		mainPanel.add(contentPanel);
		myAccountButton.addActionListener(e -> {
			mainPanel.remove(contentPanel);
			contentPanel = new MyAccount_Panel().getContentPanel();
			mainPanel.add(contentPanel);
			mainPanel.revalidate();
			mainPanel.repaint();
		});

		myAccountButton.addActionListener(e -> {
			changePanel(new MyAccount_Panel().getContentPanel());
		});

		myProfileButton.addActionListener(e -> {
			//changePanel(new MyProfile_Panel(UserManager.get().getTypeUser() == UserType.THERAPIST.getValue()).getContentPanel());
			changePanel(new MyProfile_Panel().getContentPanel());
		});

		myTestResultsButton.addActionListener(e -> {
			changePanel(new MyTestResult_Panel().getContentPanel());
		});

		myPostsButton.addActionListener(e -> {
			Component component = (Component) e.getSource();
			Main_Form frame = (Main_Form) SwingUtilities.getRoot(component);
			changePanel(new MyPost_Panel(frame).getContentPanel());
		});

		homeButton.addActionListener(e -> {
			Component component = (Component) e.getSource();
			Main_Form frame = (Main_Form) SwingUtilities.getRoot(component);
			changePanel(new Home_Panel(frame).getContentPanel());
		});

		allPostsButton.addActionListener(e -> {
			Component component = (Component) e.getSource();
			Main_Form frame = (Main_Form) SwingUtilities.getRoot(component);
			changePanel(new List_Post_Panel(frame).getContentPanel());
		});

		allQuizzesButton.addActionListener(e -> {
			Component component = (Component) e.getSource();
			Main_Form frame = (Main_Form) SwingUtilities.getRoot(component);
			changePanel(new List_Quizz_Panel(frame).getContentPanel());
		});

		searchButton.addActionListener(e -> {
			Component component = (Component) e.getSource();
			Main_Form frame = (Main_Form) SwingUtilities.getRoot(component);
			changePanel(new Search_Panel(frame, searchTextField.getText()).getContentPanel());
		});

	}

	public void changePanel(JPanel panel) {
		mainPanel.remove(contentPanel);
		contentPanel = panel;
		mainPanel.add(contentPanel);
		mainPanel.revalidate();
		mainPanel.repaint();
	}
}
