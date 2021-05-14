package BonEsprit.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UpdateQuiz_Form extends JFrame {
	private JPanel contentPane;
	private JTextField titleTxtField;
	
	private JButton addQuestion;
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
					UpdateQuiz_Form frame = new UpdateQuiz_Form();
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
	
	
	public UpdateQuiz_Form() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xFFFFFF));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Title:");
		titleLabel.setBounds(29, 10, 69, 47);
		titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		contentPane.add(titleLabel);
		
		titleTxtField = new JTextField();
		titleTxtField.setBounds(88, 20, 308, 25);
		titleTxtField.setFont(new Font("SansSerif", Font.PLAIN, 18));
		contentPane.add(titleTxtField);
		titleTxtField.setColumns(10);

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
        
        JPanel questionPanel = new JPanelCustom(425, 1000);
        questionPanel.setLocation(5, 80);
        questionPanel.setLayout(null);
        

        JScrollPane questionScroll = new JScrollPane(questionPanel);
        questionScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        questionScroll.setBorder(null);
        questionScroll.setBounds(5, 80, 425, 500);
        contentPane.add(questionScroll);
        
        addQuestion = new JButton("Add Question");
        addQuestion.setFont(new Font("Tahoma", Font.BOLD, 15));
        addQuestion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addQuestion.setBackground(new Color(0x85DEB9));
        addQuestion.setBounds(270, 640, 150, 30);
        contentPane.add(addQuestion);

	}
}
