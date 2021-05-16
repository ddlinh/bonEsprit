package BonEsprit.UI.panel;

import BonEsprit.Model.UserType;
import BonEsprit.UI.UserManager;
import BonEsprit.UI.panel.Content_Panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dialog.ModalExclusionType;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;

public class MyAccount_Panel extends Content_Panel {

	private JLabel accountInfo_1;
	private JLabel accountInfo_2;
	private JLabel accountInfo_3;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	
	public JLabel createPasswordLabel(String password) {
		String text = "";
		for(int i = 0; i < password.length(); i++)
			text += "*";

		return new JLabel(text);
	}
	
	public MyAccount_Panel() {
		
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0xFFFFFF));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPanel);
		contentPanel.setBounds(0, 95, 450, 750);
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
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		welcomeLabel.setBounds(20, 90, 300, 50);
		contentPanel.add(welcomeLabel);
		
		JLabel lblYourAccountInformation = new JLabel("Your Account Information:");
		lblYourAccountInformation.setForeground(new Color(51, 102, 51));
		lblYourAccountInformation.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblYourAccountInformation.setBounds(20, 178, 300, 30);
		contentPanel.add(lblYourAccountInformation);
		
		JPanel accountPanel = new JPanel();
		accountPanel.setBounds(20, 230, 395, 247);
		accountPanel.setBackground(new Color(0xF3EDED));
		contentPanel.add(accountPanel);
		accountPanel.setLayout(null);
		
		accountInfo_1 = new JLabel("Username:");
		accountInfo_1.setBounds(10, 30, 100, 25);
		accountInfo_1.setForeground(new Color(0, 0, 51));
		accountInfo_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		accountPanel.add(accountInfo_1);
		
		accountInfo_2 = new JLabel("Password:");
		accountInfo_2.setForeground(new Color(0, 0, 51));
		accountInfo_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		accountInfo_2.setBounds(10, 95, 100, 25);
		accountPanel.add(accountInfo_2);
		
		accountInfo_3 = new JLabel("Account Type:");
		accountInfo_3.setForeground(new Color(0, 0, 51));
		accountInfo_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		accountInfo_3.setBounds(10, 160, 160, 25);
		accountPanel.add(accountInfo_3);
		
		JRadioButton accountTypeButton_Normal = new JRadioButton("Normal");
		accountTypeButton_Normal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		accountTypeButton_Normal.setBounds(50, 200, 120, 25);
		accountPanel.add(accountTypeButton_Normal);
		
		JRadioButton accoungTypeButton_Therapist = new JRadioButton("Therapist");
		accoungTypeButton_Therapist.setFont(new Font("Tahoma", Font.PLAIN, 19));
		accoungTypeButton_Therapist.setBounds(230, 200, 120, 25);
		accountPanel.add(accoungTypeButton_Therapist);

		if(UserManager.get().getTypeUser() == UserType.THERAPIST.getValue()) {
			accoungTypeButton_Therapist.setSelected(true);
			accountTypeButton_Normal.setEnabled(false);
		} else {
			accountTypeButton_Normal.setSelected(true);
			accoungTypeButton_Therapist.setEnabled(false);
		}
		
		usernameLabel = new JLabel(UserManager.get().getUserName());
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		usernameLabel.setBounds(120, 30, 250, 25);
		accountPanel.add(usernameLabel);
		
		passwordLabel = createPasswordLabel(UserManager.get().getPassWord());
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordLabel.setBounds(120, 95, 250, 25);
		accountPanel.add(passwordLabel);
		
		JButton removeAccount = new JButton("REMOVE THIS ACCOUNT");
		removeAccount.setBackground(new Color(153, 0, 0));
		removeAccount.setForeground(new Color(255, 255, 255));
		removeAccount.setFont(new Font("Tahoma", Font.BOLD, 16));
		removeAccount.setBounds(70, 520, 300, 50);
		removeAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPanel.add(removeAccount);

	}
}
