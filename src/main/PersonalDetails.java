package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import structs.CV;
import structs.Details;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonalDetails extends Information {
	private CV cv;
	private JFrame frame;
	private JTextField txtNimi;
	private JTextField txtKotiosoite;
	private JTextField txtSahkoposti;
	private JTextField txtPuhnumero;
	private Details details = new Details();
	private JTextField txtKaupunki;
	private JTextField txtPostinumero;
	private JTextField textOther;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, CV curriculumVitae) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalDetails window = new PersonalDetails(curriculumVitae);
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
	public PersonalDetails(CV curriculumVitae) {
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
        panel.setBounds(378, 21, 398, 437);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Personal Details");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Ebrima", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnNext = new JButton("Next");
        btnNext.setForeground(new Color(255, 255, 255));
        btnNext.setBackground(new Color(128, 128, 128));
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Strengths.main(null, cv);
        		frame.dispose();
        	}
        });
        btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNext.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnNext);
        
        JButton btnFinish = new JButton("Back");
        btnFinish.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.details = details;
        		Referees.main(null, cv);
        		frame.dispose();
        	}
        });
        btnFinish.setForeground(new Color(255, 255, 255));
        btnFinish.setBackground(new Color(128, 128, 128));
        btnFinish.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnFinish.setBounds(127, 504, 112, 23);
        frame.getContentPane().add(btnFinish);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(10, 71, 358, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setForeground(new Color(255, 255, 255));
        tabbedPane.setBackground(new Color(128, 128, 128));
        tabbedPane.setBounds(10, 11, 378, 415);
        panel.add(tabbedPane);
        
        JScrollPane detailsTab = new JScrollPane();
        tabbedPane.addTab("Details", null, detailsTab, null);
        
        JTextArea detailsText = new JTextArea();
        detailsText.setEditable(false);
        detailsTab.setViewportView(detailsText);
        
        JScrollPane strengthsTab = new JScrollPane();
        tabbedPane.addTab("Strengths", null, strengthsTab, null);
        
        JTextArea strengthsText = new JTextArea();
        strengthsText.setEditable(false);
        strengthsTab.setViewportView(strengthsText);
        
        JScrollPane degreeTab = new JScrollPane();
        tabbedPane.addTab("Degrees", null, degreeTab, null);
        
        JTextArea degreeText = new JTextArea();
        degreeText.setEditable(false);
        degreeTab.setViewportView(degreeText);
        
        JScrollPane courseTab = new JScrollPane();
        tabbedPane.addTab("Courses", null, courseTab, null);
        
        JTextArea courseText = new JTextArea();
        courseText.setEditable(false);
        courseTab.setViewportView(courseText);
        
        JScrollPane expTab = new JScrollPane();
        tabbedPane.addTab("Experience", null, expTab, null);
        
        JTextArea expText = new JTextArea();
        expText.setEditable(false);
        expTab.setViewportView(expText);
        
        JScrollPane itTab = new JScrollPane();
        tabbedPane.addTab("IT Skills", null, itTab, null);
        
        JTextArea itText = new JTextArea();
        itText.setEditable(false);
        itTab.setViewportView(itText);
        itText.setText("IT Skills:\n");
        
        JScrollPane langTab = new JScrollPane();
        tabbedPane.addTab("Languages", null, langTab, null);
        
        JTextArea langsText = new JTextArea();
        langsText.setEditable(false);
        langTab.setViewportView(langsText);
        
        JScrollPane hobbyTab = new JScrollPane();
        tabbedPane.addTab("Hobbies", null, hobbyTab, null);
        
        JTextArea hobbyText = new JTextArea();
        hobbyText.setEditable(false);
        hobbyTab.setViewportView(hobbyText);
        
        JScrollPane positionTab = new JScrollPane();
        tabbedPane.addTab("Positions", null, positionTab, null);
        
        JTextArea positionText = new JTextArea();
        positionText.setEditable(false);
        positionTab.setViewportView(positionText);
        
        JScrollPane refereeTab = new JScrollPane();
        tabbedPane.addTab("Referees", null, refereeTab, null);
        
        JTextArea refereeText = new JTextArea();
        refereeText.setEditable(false);
        refereeTab.setViewportView(refereeText);
        
        getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        
        JLabel lblNewLabel_1 = new JLabel("Name:");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(10, 31, 49, 14);
        panel_1.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Address:");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBackground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(10, 62, 83, 14);
        panel_1.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Email:");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_3.setBounds(10, 95, 131, 14);
        panel_1.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Phone:");
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4.setBounds(10, 126, 105, 14);
        panel_1.add(lblNewLabel_4);
        
        txtNimi = new JTextField();
        txtNimi.setBounds(146, 30, 202, 20);
        panel_1.add(txtNimi);
        txtNimi.setColumns(10);
        
        txtKotiosoite = new JTextField();
        txtKotiosoite.setBounds(146, 61, 202, 20);
        panel_1.add(txtKotiosoite);
        txtKotiosoite.setColumns(10);
        
        txtSahkoposti = new JTextField();
        txtSahkoposti.setBounds(146, 94, 202, 20);
        panel_1.add(txtSahkoposti);
        txtSahkoposti.setColumns(10);
        
        txtPuhnumero = new JTextField();
        txtPuhnumero.setBounds(146, 125, 202, 20);
        panel_1.add(txtPuhnumero);
        txtPuhnumero.setColumns(10);
        
        txtKaupunki = new JTextField();
        txtKaupunki.setBounds(146, 156, 202, 20);
        panel_1.add(txtKaupunki);
        txtKaupunki.setColumns(10);
        
        txtPostinumero = new JTextField();
        txtPostinumero.setBounds(146, 187, 202, 20);
        panel_1.add(txtPostinumero);
        txtPostinumero.setColumns(10);
        
        textOther = new JTextField();
        textOther.setColumns(10);
        textOther.setBounds(146, 218, 202, 20);
        panel_1.add(textOther);
        
        JButton btnNewButton = new JButton("Set Information");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(128, 128, 128));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		details.address = txtKotiosoite.getText();
        		details.email = txtSahkoposti.getText();
        		details.name = txtNimi.getText();
        		details.phone = txtPuhnumero.getText();
        		details.town = txtKaupunki.getText();
        		details.zip = txtPostinumero.getText();
        		
        		if (textOther.getText().length() > 0) {
        			details.other = textOther.getText();
        		}
        		
        		cv.details = details;
        		getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNewButton.setBounds(96, 264, 171, 20);
        panel_1.add(btnNewButton);
        
        JLabel lblNewLabel_5 = new JLabel("Town:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setForeground(new Color(255, 255, 255));
        lblNewLabel_5.setBounds(10, 156, 83, 17);
        panel_1.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("Zip:");
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setBackground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_6.setBounds(10, 186, 105, 19);
        panel_1.add(lblNewLabel_6);
        
        JLabel lblNewLabel_6_1 = new JLabel("Other:");
        lblNewLabel_6_1.setForeground(Color.WHITE);
        lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_6_1.setBackground(Color.WHITE);
        lblNewLabel_6_1.setBounds(10, 219, 105, 19);
        panel_1.add(lblNewLabel_6_1);
        
        JButton btnSave = new JButton("Create Save");
        btnSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.BuildCV(cv);
        	}
        });
        btnSave.setForeground(new Color(255, 255, 255));
        btnSave.setBackground(new Color(128, 128, 128));
        btnSave.setBounds(329, 505, 112, 23);
        frame.getContentPane().add(btnSave);
    }
}
