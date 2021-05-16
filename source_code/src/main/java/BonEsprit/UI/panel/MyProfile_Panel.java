package BonEsprit.UI.panel;

import BonEsprit.Model.Certificate;
import BonEsprit.Model.UserType;
import BonEsprit.Service.UserService;
import BonEsprit.UI.UserManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyProfile_Panel extends Content_Panel {

	private JPanel profilePanel;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField workingPlace;
	private JTextField experiences;
	private ArrayList<JTextField> certificates;
	private JButton addCertificate;
	private JButton submitProfile;

	public JPanel createItem(String label, String info, int position, JTextField infoTextField)
	{
		JPanel newItem = new JPanel();
		newItem.setBounds(10, position, 400, 30);
		newItem.setBackground(new Color(255, 250, 240));
		newItem.setLayout(null);
		
		JLabel profileLabel = new JLabel(label + ":");
		profileLabel.setBounds(0, 5, 120, 25);
		profileLabel.setForeground(new Color(0, 0, 51));
		profileLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		infoTextField = new JTextField(info);
		infoTextField.setEditable(false);
		infoTextField.setBorder(null);
		infoTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		infoTextField.setBounds(130, 5, 180, 25);
		infoTextField.setBackground(new Color(0xE4F5F9));

		newItem.add(profileLabel);
		newItem.add(infoTextField);
		return newItem;
	}
	
	public JPanel createCertificate(int position, JTextField certificateTextField) {
		JPanel newCertificate = new JPanel();
		newCertificate.setBounds(10, position, 350, 30);
		newCertificate.setBackground(new Color(255, 250, 240));
		newCertificate.setLayout(null);
		
		JTextField certificateTxt = new JTextField(certificateTextField.getText());
		certificateTxt.setBounds(0, 5, 250, 25);
		certificateTxt.setBorder(null);
		certificateTxt.setEditable(false);
		certificateTxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		certificateTxt.setBackground(new Color(0xE4F5F9));

		newCertificate.add(certificateTxt);
		return newCertificate;
	}
	
	
	public MyProfile_Panel() {
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0xFFFFFF));
		contentPanel.setBounds(0, 50, 450, 735);
		contentPanel.setLayout(null);

		Image img;
		String name = "Hello, " + UserManager.get().getFirstName();
		JLabel welcomeLabel = new JLabel(name);
		try {
			img = ImageIO.read(new File("./resources/smile.png"));
			Image newimg = img.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH ) ;
			welcomeLabel = new JLabel(name, new ImageIcon(newimg), JLabel.LEFT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		welcomeLabel.setForeground(new Color(0, 51, 51));
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		welcomeLabel.setBounds(20, 120, 300, 50);
		contentPanel.add(welcomeLabel);
		
		JLabel profileLabel = new JLabel("Your Profile Information:");
		profileLabel.setForeground(new Color(51, 102, 51));
		profileLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		profileLabel.setBounds(20, 208, 300, 30);
		contentPanel.add(profileLabel);
		
		profilePanel = new JPanel();
		profilePanel.setBounds(10, 260, 400, 150);
		profilePanel.setBackground(new Color(255, 250, 240));
		profilePanel.setLayout(null);
		
		profilePanel.add(createItem("First name", UserManager.get().getFirstName(), 10, this.firstName));
		profilePanel.add(createItem("Last name", UserManager.get().getLastName(), 50, this.lastName));
		profilePanel.add(createItem("Email", "email", 90, this.email));
		
		if(UserManager.get().getTypeUser() == UserType.THERAPIST.getValue()) {
			profilePanel.setSize(400, 410);
			profilePanel.add(createItem("<html>Working place</html>", UserManager.get().getWorkingPlace(), 130, this.workingPlace));
			profilePanel.add(createItem("<html>Experience:</html>", UserManager.get().getExperiences() + " year(s)", 170, this.experiences));
			JLabel certificateLabel = new JLabel("Certificates:");
			certificateLabel.setBounds(10, 210, 120, 25);
			certificateLabel.setForeground(new Color(0, 0, 51));
			certificateLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			profilePanel.add(certificateLabel);
			
			JPanel certificatePanel = new JPanelCustom(350, 300);
			certificatePanel.setBackground(new Color(255, 250, 240));
			certificatePanel.setLocation(20,240);
			certificatePanel.setLayout(null);
			
			JScrollPane certificateScroll = new JScrollPane(certificatePanel);
			certificateScroll.setBounds(20, 240, 350, 100);
			certificateScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			certificateScroll.setBorder(null);
			profilePanel.add(certificateScroll);

			int position = 0;
			certificates = new ArrayList<JTextField>();

			List<Certificate> c = new ArrayList<Certificate>();
			c.addAll(UserService.getCertificate(UserManager.get().getID()));

			for (int i = 0; i < c.size(); i++) {
				certificates.add(new JTextField(c.get(i).getName()));
			}

			for(JTextField jtf : certificates) {
				certificatePanel.add(createCertificate(position, jtf));
				position += 30;
			}
			
//			addCertificate = new JButton();
//			addCertificate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//			addCertificate.setBackground(new Color(255, 250, 240));
//			addCertificate.setBorder(null);
//			addCertificate.setBounds(300, 350, 25, 25);
//			try {
//			    Image imgAdd = ImageIO.read(new File("./resources/add4.png"));
//			    Image newimg = imgAdd.getScaledInstance(25, 25,  java.awt.Image.SCALE_REPLICATE ) ;
//			    addCertificate.setIcon(new ImageIcon(newimg));
//			  } catch (Exception ex) {
//			    ex.printStackTrace();
//			  }
//
//			submitProfile = new JButton("SUBMIT");
//			submitProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//			submitProfile.setBackground(new Color(0xD3DEF2));
//			submitProfile.setBounds(145, 375, 100, 30);
//
//			profilePanel.add(addCertificate);
//			profilePanel.add(submitProfile);
		}


		contentPanel.add(profilePanel);
	}

}
