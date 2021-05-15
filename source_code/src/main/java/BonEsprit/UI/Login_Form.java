package BonEsprit.UI;

import BonEsprit.Model.User;
import BonEsprit.Service.UserService;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Form extends JFrame {
	private JPanel contentPane;
	private JTextField usernameTxt;
	private JTextField passwordTxt;
	private JButton loginBtn;
	private JButton signupBtn;
	private UserService userService = new UserService();

	/**
	 * Create the frame.
	 */
	public Login_Form(Layout_Form layoutForm) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(new Rectangle(0, 100, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setAlignmentX(CENTER_ALIGNMENT);
		contentPane.setAlignmentY(CENTER_ALIGNMENT);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Bon Esprit");
		titleLabel.setFont(new Font("Roboto", Font.BOLD, 40));
		titleLabel.setBounds(118, 36, 250, 75);
		contentPane.add(titleLabel);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		usernameLabel.setBounds(73, 130, 100, 30);
		contentPane.add(usernameLabel);
		
		usernameTxt = new JTextField();
		usernameTxt.setBorder(null);
		usernameTxt.setBackground(new Color(0xE1EFF3));
		usernameTxt.setFont(new Font("Roboto", Font.PLAIN, 16));
		usernameTxt.setBounds(158, 131, 202, 30);
		contentPane.add(usernameTxt);
		usernameTxt.setColumns(10);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		passLabel.setBounds(73, 171, 75, 30);
		contentPane.add(passLabel);
		
		passwordTxt = new JTextField();
		passwordTxt.setBorder(null);
		passwordTxt.setFont(new Font("Roboto", Font.PLAIN, 16));
		passwordTxt.setBackground(new Color(0xE1EFF3));
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(158, 171, 202, 30);
		contentPane.add(passwordTxt);
		
	
		loginBtn = new JButton("Login");
		loginBtn.setForeground(new Color(81, 61, 61));
		loginBtn.setFont(new Font("Roboto", Font.BOLD, 16));
		loginBtn.setBorder(null);
		loginBtn.setBackground(new Color(0x78C9BA));
		loginBtn.setBounds(158, 230, 109, 40);
		loginBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User userInfo = userService.logIn(usernameTxt.getText(), passwordTxt.getText());

				if (userInfo.getID() == 0 || userInfo == null) {
					JOptionPane.showMessageDialog(contentPane, "Invalid username or Wrong password");
					return;
				}

				UserManager.set(userInfo);
			}
		});

		contentPane.add(loginBtn);
		
		
		signupBtn = new JButton("Sign Up");
		signupBtn.setBackground(new Color(0xB6C6C3));
		signupBtn.setForeground(new Color(0x513D3D));
		signupBtn.setFont(new Font("Roboto", Font.BOLD, 16));
		signupBtn.setBorder(null);
		signupBtn.setBounds(158, 293, 109, 40);
		signupBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		signupBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				layoutForm.add(new Signup_Form(layoutForm));
			}
		});

		contentPane.add(signupBtn);
	}
}
