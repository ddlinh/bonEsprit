package BonEsprit.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Main_Form extends JFrame {

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
					Main_Form frame = new Main_Form();
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
	public Main_Form() {
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
		homeButton.setBackground(new Color(0xF4B4B4));
		homeButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		homeButton.setBounds(45, 0, 90, 30);
		controlUnitPanel.add(homeButton);
		
		allPostsButton = new JButton("POSTS");
		allPostsButton.setBackground(new Color(0xF4B4B4));
		allPostsButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		allPostsButton.setBounds(170, 0, 100, 30);
		controlUnitPanel.add(allPostsButton);
		
		allQuizzesButton = new JButton("QUIZZES");
		allQuizzesButton.setBackground(new Color(0xF4B4B4));
		allQuizzesButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		allQuizzesButton.setBounds(300, 0, 105, 30);
		controlUnitPanel.add(allQuizzesButton);

		mainPanel.add(createHomePanel());
	}
	
	private JPanel createSearchView(String keyword) {
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0xFFFFFF));
		contentPanel.setBounds(0, 95, 450, 735);
		contentPanel.setLayout(null);

		JLabel searchLabel = new JLabel("Search: ");
		searchLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		searchLabel.setBounds(25, 5, 200, 50);
		contentPanel.add(searchLabel);

		JLabel searchKeywordLabel = new JLabel(keyword);
		searchKeywordLabel.setFont(new Font("SansSerif", Font.ITALIC, 16));
		searchKeywordLabel.setBounds(110, 5, 200, 50);
		contentPanel.add(searchKeywordLabel);

		
		String[] postTitles = {"Depression", "General Anxiety", "OCD", "Schizophrenia"};
		String[] authorNames = {"Sigmund Freud", "Carl Jung", "Carl Rogers", "Alfred Kinsey"};
		
		// Item post panel
		JPanel postSearchPanel = new JPanelCustom(440, 1000);
		postSearchPanel.setLocation(10, 70);
		postSearchPanel.setLayout(null);
		postSearchPanel.setBackground(new Color(0XFFFFFF));
		
		JScrollPane postSearchScrollPanel = new JScrollPane(postSearchPanel);
		postSearchScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		postSearchScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		postSearchScrollPanel.setBorder(null);
		postSearchScrollPanel.setBounds(5, 70, 440, 500);
		
		postSearchScrollPanel.setBackground(new Color(0xFFFFFF));
		postSearchScrollPanel.getVerticalScrollBar().getUnitIncrement(10);
		contentPanel.add(postSearchScrollPanel);
		
		for (int i = 0; i < 3; i++) {
			JPanel itemPost1 = new JPanel();

			createItemPostPanel(itemPost1,
					5,
					5 + 135*i,
					postTitles[i],
					authorNames[i],
					"Simple Introduction to " + postTitles[i],
					"2/5/2021"
			);

			postSearchPanel.add(itemPost1);
		}


		return contentPanel;
	}

	private JPanel createQuizzesView() {
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0xFFFFFF));
		contentPanel.setBounds(0, 95, 450, 735);
		contentPanel.setLayout(null);

		JLabel latestPostLabel = new JLabel("All Quizzes");
		latestPostLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		latestPostLabel.setBounds(160, 30, 200, 50);
		contentPanel.add(latestPostLabel);

		// Item post panel
		JPanel quizPanel = new JPanelCustom(440, 1000);
		quizPanel.setLocation(10, 80);
		quizPanel.setLayout(null);
		quizPanel.setBackground(new Color(0XFFFFFF));
		
		JScrollPane quizScrollPanel = new JScrollPane(quizPanel);
		quizScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		quizScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		quizScrollPanel.setBorder(null);
		quizScrollPanel.getVerticalScrollBar().setUnitIncrement(10);
		quizScrollPanel.setBounds(5, 80, 440, 500);
		
		quizScrollPanel.setBackground(new Color(0xFFFFFF));
		quizScrollPanel.getVerticalScrollBar().getUnitIncrement(10);
		contentPanel.add(quizScrollPanel);

		
		String[] postTitles = {"Depression", "General Anxiety", "OCD", "Schizophrenia"};
		String[] authorNames = {"Sigmund Freud", "Carl Jung", "Carl Rogers", "Alfred Kinsey"};
		for (int i = 0; i < 4; i++) {
			JPanel itemPost1 = new JPanel();

			createItemPostPanel(itemPost1,
					10,
					5 + (120 * i),
					"Test for " + postTitles[i],
					authorNames[i],
					"Simple test for " + postTitles[i],
					"2/5/2021"
			);

			quizPanel.add(itemPost1);
		}

		return contentPanel;
	}

	private JPanel createPostView() {
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0xFFFFFF));
		contentPanel.setBounds(0, 95, 450, 750);
		contentPanel.setLayout(null);

		JLabel latestPostLabel = new JLabel("All Posts");
		latestPostLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		latestPostLabel.setBounds(160, 30, 200, 50);
		contentPanel.add(latestPostLabel);

		// Item post panel
		
		JPanel postPanel = new JPanelCustom(440, 1000);
		postPanel.setLocation(10, 80);
		postPanel.setLayout(null);
		postPanel.setBackground(new Color(0XFFFFFF));
		
		JScrollPane postScrollPanel = new JScrollPane(postPanel);
		postScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		postScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		postScrollPanel.setBorder(null);
		postScrollPanel.getVerticalScrollBar().setUnitIncrement(10);
		postScrollPanel.setBounds(5, 80, 440, 500);
		
		postScrollPanel.setBackground(new Color(0xFFFFFF));
		postScrollPanel.getVerticalScrollBar().getUnitIncrement(10);
		contentPanel.add(postScrollPanel);

		
		String[] postTitles = {"Depression", "General Anxiety", "OCD", "Schizophrenia"};
		String[] authorNames = {"Sigmund Freud", "Carl Jung", "Carl Rogers", "Alfred Kinsey"};
		for (int i = 0; i < 4; i++) {
			JPanel itemPost1 = new JPanel();

			createItemPostPanel(itemPost1,
					10,
					5 + (120 * i),
					postTitles[i],
					authorNames[i],
					"Simple introduction to " + postTitles[i],
					"2/5/2021"
			);

			postPanel.add(itemPost1);
		}
		return contentPanel;
	}

	private void createItemPostPanel(JPanel latestPostDetailPanel, int x, int y, String title, String author, String description, String datetime) {
		latestPostDetailPanel.setBounds(x, y,410,110);
		latestPostDetailPanel.setBackground(new Color(0xD3E4F9));
		latestPostDetailPanel.setLayout(null);
		latestPostDetailPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel titleLatestPostLabel = new JLabel(title);
		titleLatestPostLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		titleLatestPostLabel.setBounds(5, 10, 300, 20);
		latestPostDetailPanel.add(titleLatestPostLabel);

		JLabel authorLatestPostLabel = new JLabel(author);
		authorLatestPostLabel.setFont(new Font("SansSerif", Font.ITALIC, 14));
		authorLatestPostLabel.setBounds(300, 10, 200 , 20);
		authorLatestPostLabel.setHorizontalAlignment(SwingConstants.LEFT);
		latestPostDetailPanel.add(authorLatestPostLabel);

		JLabel descriptionLatestPostLabel = new JLabel(description);
		descriptionLatestPostLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
		descriptionLatestPostLabel.setBounds(5, 32, 500, 20);
		latestPostDetailPanel.add(descriptionLatestPostLabel);

		JLabel dateLatestPostLabel = new JLabel(datetime);
		dateLatestPostLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
		dateLatestPostLabel.setBounds(5, 73, 500, 20);
		latestPostDetailPanel.add(dateLatestPostLabel);
	}
	
	private void createItemTherapist(JPanel therapistPanel, int x, int y, String name) {
		therapistPanel.setLayout(null);
		therapistPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		therapistPanel.setBackground(new Color(0xffffff));
		therapistPanel.setBounds(x, y, 150, 150);

		JLabel imageTherapist = new JLabel();
		try {
			Image image = ImageIO.read(new File("./resources/therapist.png"));
			Image imageICON = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH );
			imageTherapist.setIcon(new ImageIcon(imageICON));
		} catch (Exception e) {
			e.printStackTrace();
		}
		imageTherapist.setBounds(35, 25, 50, 50);
		imageTherapist.setBorder(null);
		
		JLabel nameLabel = new JLabel(name);
		nameLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		nameLabel.setBounds(20, 85, 130, 20);
		
		therapistPanel.add(imageTherapist);
		therapistPanel.add(nameLabel);
	}

	private JPanel createHomePanel() {
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0xFFFFFF));
		contentPanel.setBounds(0, 95, 450, 735);
		contentPanel.setLayout(null);

		JLabel latestPostLabel = new JLabel("Latest Posts");
		latestPostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		latestPostLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		latestPostLabel.setBounds(140, 30, 160, 50);
		contentPanel.add(latestPostLabel);

		// Begin of latest post panel creating
		JPanel postPanel = new JPanelCustom(440, 1000);
		postPanel.setLocation(10, 80);
		postPanel.setLayout(null);
		postPanel.setBackground(new Color(0XFFFFFF));
		
		JScrollPane postScrollPanel = new JScrollPane(postPanel);
		postScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		postScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		postScrollPanel.setBorder(null);
		postScrollPanel.getVerticalScrollBar().setUnitIncrement(10);
		postScrollPanel.setBounds(5, 80, 440, 250);
		
		postScrollPanel.setBackground(new Color(0xFFFFFF));
		postScrollPanel.getVerticalScrollBar().getUnitIncrement(10);
		contentPanel.add(postScrollPanel);
		
		String[] postTitles = {"Depression", "General Anxiety", "OCD", "Schizophrenia"};
		String[] authorNames = {"Sigmund Freud", "Carl Jung", "Carl Rogers", "Alfred Kinsey"};
		for (int i = 0; i < 4; i++) {
			JPanel itemPost1 = new JPanel();

			createItemPostPanel(itemPost1,
					10,
					5 + (120 * i),
					postTitles[i],
					authorNames[i],
					"Simple introduction to " + postTitles[i],
					"2/5/2021"
			);

			postPanel.add(itemPost1);
		}

		// End of latest post panel creating

		JLabel mostHonorableTherapistPanel = new JLabel("Most Honorable Therapist");
		mostHonorableTherapistPanel.setFont(new Font("SansSerif", Font.BOLD, 24));
		mostHonorableTherapistPanel.setBounds(80, 350, 400, 50);
		contentPanel.add(mostHonorableTherapistPanel);


		// Begin of therapist panel creating
		
		JPanel therapistPanel = new JPanelCustom(1000, 300);
		therapistPanel.setLocation(5, 390);
		therapistPanel.setLayout(null);
		therapistPanel.setBackground(new Color(0XFFFFFF));
		
		JScrollPane therapistScrollPanel = new JScrollPane(therapistPanel);
		therapistScrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		therapistScrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		therapistScrollPanel.setBorder(null);
		therapistScrollPanel.getHorizontalScrollBar().setUnitIncrement(10);
		therapistScrollPanel.setBounds(5, 390, 440, 180);
		
		therapistScrollPanel.setBackground(new Color(0xFFFFFF));
		therapistScrollPanel.getHorizontalScrollBar().getUnitIncrement(10);
		contentPanel.add(therapistScrollPanel);

		for(int i = 0; i < 4; i++)
		{
			JPanel therapist = new JPanel();
			createItemTherapist(therapist, 5 + i*130, 20, "Therapist" + " " + i);
			therapistPanel.add(therapist);
		}
		

		return contentPanel;
	}


}
