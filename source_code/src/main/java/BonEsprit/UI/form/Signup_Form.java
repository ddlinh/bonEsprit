package BonEsprit.UI.form;

import BonEsprit.Model.User;
import BonEsprit.Service.UserService;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.ComponentOrientation;
import java.util.UUID;

public class Signup_Form extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;
	private JPasswordField password2Txt;
	private JTextField emailTxt;

	/**
	 * Create the frame.
	 */
	@Deprecated
	public Signup_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		usernameLabel.setBounds(30, 38, 80, 30);
		contentPane.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		passwordLabel.setBounds(30, 87, 80, 30);
		contentPane.add(passwordLabel);
		
		JLabel password2Label = new JLabel("<html>Confirm Password</html>");
		password2Label.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		password2Label.setAutoscrolls(true);
		password2Label.setFont(new Font("Roboto", Font.BOLD, 16));
		password2Label.setBounds(30, 128, 80, 40);
		contentPane.add(password2Label);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		emailLabel.setBounds(30, 191, 71, 30);
		contentPane.add(emailLabel);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Account Type");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Roboto", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBounds(30, 232, 109, 30);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JRadioButton normalRadioBtn = new JRadioButton("Normal");
		normalRadioBtn.setFocusable(false);
		normalRadioBtn.setFocusPainted(false);
		normalRadioBtn.setBorder(null);
		normalRadioBtn.setBackground(Color.WHITE);
		normalRadioBtn.setFont(new Font("Roboto", Font.BOLD, 16));
		normalRadioBtn.setBounds(60, 269, 154, 30);
		contentPane.add(normalRadioBtn);
		
		JRadioButton therapistRadioBtn = new JRadioButton("Therapist");
		therapistRadioBtn.setFocusPainted(false);
		therapistRadioBtn.setFocusable(false);
		therapistRadioBtn.setBorder(null);
		therapistRadioBtn.setBackground(Color.WHITE);
		therapistRadioBtn.setFont(new Font("Roboto", Font.BOLD, 16));
		therapistRadioBtn.setBounds(250, 269, 154, 30);
		contentPane.add(therapistRadioBtn);
		
		JButton signupBtn = new JButton("Sign Up");
		signupBtn.setForeground(new Color(81, 61, 61));
		signupBtn.setFont(new Font("Roboto", Font.BOLD, 16));
		signupBtn.setBorder(null);
		signupBtn.setBackground(new Color(182, 198, 195));
		signupBtn.setBounds(161, 306, 109, 40);
		contentPane.add(signupBtn);
		
		JLabel userNameErrorLabel = new JLabel("");
		userNameErrorLabel.setBounds(130, 65, 270, 15);
		contentPane.add(userNameErrorLabel);
		
		usernameTxt = new JTextField();
		usernameTxt.setFont(new Font("Roboto", Font.PLAIN, 16));
		usernameTxt.setColumns(10);
		usernameTxt.setBorder(null);
		usernameTxt.setBackground(new Color(0xE1EFF3));
		usernameTxt.setBounds(129, 39, 275, 25);
		usernameTxt.setInputVerifier(new InputVerifier() {

			@Override
			public boolean verify(JComponent input) {
				String txt = usernameTxt.getText();
				if(txt.length() == 0) {
					userNameErrorLabel.setText("Username cannot be blank");
					return false;
				}
				if(txt.length() < 8) {
					userNameErrorLabel.setText("Username must have more than 7 characters.");
					return false;
				}
				userNameErrorLabel.setText("");
				return true;
			}
			
		});
		
		
		contentPane.add(usernameTxt);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("Roboto", Font.PLAIN, 16));
		passwordTxt.setColumns(10);
		passwordTxt.setBorder(null);
		passwordTxt.setBackground(new Color(225, 239, 243));
		passwordTxt.setBounds(129, 88, 275, 25);
		contentPane.add(passwordTxt);
		
		password2Txt = new JPasswordField();
		password2Txt.setFont(new Font("Roboto", Font.PLAIN, 16));
		password2Txt.setColumns(10);
		password2Txt.setBorder(null);
		password2Txt.setBackground(new Color(225, 239, 243));
		password2Txt.setBounds(129, 138, 275, 25);
		contentPane.add(password2Txt);
		
		emailTxt = new JTextField();
		emailTxt.setFont(new Font("Roboto", Font.PLAIN, 16));
		emailTxt.setColumns(10);
		emailTxt.setBorder(null);
		emailTxt.setBackground(new Color(225, 239, 243));
		emailTxt.setBounds(129, 191, 275, 25);
		contentPane.add(emailTxt);

		User newUser = new User();
		long uniqueNum = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
		newUser.setID(uniqueNum);
		newUser.setUserName(usernameTxt.getText());
		newUser.setPassWord(passwordTxt.getText());
		newUser.setEmail(emailTxt.getText());

		String result = UserService.signUp(newUser);
		signupBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, result);
			}
		});
	}	
	
}
