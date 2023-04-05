package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import structs.CV;

public class Referees extends Information {

	private String[] referees = new String[10];
	private JFrame frame;
	private CV cv;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, CV curriculumVitae) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Referees window = new Referees(curriculumVitae);
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
	public Referees(CV curriculumVitae) {
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
        panel.setBounds(385, 21, 391, 437);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 11, 371, 415);
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
        hobbyTab.setViewportView(hobbyText);
        
        JScrollPane positionTab = new JScrollPane();
        tabbedPane.addTab("Positions", null, positionTab, null);
        
        JTextArea positionText = new JTextArea();
        positionTab.setViewportView(positionText);
        
        JScrollPane refereeTab = new JScrollPane();
        tabbedPane.addTab("Referees", null, refereeTab, null);
        
        JTextArea refereeText = new JTextArea();
        refereeTab.setViewportView(refereeText);
        
        getCV(cv, detailsText, strengthsText, degreeText, expText, itText, langsText, hobbyText, positionText, refereeText);
        
        JLabel lblNewLabel = new JLabel("Referees");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.referees = referees;
        		PersonalDetails.main(null, cv);
        		frame.dispose();
        	}
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnBack.setBounds(127, 504, 112, 23);
        frame.getContentPane().add(btnBack);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(10, 71, 365, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JTextField refereeField = new JTextField();
        refereeField.setBounds(165, 140, 190, 20);
        panel_1.add(refereeField);
        refereeField.setColumns(10);
        
        JButton btnAdd = new JButton("Add");
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAdd.setBackground(new Color(128, 128, 128));
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String strength = refereeField.getText();
        		strengthsText.append(strength + "\n");
        		for (int i = 0; i < referees.length; i++) {
        			if (referees[i] == "" || referees[i] == null) {
        				referees[i] = strength;
        				break;
        			}
        		}
        		cv.referees = referees;
                getCV(cv, detailsText, strengthsText, degreeText, expText, itText, langsText, hobbyText, positionText, refereeText);
        	}
        });
        btnAdd.setBounds(10, 178, 174, 20);
        panel_1.add(btnAdd);
        
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.referees = referees;
        		Degrees.main(null, cv);
        		frame.dispose();
        	}
        });
        btnNext.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNext.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnNext);
        
        
        JLabel lblNewLabel_1 = new JLabel("Your referees:");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(10, 127, 145, 40);
        panel_1.add(lblNewLabel_1);
        
        JButton btnRemove = new JButton("Remove last entry");
        btnRemove.setForeground(new Color(255, 255, 255));
        btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnRemove.setBackground(new Color(128, 128, 128));
        btnRemove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
           		for (int i = 0; i < 10; i++) {
           			if (referees[i] == null || i == 10) {
           				referees[i] = "";
           				break;
            		}
            	}
        		cv.referees = referees;
                getCV(cv, detailsText, strengthsText, degreeText, expText, itText, langsText, hobbyText, positionText, refereeText);
        	}
        });
        btnRemove.setBounds(194, 178, 161, 20);
        panel_1.add(btnRemove);
	}

}
