package BonEsprit.UI.panel;

import BonEsprit.Model.Problem;
import BonEsprit.Model.User;
import BonEsprit.Service.ProblemService;
import BonEsprit.UI.form.Main_Form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Locale;
import java.util.List;
public class TherapistView_Panel extends Content_Panel {

	public JLabel createCertificate(String name, int position) {
		JLabel x = new JLabel(name);
		x.setBounds(30, position, 380, 20);
		return x;
	}
	
	public JPanel createLatestPost(Problem problem, Main_Form mainForm, int position) {
		JPanel newPostPanel = new JPanel();
		newPostPanel.setLayout(null);
		newPostPanel.setBounds(5, position, 380, 40);
		newPostPanel.setBackground(new Color(0xD3E4F9));
		
		JLabel titlePost = new JLabel(problem.getName());
		titlePost.setBounds(10, 0, 380, 20);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(problem.getDate());
		int mYear = calendar.get(Calendar.YEAR);
		int mMonth = calendar.get(Calendar.MONTH);
		int mDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		String date = mDay + "/" + mMonth + "/" + mYear;
		JLabel datePost = new JLabel(date);
		datePost.setBounds(10, 20, 380, 20);
		
		newPostPanel.add(titlePost);
		newPostPanel.add(datePost);
		
		newPostPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		newPostPanel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainForm.changePanel(new ProblemView_Panel(problem, mainForm).getContentPanel());
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		return newPostPanel;
	}
	
	public TherapistView_Panel(User therapist, Main_Form mainForm) {
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0xFFFFFF));
		contentPanel.setBounds(0, 95, 450, 735);
		contentPanel.setLayout(null);

		JPanel therapistContentPanel = new JPanel();
		therapistContentPanel.setAutoscrolls(true);
		therapistContentPanel.setBackground(Color.WHITE);
		therapistContentPanel.setBounds(0, 100, 450, 700);
		therapistContentPanel.setLayout(null);
		
		JScrollPane scrollTherapistPanel = new JScrollPane(therapistContentPanel);
		scrollTherapistPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollTherapistPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTherapistPanel.setAutoscrolls(true);
		scrollTherapistPanel.setBounds(0, 100, 450, 630);

		contentPanel.add(scrollTherapistPanel);
		
		JLabel therapistTitleLabel = new JLabel((therapist.getFirstName() + " " + therapist.getLastName()).toUpperCase());
		therapistTitleLabel.setForeground(new Color(139, 0, 0));
		therapistTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		therapistTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
		therapistTitleLabel.setBounds(0, 20, 440, 30);
		therapistContentPanel.add(therapistTitleLabel);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(new Color(255, 255, 255));
		infoPanel.setBounds(0, 74, 450, 130);
		therapistContentPanel.add(infoPanel);
		infoPanel.setLayout(null);
		
		JLabel infoLabel_1 = new JLabel("Working Place:");
		infoLabel_1.setForeground(new Color(0, 139, 139));
		infoLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		infoLabel_1.setBounds(10, 10, 125, 30);
		infoPanel.add(infoLabel_1);
		
		JLabel workingPlaceLabel = new JLabel(therapist.getWorkingPlace());
		workingPlaceLabel.setForeground(new Color(160, 82, 45));
		workingPlaceLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		workingPlaceLabel.setBounds(180, 10, 270, 30);
		infoPanel.add(workingPlaceLabel);
		
		JLabel infoLabel_2 = new JLabel("Experiences (years):");
		infoLabel_2.setForeground(new Color(0, 139, 139));
		infoLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		infoLabel_2.setBounds(10, 50, 165, 30);
		infoPanel.add(infoLabel_2);
		
		JLabel experiencesLabel = new JLabel(therapist.getExperiences() + " years");
		experiencesLabel.setForeground(new Color(160, 82, 45));
		experiencesLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		experiencesLabel.setBounds(180, 50, 134, 30);
		infoPanel.add(experiencesLabel);
		
		JLabel infoLabel_3 = new JLabel("Email:");
		infoLabel_3.setForeground(new Color(0, 139, 139));
		infoLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		infoLabel_3.setBounds(10, 90, 165, 30);
		infoPanel.add(infoLabel_3);
		
		JLabel emailLabel = new JLabel(therapist.getEmail());
		emailLabel.setForeground(new Color(160, 82, 45));
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailLabel.setBounds(180, 90, 134, 30);
		infoPanel.add(emailLabel);
		
		JLabel infoLabel_4 = new JLabel("Certificates");
		infoLabel_4.setBounds(10, 210, 125, 30);
		therapistContentPanel.add(infoLabel_4);
		infoLabel_4.setForeground(new Color(0, 139, 139));
		infoLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JPanel certificatePanel = new JPanelCustom(420, 300);
		certificatePanel.setLayout(null);
		certificatePanel.setBackground(Color.WHITE);
		certificatePanel.setLocation(10, 245);
		
		JScrollPane certificateScrollPane = new JScrollPane(certificatePanel);
		certificateScrollPane.setBounds(10, 245, 420, 135);
		certificateScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		certificateScrollPane.setBorder(null);
		therapistContentPanel.add(certificateScrollPane);
		
		JLabel infoLabel_5 = new JLabel("This therapist's latest post:");
		infoLabel_5.setForeground(new Color(0, 139, 139));
		infoLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		infoLabel_5.setBounds(10, 405, 238, 30);
		therapistContentPanel.add(infoLabel_5);
		
		JPanel latestPostPanel = new JPanelCustom(420, 300);
		latestPostPanel.setBackground(Color.WHITE);
		latestPostPanel.setLocation(10, 445);
		latestPostPanel.setLayout(null);
		
		JScrollPane latestPostScroll = new JScrollPane(latestPostPanel);
		latestPostScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		latestPostScroll.setBounds(10, 445, 420, 150);
		latestPostScroll.setBorder(null);
		therapistContentPanel.add(latestPostScroll);
		

		int position = 5;
		for (int i = 0; i < therapist.getCertificates().size(); i++) {
			certificatePanel.add(createCertificate("-    " + therapist.getCertificates().get(i).getName(), position));
			position += 30;
		}

		List<Problem> problems = ProblemService.readByUser(therapist.getID());

		position = 5;
		for(int i = 0; i < problems.size(); i++)
		{
			latestPostPanel.add(createLatestPost(problems.get(i), mainForm, position));
			position += 50;
		}
		
	}
}
