package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import structs.CV;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ITSkills extends Information {
	private CV cv;
	private String[] itSkills = new String[10];
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, CV curriculumVitae) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ITSkills window = new ITSkills(curriculumVitae);
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
	public ITSkills(CV curriculumVitae) {
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
        panel.setBounds(377, 21, 399, 437);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        // COPY EVERYTHING BELOW
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setForeground(new Color(255, 255, 255));
        tabbedPane.setBackground(new Color(128, 128, 128));
        tabbedPane.setBounds(10, 11, 379, 415);
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
        // COPY ABOVE
        
        JLabel lblNewLabel = new JLabel("IT Skills");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnNext = new JButton("Next");
        btnNext.setForeground(new Color(255, 255, 255));
        btnNext.setBackground(new Color(128, 128, 128));
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.itSkills = itSkills;
        		Languages.main(null, cv);
        		frame.dispose();
        	}
        });
        btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNext.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnNext);
        
        JButton btnBack = new JButton("Back");
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(128, 128, 128));
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.itSkills = itSkills;
        		WorkExperience.main(null, cv);
        		frame.dispose();
        	}
        });
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBack.setBounds(129, 504, 112, 23);
        frame.getContentPane().add(btnBack);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(10, 71, 357, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Programs you can use:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(0, 162, 176, 28);
        panel_1.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setBounds(186, 168, 161, 20);
        panel_1.add(textField);
        textField.setColumns(10);
        
        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setBackground(new Color(128, 128, 128));
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				itText.append(textField.getText() + "\n");
        		for (int i = 0; i < itSkills.length; i++) {
        			if (itSkills[i] == null) {
        				itSkills[i] = textField.getText();
        				break;
        			}
        		}
        		textField.setText(" ");
        	}
        });
        btnAdd.setBounds(10, 201, 163, 20);
        panel_1.add(btnAdd);
        
        /*JButton btnRemove = new JButton("Remove");
        btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnRemove.setBackground(new Color(128, 128, 128));
        btnRemove.setForeground(new Color(255, 255, 255));
        btnRemove.setBounds(186, 201, 161, 20);
        panel_1.add(btnRemove);*/
        
        JButton btnRemove = new JButton("Remove");
        btnRemove.setForeground(new Color(255, 255, 255));
        btnRemove.setBackground(new Color(128, 128, 128));
        btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnRemove.setBounds(186, 201, 161, 20);
        btnRemove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		for(int i = 0; i < itSkills.length; i++) {
        			if (itSkills[i] == null) {
        				try {
        					itSkills[i - 1] = null;
						} catch (Exception e1) {
							System.out.println(" ");
						}
        			}
        		}
				cv.itSkills = itSkills;
				getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        	}
        });
        panel_1.add(btnRemove);
        
        textField.setText(" ");
        detailsText.setText(" ");
        
            		}
            	}       		
