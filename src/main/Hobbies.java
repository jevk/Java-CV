package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import structs.CV;
import structs.Details;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;

public class Hobbies {
	private CV cv;
	JFrame frame;
	private JTextField txtNimi;
	private Details details = new Details();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, CV curriculumVitae) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hobbies window = new Hobbies(curriculumVitae);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Hobbies(CV curriculumVitae) {
		cv = curriculumVitae;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(39, 39, 39));
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(49, 49, 49));
        panel.setBounds(408, 71, 354, 387);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 11, 334, 365);
        panel.add(textArea);
        
        JLabel lblNewLabel = new JLabel("Hobbies");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnReturn = new JButton("Return");
        btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnReturn.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnReturn);
        
        JButton btnFinish = new JButton("Finish");
        btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnFinish.setBounds(127, 504, 112, 23);
        frame.getContentPane().add(btnFinish);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(28, 71, 354, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Hobby");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
        lblNewLabel_1.setBounds(142, 48, 71, 29);
        panel_1.add(lblNewLabel_1);
        
        txtNimi = new JTextField();
        txtNimi.setBounds(10, 100, 334, 35);
        panel_1.add(txtNimi);
        txtNimi.setColumns(10);
        
        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textArea.append("Your hobbies are: "
        				+"\r\n"
        				+ "Nimi: "
        				+ txtNimi.getText()
        				
        				
        				);       		
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(85, 308, 171, 23);
        panel_1.add(btnNewButton);
        
    }
}
