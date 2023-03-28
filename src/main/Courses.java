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
import structs.Details;
import structs.Language;

public class Courses {
	private CV cv;
	private String[] courses = {
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
		"",
	};
	private JFrame frame;
	private JTextField coursesField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, CV curriculumVitae) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Courses window = new Courses(curriculumVitae);
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
	public Courses(CV curriculumVitae) {
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
        detailsText.setText("Details:\n");
        Details details = cv.getDetails();
        if (details != null) {
        	detailsText.append(
        			details.getName() + "\n" +
        			details.getAddress() + "\n" +
        			details.getZip() + details.getTown() + "\n" +
        			details.getPhone() + "\n" +
        			details.getEmail()
        	);
        }
        
        JScrollPane strengthsTab = new JScrollPane();
        tabbedPane.addTab("Strengths", null, strengthsTab, null);
        
        JTextArea strengthsText = new JTextArea();
        strengthsText.setText("Strengths:\n");
    	String[] strengths = cv.getStrengths();
        for (int i = 0; i < strengths.length; i++) {
        	if (strengths[i] != null) strengthsText.append(strengths[i] + "\n");
        }
        strengthsText.setEditable(false);
        strengthsTab.setViewportView(strengthsText);
        
        JScrollPane langTab = new JScrollPane();
        tabbedPane.addTab("Languages", null, langTab, null);
        
        JTextArea langsText = new JTextArea();
        langsText.setEditable(false);
        langTab.setViewportView(langsText);
        Language[] langs = cv.getLanguages();
        langsText.setText("Languages:\n");
        for (int i = 0; i < langs.length; i++) {
        	if (langs[i] != null) {
            	String spoken = langs[i].getSpoken();
            	String written = langs[i].getWritten();
            	String langName = langs[i].getLangName();
        		langsText.append(
        				langName + ":\n" +
        				"Written: " + written + "\n" +
        				"Spoken: " + spoken + "\n"
        		);
        	}
        }
        
        JScrollPane itTab = new JScrollPane();
        tabbedPane.addTab("IT Skills", null, itTab, null);
        
        JTextArea itText = new JTextArea();
        itText.setEditable(false);
        itTab.setViewportView(itText);
        String[] itSkills = cv.getItSkills();
        itText.setText("IT Skills:\n");
        for (int i = 0; i < itSkills.length; i++) {
        	if (itSkills[i] != null) {
        		itText.append(itSkills[i] + "\n");
        	}
        }
        
        JScrollPane coursesPane = new JScrollPane();
        tabbedPane.addTab("Courses", null, coursesPane, null);
        
        JTextArea txtCourses = new JTextArea();
        txtCourses.setEditable(false);
        coursesPane.setViewportView(txtCourses);
        String[] courses = cv.getCourses();
        for (int i = 0; i < courses.length; i++) {
        	if (courses[i] != null) txtCourses.append(courses[i] + "\n");
        }
        
        JLabel lblNewLabel = new JLabel("Strengths");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.setCourses(courses);
        		Languages.main(null, cv);
        		frame.dispose();
        	}
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnBack.setBounds(127, 504, 112, 23);
        frame.getContentPane().add(btnBack);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(38, 71, 354, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        coursesField = new JTextField();
        coursesField.setBounds(64, 166, 225, 34);
        panel_1.add(coursesField);
        coursesField.setColumns(10);
        
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String course = coursesField.getText();
        		txtCourses.append(course + "\n");
        		for (int i = 0; i < course.length(); i++) {
        			if (courses[i] == "" || courses[i] == null) {
        				courses[i] = course;
        				break;
        			}
        		}
        	}
        });
        btnAdd.setBounds(52, 281, 98, 34);
        panel_1.add(btnAdd);
        
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNext.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNext.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnNext);
        
        
        JLabel lblNewLabel_1 = new JLabel("Courses");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(80, 115, 193, 40);
        panel_1.add(lblNewLabel_1);
        
        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
       			String newText = txtCourses.getText().replace("\n" + coursesField.getText() + "\n", "\n");
           		for (int i = 0; i < 10; i++) {
           			if (courses[i] == coursesField.getText()) {
           				courses[i] = "";
            		}
            	}
        		strengthsText.setText(newText);
        	}
        });
        btnRemove.setBounds(202, 281, 98, 34);
        panel_1.add(btnRemove);
	}
}
