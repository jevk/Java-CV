package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
import structs.Experience;
import javax.swing.JScrollBar;

import jdk.internal.org.jline.utils.DiffHelper.Diff;

public class WorkExperience extends Information {
	private CV cv;
	private Experience[] experience;
	private JFrame frame;
	private JTextField textWorkplace;
	private JTextField textJob;
	private JTextField textLength;
<<<<<<< HEAD
	private JTextField textJobTitle;
=======
	private JTextField textMonth;
	private JTextField textYear;
	private JTextField textWorktask;
>>>>>>> de7e6ed64ad1f4c5f0028f7557db9efe3af5a37d

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, CV curriculumVitae) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkExperience window = new WorkExperience(curriculumVitae);
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
	public WorkExperience(CV curriculumVitae) {
		cv = curriculumVitae;
		experience = cv.experience;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setLocation(-25, -71);
        frame.getContentPane().setBackground(new Color(39, 39, 39));
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 931, 705);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(49, 49, 49));
        panel.setBounds(370, 21, 402, 437);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setForeground(new Color(255, 255, 255));
        tabbedPane.setBackground(new Color(128, 128, 128));
        tabbedPane.setBounds(10, 11, 382, 415);
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
        
        getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        
        JLabel lblNewLabel = new JLabel("Work Experience");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        
        JButton btnBack = new JButton("Back");
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(128, 128, 128));
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.experience = experience;
        		Courses.main(null, cv);
        		frame.dispose();
        	}
        });
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBack.setBounds(127, 504, 112, 23);
        frame.getContentPane().add(btnBack);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(10, 71, 340, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JButton btnAdd = new JButton("Add");
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAdd.setBackground(new Color(128, 128, 128));
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String workplace = textWorkplace.getText();
        		String job = textJob.getText();
        		String jobtitle = textJobTitle.getText();
        		String length = textLength.getText();
<<<<<<< HEAD
<<<<<<< HEAD
        		LocalDate start_date = LocalDate.of(0, 0, 0);
        		LocalDate end_date = LocalDate.of(0, 0, 0);
        		findDifference(start_date, end_date);
        		
=======
        		String month = textMonth.getText();  
        		String worktask = textWorktask.getText();
        		int year = Integer.parseInt(textYear.getText());
>>>>>>> de7e6ed64ad1f4c5f0028f7557db9efe3af5a37d
=======
>>>>>>> parent of b8abe6c (bRuH)
        		
        		for (int i = 0; i < experience.length; i++) {
        			if (experience[i] == null) {
        				Experience exp = new Experience();
        				
        				exp.workplace = workplace;
        				exp.job = job;
        				exp.jobtitle = jobtitle;
        				exp.jobtitle = jobtitle;
        				exp.length = length;
<<<<<<< HEAD
        				
=======
        				exp.month = month;
        				exp.year = year;
        				exp.worktask = worktask;
>>>>>>> de7e6ed64ad1f4c5f0028f7557db9efe3af5a37d
        				
        				experience[i] = exp;
        				
        				break;
        			}
        		}
<<<<<<< HEAD
        		expText.append(workplace + "\n" + job + "\n" + jobtitle + "\n" + length + "\n\n");
        	}
        });
        btnAdd.setBounds(10, 315, 156, 20);
=======
        		expText.append(workplace + "\n" + job + "\n" + length + "\n " + month + "\n " + year + "\n" + worktask);
        	} /*\n\n*/
        });
        btnAdd.setBounds(14, 297, 156, 20);
>>>>>>> de7e6ed64ad1f4c5f0028f7557db9efe3af5a37d
        panel_1.add(btnAdd);
        
        JButton btnNext = new JButton("Next");
        btnNext.setForeground(new Color(255, 255, 255));
        btnNext.setBackground(new Color(128, 128, 128));
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.experience = experience;
        		ITSkills.main(null, cv);
        		frame.dispose();
        	}
        });
        btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNext.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnNext);
        
        
        JLabel lblNewLabel_1 = new JLabel("Workplace:");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(10, 29, 91, 28);
        panel_1.add(lblNewLabel_1);
        
        JButton btnRemove = new JButton("Remove");
        btnRemove.setForeground(new Color(255, 255, 255));
        btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnRemove.setBackground(new Color(128, 128, 128));
        btnRemove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {  
        		for(int i = 0; i < experience.length; i++) {
        			if (experience[i] == null) {
        				try {
        					experience[i - 1] = null;
						} catch (Exception e1) {
							System.out.println(" ");
						}
        			}
        			cv.experience = experience;
    				getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
            	}
        }
        });
<<<<<<< HEAD
        btnRemove.setBounds(176, 314, 154, 20);
        panel_1.add(btnRemove);
=======
        btnRemove.setBounds(180, 297, 154, 20);
        panel_1.add(btnRemove);  
        detailsText.setText(" ");
>>>>>>> de7e6ed64ad1f4c5f0028f7557db9efe3af5a37d
        
        JLabel lblNewLabel_1_1 = new JLabel("Job:");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(12, 69, 81, 28);
        panel_1.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Length:");
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
<<<<<<< HEAD
        lblNewLabel_1_2.setBounds(10, 128, 79, 28);
=======
        lblNewLabel_1_2.setBounds(10, 147, 79, 28);
>>>>>>> parent of b8abe6c (bRuH)
        panel_1.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("First Date:");
        lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_3.setForeground(Color.WHITE);
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_3.setBounds(10, 186, 108, 28);
        panel_1.add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_1_4 = new JLabel("Second Date:");
        lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_4.setForeground(Color.WHITE);
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_4.setBounds(10, 223, 108, 28);
        panel_1.add(lblNewLabel_1_4);
        
        textWorkplace = new JTextField();
        textWorkplace.setBounds(134, 35, 200, 20);
        panel_1.add(textWorkplace);
        textWorkplace.setColumns(10);
        
        textJob = new JTextField();
        textJob.setColumns(10);
        textJob.setBounds(134, 74, 200, 20);
        panel_1.add(textJob);
        
        textLength = new JTextField();
        textLength.setColumns(10);
<<<<<<< HEAD
        textLength.setBounds(134, 134, 200, 20);
=======
        textLength.setBounds(133, 148, 200, 20);
>>>>>>> parent of b8abe6c (bRuH)
        panel_1.add(textLength);
        
        JLabel lblNewLabel_2 = new JLabel("Job title:");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(10, 108, 83, 14);
        panel_1.add(lblNewLabel_2);
        
<<<<<<< HEAD
        textJobTitle = new JTextField();
        textJobTitle.setColumns(10);
        textJobTitle.setBounds(134, 105, 200, 20);
        panel_1.add(textJobTitle);
	}
}
=======
        textYear = new JTextField();
        textYear.setColumns(10);
        textYear.setBounds(134, 195, 200, 20);
        panel_1.add(textYear);
        
        JLabel lblNewLabel_2 = new JLabel("Work task:");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(10, 240, 83, 14);
        panel_1.add(lblNewLabel_2);
        
        textWorktask = new JTextField();
        textWorktask.setBounds(134, 239, 200, 20);
        panel_1.add(textWorktask);
        textWorktask.setColumns(10);
        
	}
}
>>>>>>> de7e6ed64ad1f4c5f0028f7557db9efe3af5a37d
