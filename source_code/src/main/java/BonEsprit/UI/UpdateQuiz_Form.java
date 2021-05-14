package BonEsprit.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UpdateQuiz_Form extends JFrame {
	private JPanel contentPane;
	private JTextField titleTxtField;


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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 800);
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

		
	}

}
