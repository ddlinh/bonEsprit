package BonEsprit.UI.form;

import BonEsprit.Model.Problem;
import BonEsprit.Model.Symptom;
import BonEsprit.Model.Treatment;
import BonEsprit.Model.User;
import BonEsprit.Service.DATA;
import BonEsprit.Service.ProblemService;
import BonEsprit.UI.panel.JPanelCustom;
import BonEsprit.UI.panel.Search_Panel;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Dialog.ModalExclusionType;

import javax.imageio.ImageIO;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class ItemPanel {
	public JPanel panel;
	public JTextArea textArea;
	public JButton removeButton;
	
	public ItemPanel(String text) {
		this.panel = new JPanel();
		this.panel.setSize(330, 40);
		this.panel.setLayout(null);
		
		this.textArea = new JTextArea(text);
		this.textArea.setBounds(5, 5, 280, 30);
		this.panel.add(this.textArea);
		
		this.removeButton = new JButton();
		try {
		    Image img = ImageIO.read(new File("./resources/delete-icon.png"));
		    Image newimg = img.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH ) ;
		    removeButton.setIcon(new ImageIcon(newimg));
		    
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		
		this.removeButton.setBounds(300, 0, 30, 30);
		this.removeButton.setBackground(new Color(0x8D3E3E));
		this.removeButton.setForeground(new Color(0xFFFFFF));
		this.removeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});

		this.panel.add(this.removeButton);
	}
}

public class UpdateProblem_Form extends JFrame {
	private JPanel contentPane;
	private JTextField titleTxtField;
	private JTextArea descriptionTextArea;
	
	private JLabel symptomsLabel;
	private JPanel symptomPanel;
	private List<ItemPanel> symptomList;
	private JButton addSymptomButton;
	
	private JLabel treatmentsLabel;
	private JPanel treatmentPanel;
	private List<ItemPanel> treatmentList;
	private JButton addTreatmentButton;
	private JButton submitButton;
	private JButton clearButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	
	public void createItemPanel(int position, ItemPanel item) {
		int y = position * 40 + 10;
		item.panel.setLocation(10, y);
		item.panel.setBackground(new Color(0xD3DEF2));
	}
	
	public UpdateProblem_Form(Problem problem, User author) {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 750);
		contentPane = new JPanelCustom(450,800);
		contentPane.setBackground(new Color(0xFFFFFF));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLocation(0,0);
		
		contentPane.setLayout(null);

