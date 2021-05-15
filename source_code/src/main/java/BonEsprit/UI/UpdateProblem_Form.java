package BonEsprit.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.util.List;
import java.awt.SystemColor;

class ItemPanel {
	public JPanel panel;
	public JTextArea textArea;
	public JButton removeButton;
	
	public ItemPanel() {
		this.panel = new JPanel();
		this.panel.setSize(330, 40);
		this.panel.setLayout(null);
		
		this.textArea = new JTextArea();
		this.textArea.setBounds(5, 5, 280, 20);
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProblem_Form frame = new UpdateProblem_Form();
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
	
	public void createItemPanel(int position, ItemPanel item) {
		int y = position * 40 + 10;
		item.panel.setLocation(10, y);
		item.panel.setBackground(new Color(0xD3DEF2));
	}
	
	public UpdateProblem_Form() {
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
		
		titleTxtField = new JTextField();
		titleTxtField.setBounds(88, 20, 308, 25);
		titleTxtField.setFont(new Font("SansSerif", Font.PLAIN, 18));
		contentPane.add(titleTxtField);
		titleTxtField.setColumns(10);
		
		JLabel descriptionLabel = new JLabel("Description:");
		descriptionLabel.setBounds(50, 46, 150, 47);
		descriptionLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		contentPane.add(descriptionLabel);
		

		descriptionTextArea = new JTextArea();
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setWrapStyleWord(true);
		descriptionTextArea.setFont(new Font("SansSerif", Font.PLAIN, 17));
		descriptionTextArea.setBounds(20, 90, 400, 100);
		
		JScrollPane scrollDescriptionArea = new JScrollPane (descriptionTextArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollDescriptionArea.setBounds(20, 90, 400, 100);
		contentPane.add(scrollDescriptionArea);
		
		
		//Symptoms
		symptomsLabel = new JLabel("Symptoms:");
		symptomsLabel.setBounds(49, 187, 100, 47);
		symptomsLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		contentPane.add(symptomsLabel);
		
		symptomPanel = new JPanel();
		symptomPanel.setBackground(new Color(0xD3DEF2));
		symptomPanel.setBounds(49, 230, 347, 155);
		symptomPanel.setLayout(null);
		
		JScrollPane scrollSymptomsPane = new JScrollPane(symptomPanel);
		scrollSymptomsPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollSymptomsPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollSymptomsPane.setBounds(50, 230, 347, 155);
        
		ItemPanel newItemSymptom = new ItemPanel();
		createItemPanel(0, newItemSymptom);
		
        symptomPanel.add(newItemSymptom.panel);
        
        
        contentPane.add(scrollSymptomsPane);
        
        addSymptomButton = new JButton("+");
        addSymptomButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        addSymptomButton.setBackground(new Color(0x85DEB9));
        addSymptomButton.setBounds(348, 395, 48, 40);
        contentPane.add(addSymptomButton);
        
        //Treatments
        treatmentsLabel = new JLabel("Treatments:");
        treatmentsLabel.setBounds(51, 427, 100, 47);
        treatmentsLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		contentPane.add(treatmentsLabel);
		
		treatmentPanel = new JPanel();
		treatmentPanel.setBackground(new Color(0xD3DEF2));
		treatmentPanel.setBounds(49, 470, 347, 155);
		treatmentPanel.setLayout(null);
		
		JScrollPane scrollTreatmentsPane = new JScrollPane(treatmentPanel);
		scrollTreatmentsPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollTreatmentsPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollTreatmentsPane.setBounds(50, 470, 347, 155);
        
		ItemPanel newItemTreatment = new ItemPanel();
		createItemPanel(0, newItemTreatment);
		
		treatmentPanel.add(newItemTreatment.panel);
        
        
        contentPane.add(scrollTreatmentsPane);
        
        addTreatmentButton = new JButton("+");
        addTreatmentButton.setFont(new Font("Tahoma", Font.BOLD, 17));
        addTreatmentButton.setBackground(new Color(0x85DEB9));
        addTreatmentButton.setBounds(348, 635, 48, 40);
        contentPane.add(addTreatmentButton);
        
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        submitButton.setBackground(new Color(0x7FF399));
        submitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        submitButton.setBounds(83, 692, 100, 40);
        contentPane.add(submitButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancelButton.setBounds(266, 692, 100, 40);
        cancelButton.setBackground(new Color(0x8D3E3E));
        cancelButton.setForeground(new Color(0xFFFFFF));
        contentPane.add(cancelButton);

        contentPane.add(cancelButton);
	}

}
