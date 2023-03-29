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

public class Henkilotieto {
	private CV cv;
	JFrame frame;
	private JTextField txtNimi;
	private JTextField txtKotiosoite;
	private JTextField txtSahkoposti;
	private JTextField txtPuhnumero;
	private Details details = new Details();
	private JTextField txtKaupunki;
	private JTextField txtPostinumero;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, CV curriculumVitae) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Henkilotieto window = new Henkilotieto(curriculumVitae);
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
	public Henkilotieto(CV curriculumVitae) {
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
        panel.setBounds(408, 11, 354, 447);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 60, 334, 376);
        panel.add(textArea);
        
        JLabel lblNewLabel = new JLabel("Henkilötiedot");
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
        
        JLabel lblNewLabel_1 = new JLabel("Nimi");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(10, 31, 49, 14);
        panel_1.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Kotiosoite");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBackground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(10, 62, 83, 14);
        panel_1.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Sähköpostiosoite");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_3.setBounds(10, 95, 131, 14);
        panel_1.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Puhelinnumero");
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4.setBounds(10, 126, 105, 14);
        panel_1.add(lblNewLabel_4);
        
        txtNimi = new JTextField();
        txtNimi.setBounds(146, 30, 198, 20);
        panel_1.add(txtNimi);
        txtNimi.setColumns(10);
        
        txtKotiosoite = new JTextField();
        txtKotiosoite.setBounds(146, 61, 198, 20);
        panel_1.add(txtKotiosoite);
        txtKotiosoite.setColumns(10);
        
        txtSahkoposti = new JTextField();
        txtSahkoposti.setBounds(146, 94, 198, 20);
        panel_1.add(txtSahkoposti);
        txtSahkoposti.setColumns(10);
        
        txtPuhnumero = new JTextField();
        txtPuhnumero.setBounds(146, 125, 198, 20);
        panel_1.add(txtPuhnumero);
        txtPuhnumero.setColumns(10);
        
        JButton btnNewButton = new JButton("Lähetä henkilötiedot");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textArea.append("Henkilötiedot: "
        				+"\r\n"
        				+ "Nimi: "
        				+ txtNimi.getText()
        				+"\r\n"
        				+"Kotiosoite: "
        				+ txtKotiosoite.getText() 
        				+"\r\n"
        				+"Sähköpostiosoite: "
        				+ txtSahkoposti.getText()
        				+"\r\n"
        				+ "Puhelinnumero: "
        				+ txtPuhnumero.getText()
        				+"\r\n"
        				+ "Kaupunki: "
        				+ txtKaupunki.getText()
        				+"\r\n"
        				+"Postinumero: "
        				+ txtPostinumero.getText()
        				
        				
        				);
        		details.setAddress(txtKotiosoite.getText());
        		details.setEmail(txtSahkoposti.getText());
        		details.setName(txtNimi.getText());
        		details.setPhone(txtPuhnumero.getText());
        		details.setTown(txtKaupunki.getText());
        		details.setZip(txtPostinumero.getText());
        		
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(85, 308, 171, 23);
        panel_1.add(btnNewButton);
        
        txtKaupunki = new JTextField();
        txtKaupunki.setBounds(146, 156, 198, 20);
        panel_1.add(txtKaupunki);
        txtKaupunki.setColumns(10);
        
        txtPostinumero = new JTextField();
        txtPostinumero.setBounds(146, 187, 198, 20);
        panel_1.add(txtPostinumero);
        txtPostinumero.setColumns(10);
        
        JLabel lblNewLabel_5 = new JLabel("Kaupunki");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setForeground(new Color(255, 255, 255));
        lblNewLabel_5.setBounds(10, 156, 83, 17);
        panel_1.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Postinumero");
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setBackground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_6.setBounds(10, 188, 105, 14);
        panel_1.add(lblNewLabel_6);
    }
}