		JScrollPane contentScroll = new JScrollPane(contentPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		contentScroll.setBounds(0, 0, 450, 750);
		contentScroll.setBorder(null);
		setContentPane(contentScroll);

		JLabel titleLabel = new JLabel("Title:");
		titleLabel.setBounds(29, 10, 69, 47);
		titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		contentPane.add(titleLabel);
		
		titleTxtField = new JTextField(problem.getName());
		titleTxtField.setBounds(88, 20, 308, 25);
		titleTxtField.setFont(new Font("SansSerif", Font.PLAIN, 18));
		contentPane.add(titleTxtField);
		titleTxtField.setColumns(10);
		
		JLabel descriptionLabel = new JLabel("Description:");
		descriptionLabel.setBounds(50, 46, 150, 47);
		descriptionLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		contentPane.add(descriptionLabel);
		

		descriptionTextArea = new JTextArea(problem.getDescription());
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setWrapStyleWord(true);
		descriptionTextArea.setFont(new Font("SansSerif", Font.PLAIN, 17));
		descriptionTextArea.setBounds(20, 90, 400, 100);
		
		JScrollPane scrollDescriptionArea = new JScrollPane (descriptionTextArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollDescriptionArea.setBounds(20, 90, 400, 100);
		contentPane.add(scrollDescriptionArea);
		
		
		//Symptoms

		this.symptomList = new ArrayList<ItemPanel>();

		symptomsLabel = new JLabel("Symptoms:");
		symptomsLabel.setBounds(49, 187, 100, 47);
		symptomsLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		contentPane.add(symptomsLabel);
		
		symptomPanel = new JPanelCustom(380, 1000);
		symptomPanel.setBackground(new Color(0xD3DEF2));
		symptomPanel.setLocation(30, 230);
		symptomPanel.setLayout(null);
		
		JScrollPane scrollSymptomsPane = new JScrollPane(symptomPanel);
		scrollSymptomsPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollSymptomsPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollSymptomsPane.setBounds(20, 230, 380, 155);
		scrollSymptomsPane.getVerticalScrollBar().setUnitIncrement(10);
        contentPane.add(scrollSymptomsPane);
        
        addSymptomButton = new JButton("+");
        addSymptomButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        addSymptomButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addSymptomButton.setBackground(new Color(0x85DEB9));
        addSymptomButton.setBounds(348, 395, 48, 40);
        contentPane.add(addSymptomButton);

        List<Symptom> symptoms = problem.getSymptoms();
        for(int i = 0; i < symptoms.size(); i++) {
        	ItemPanel newItemSymptom = new ItemPanel(symptoms.get(i).getContent());
        	createItemPanel(i, newItemSymptom);
        	symptomPanel.add(newItemSymptom.panel);
			symptomList.add(newItemSymptom);
		}

        addSymptomButton.addActionListener(new ActionListener() {
			int position = symptoms.size();
			@Override
			public void actionPerformed(ActionEvent e) {
				ItemPanel newItemSymptom = new ItemPanel("");
				createItemPanel(position, newItemSymptom);
				symptomPanel.add(newItemSymptom.panel);
				symptomList.add(newItemSymptom);
				position += 1;
			}
		});
        
        //Treatments
        treatmentsLabel = new JLabel("Treatments:");
        treatmentsLabel.setBounds(51, 427, 100, 47);
        treatmentsLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		contentPane.add(treatmentsLabel);
		
		treatmentPanel = new JPanelCustom(380, 1000);
		treatmentPanel.setBackground(new Color(0xD3DEF2));
		treatmentPanel.setLocation(20, 470);
		treatmentPanel.setLayout(null);
		
		JScrollPane scrollTreatmentsPane = new JScrollPane(treatmentPanel);
		scrollTreatmentsPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollTreatmentsPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollTreatmentsPane.setBounds(20, 470, 380, 155);
        contentPane.add(scrollTreatmentsPane);
        
        addTreatmentButton = new JButton("+");
        addTreatmentButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        addTreatmentButton.setBackground(new Color(0x85DEB9));
        addTreatmentButton.setBounds(348, 635, 48, 40);
        contentPane.add(addTreatmentButton);

		List<Treatment> treatments = problem.getTreatments();
		this.treatmentList = new ArrayList<ItemPanel>();
		for(int i = 0; i < treatments.size(); i++) {
			ItemPanel newItemTreatment = new ItemPanel(treatments.get(i).getContent());
			createItemPanel(i, newItemTreatment);
			treatmentPanel.add(newItemTreatment.panel);
			treatmentList.add(newItemTreatment);
		}


		addTreatmentButton.addActionListener(new ActionListener() {
			int position = treatments.size();
        	@Override
			public void actionPerformed(ActionEvent e) {
				ItemPanel newItemTreatment = new ItemPanel("");
				createItemPanel(position, newItemTreatment);
				position ++;
				treatmentPanel.add(newItemTreatment.panel);
				treatmentList.add(newItemTreatment);
			}
		});
        
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        submitButton.setBackground(new Color(0x7FF399));
        submitButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		problem.setName(titleTxtField.getText());
        		problem.setDescription(descriptionTextArea.getText());
        		problem.setDate(Calendar.getInstance().getTimeInMillis());
        		problem.setAuthor(author);

        		problem.setSymptoms(new ArrayList<Symptom>());
				for(int i = 0; i < symptomList.size(); i++)
				{
					String symptom = symptomList.get(i).textArea.getText();
					if (!symptom.equals("")) {
						Symptom newSymptom = new Symptom();
						newSymptom.setID((long) i);
						newSymptom.setContent(symptom);
						problem.getSymptoms().add(newSymptom);
					}
				}

				problem.setTreatments(new ArrayList<Treatment>());
				for(int i = 0; i < treatmentList.size(); i++)
				{
					String treatment = treatmentList.get(i).textArea.getText();
					if (!treatment.equals("")) {
						Treatment newTreatment = new Treatment();
						newTreatment.setID((long) i);
						newTreatment.setContent(treatment);
						problem.getTreatments().add(newTreatment);
					}
				}

				if(ProblemService.updatePost(problem))
				{
					JOptionPane.showMessageDialog(contentPane, "Update Successfully");
					Component component = (Component) e.getSource();
					UpdateProblem_Form frame = (UpdateProblem_Form) SwingUtilities.getRoot(component);
					frame.setVisible(false);

				}

        	}
        });
        submitButton.setBounds(83, 692, 100, 40);

		contentPane.add(submitButton);


        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancelButton.setBounds(266, 692, 100, 40);
        cancelButton.setBackground(new Color(0x8D3E3E));
        cancelButton.setForeground(new Color(0xFFFFFF));

        cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Component component = (Component) e.getSource();
				UpdateProblem_Form frame = (UpdateProblem_Form) SwingUtilities.getRoot(component);
				frame.setVisible(false);

			}
		});

        contentPane.add(cancelButton);
	}
}
