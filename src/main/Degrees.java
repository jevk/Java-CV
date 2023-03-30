package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import structs.CV;
import structs.Degree;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Degrees extends Information {
	private CV cv;
	private Degree[] degrees = new Degree[10];
	private JFrame frame;
	private JTextField txtSchool;
	private JTextField txtEducation;
	private JTextField txtDegree;
	private JTextField txtStartYear;
	private JTextField txtEndYear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, CV curriculumVitae) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Degrees window = new Degrees(curriculumVitae);
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
	public Degrees(CV curriculumVitae) {
		cv = curriculumVitae;
		initialize();
	}

	 /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
    	degrees = cv.degrees;
    	
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(39, 39, 39));
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(49, 49, 49));
        panel.setBounds(408, 21, 354, 437);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 11, 334, 415);
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
        
        JLabel lblNewLabel = new JLabel("Degrees");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.degrees = degrees;
        		Courses.main(null, cv);
        		frame.dispose();
        	}
        });
        btnNext.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNext.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnNext);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.degrees = degrees;
        		Strengths.main(null, cv);
        		frame.dispose();
        	}
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnBack.setBounds(127, 504, 112, 23);
        frame.getContentPane().add(btnBack);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(28, 71, 354, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("School");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(10, 58, 112, 21);
        panel_1.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Education");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setBounds(10, 106, 112, 21);
        panel_1.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Degree");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2.setBounds(10, 153, 112, 21);
        panel_1.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("Start Year");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_3.setForeground(Color.WHITE);
        lblNewLabel_1_3.setBounds(10, 202, 112, 21);
        panel_1.add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_1_4 = new JLabel("End Year");
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_4.setForeground(Color.WHITE);
        lblNewLabel_1_4.setBounds(10, 253, 112, 21);
        panel_1.add(lblNewLabel_1_4);
        
        txtSchool = new JTextField();
        txtSchool.setBounds(132, 61, 183, 20);
        panel_1.add(txtSchool);
        txtSchool.setColumns(10);
        
        txtEducation = new JTextField();
        txtEducation.setColumns(10);
        txtEducation.setBounds(132, 109, 183, 20);
        panel_1.add(txtEducation);
        
        txtDegree = new JTextField();
        txtDegree.setColumns(10);
        txtDegree.setBounds(132, 156, 183, 20);
        panel_1.add(txtDegree);
        
        txtStartYear = new JTextField();
        txtStartYear.setColumns(10);
        txtStartYear.setBounds(132, 205, 183, 20);
        panel_1.add(txtStartYear);
        
        txtEndYear = new JTextField();
        txtEndYear.setColumns(10);
        txtEndYear.setBounds(132, 256, 183, 20);
        panel_1.add(txtEndYear);
        
		// degrees[i - 1] = null;
        
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		for(int i = 0; i < degrees.length; i++) {
        			if (degrees[i] == null) {
        				Degree deg = new Degree();
        				deg.school = txtSchool.getText();
        				deg.education = txtEducation.getText();
        				deg.degree = txtDegree.getText();
        				deg.startYear = Integer.parseInt(txtStartYear.getText());
        				deg.endYear = Integer.parseInt(txtEndYear.getText());
        				degrees[i] = deg;
        				break;
        			}
        		}
				cv.degrees = degrees;
                getCV(cv, detailsText, strengthsText, degreeText, expText, itText, langsText, hobbyText, positionText, refereeText);
        	}
        });
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnAdd.setBounds(142, 287, 163, 40);
        panel_1.add(btnAdd);
        
        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		for(int i = 0; i < degrees.length; i++) {
        			if (degrees[i] == null) {
        				try {
							degrees[i - 1] = null;
						} catch (Exception e1) {
							System.out.println("vitun retu xD");
						}
        			}
        		}
				cv.degrees = degrees;
                getCV(cv, detailsText, strengthsText, degreeText, expText, itText, langsText, hobbyText, positionText, refereeText);
        	}
        });
        btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnRemove.setBounds(142, 336, 163, 40);
        panel_1.add(btnRemove);
    }
}
