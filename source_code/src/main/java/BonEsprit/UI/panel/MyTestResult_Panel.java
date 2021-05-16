package BonEsprit.UI.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;



class ResultPanel extends JPanel{
	JLabel testnameLabel;
	JLabel resultLabel;
	
	public ResultPanel(int position, String testname, String result) {
		this.setBounds(10, position, 394, 38);
		this.setBackground(new Color(0xD3DEF2));
		this.setLayout(null);
		
		testnameLabel = new JLabel(testname);
		testnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		testnameLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		testnameLabel.setBounds(10, 0, 180, 38);
		this.add(testnameLabel);
		
		resultLabel = new JLabel(result);
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		resultLabel.setBounds(214, 0, 180, 38);
		this.add(resultLabel);
	}
}

public class MyTestResult_Panel extends Content_Panel {


	public MyTestResult_Panel() {
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0xFFFFFF));
		contentPanel.setBounds(0, 95, 450, 735);
		contentPanel.setLayout(null);

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
		welcomeLabel.setFont(new Font("Roboto", Font.ITALIC | Font.BOLD, 24));
		welcomeLabel.setBounds(10, 130, 200, 50);
		contentPanel.add(welcomeLabel);
		
//		JLabel helloLabel = new JLabel("Hello, first name");
//		helloLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
//		helloLabel.setBounds(10, 130, 200, 50);
//		contentPanel.add(helloLabel);
		
		JLabel yourtestresultLabel = new JLabel("Your Test Results");
		yourtestresultLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		yourtestresultLabel.setBounds(10, 191, 250, 30);
		contentPanel.add(yourtestresultLabel);
		
		
		JPanel resultPane = new JPanelCustom(414, 10000);
		resultPane.setLocation(10, 227);
		resultPane.setBackground(new Color(0xD3DEF2));
		resultPane.setLayout(null);
		
		JScrollPane resultScrollPane = new JScrollPane(resultPane);
		resultScrollPane.setBounds(10, 227, 414, 474);
		resultScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		resultScrollPane.setBorder(null);
		resultScrollPane.setViewportView(resultPane);
		resultScrollPane.getVerticalScrollBar().setUnitIncrement(20);
		contentPanel.add(resultScrollPane);
		
		JLabel titleoftestLabel = new JLabel("Title of test");
		titleoftestLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleoftestLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		titleoftestLabel.setBounds(10, 11, 190, 38);
		resultPane.add(titleoftestLabel);
		
		JLabel resultLabel = new JLabel("Result");
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		resultLabel.setBounds(214, 11, 190, 38);
		resultPane.add(resultLabel);
		
		JSeparator horizonSep = new JSeparator();
		horizonSep.setForeground(Color.BLACK);
		horizonSep.setBounds(10, 47, 394, 1);
		resultPane.add(horizonSep);
		
		JSeparator verticalSep = new JSeparator();
		verticalSep.setForeground(Color.BLACK);
		verticalSep.setOrientation(SwingConstants.VERTICAL);
		verticalSep.setBounds(199, 11, 1, 400);
		resultPane.add(verticalSep);

		resultPane.add(new ResultPanel(60, "Item 1", "Item 1'")); // + 48
		resultPane.add(new ResultPanel(108, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(156, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(204, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(252, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(300, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(348, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(396, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(444, "Item 2", "Item 2'"));
		resultPane.add(new ResultPanel(492, "Item 7", "Item 7'"));
	}
}
