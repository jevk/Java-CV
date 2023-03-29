package main;

import java.awt.Color; 
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import structs.CV;
import structs.Language;

import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Languages extends Information {
	private CV cv;
	private JFrame frame;
	private Language[] langs = new Language[10];
	private JTextField txtLang;

	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, CV curriculumVitae) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Languages window = new Languages(curriculumVitae);
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
	public Languages(CV curriculumVitae) {
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
        
        
        // TABS
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
        
        //GET TAB INFO
       	getCV(cv, detailsText, strengthsText, degreeText, expText, itText, langsText, hobbyText, positionText, refereeText);
        
        
        
        JLabel lblNewLabel = new JLabel("Language Skills");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.langs = langs;
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
        		cv.langs = langs;
        		ITSkills.main(null, cv);
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
        
        JLabel lblNewLabel_1 = new JLabel("Write a language:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(10, 10, 150, 30);
        panel_1.add(lblNewLabel_1);
        
        JRadioButton rdbtnBegSpeech = new JRadioButton("Beginner");
        rdbtnBegSpeech.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnBegSpeech.setForeground(new Color(255, 255, 255));
        rdbtnBegSpeech.setBackground(new Color(86, 86, 86));
        rdbtnBegSpeech.setBounds(170, 88, 174, 21);
        panel_1.add(rdbtnBegSpeech);
        
        JRadioButton rdbtnInterSpeech = new JRadioButton("Intermediate");
        rdbtnInterSpeech.setForeground(Color.WHITE);
        rdbtnInterSpeech.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnInterSpeech.setBackground(new Color(86, 86, 86));
        rdbtnInterSpeech.setBounds(170, 112, 174, 21);
        panel_1.add(rdbtnInterSpeech);
        
        JRadioButton rdbtnAdSpeech = new JRadioButton("Advanced");
        rdbtnAdSpeech.setForeground(Color.WHITE);
        rdbtnAdSpeech.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnAdSpeech.setBackground(new Color(86, 86, 86));
        rdbtnAdSpeech.setBounds(170, 136, 174, 21);
        panel_1.add(rdbtnAdSpeech);
        
        JRadioButton rdbtnNatSpeech = new JRadioButton("Native");
        rdbtnNatSpeech.setForeground(Color.WHITE);
        rdbtnNatSpeech.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnNatSpeech.setBackground(new Color(86, 86, 86));
        rdbtnNatSpeech.setBounds(170, 160, 174, 21);
        panel_1.add(rdbtnNatSpeech);
        
        JRadioButton rdbtnBegWrite = new JRadioButton("Beginner");
        rdbtnBegWrite.setForeground(Color.WHITE);
        rdbtnBegWrite.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnBegWrite.setBackground(new Color(86, 86, 86));
        rdbtnBegWrite.setBounds(10, 225, 174, 21);
        panel_1.add(rdbtnBegWrite);
        
        JRadioButton rdbtnInterWrite = new JRadioButton("Intermediate");
        rdbtnInterWrite.setForeground(Color.WHITE);
        rdbtnInterWrite.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnInterWrite.setBackground(new Color(86, 86, 86));
        rdbtnInterWrite.setBounds(10, 249, 174, 21);
        panel_1.add(rdbtnInterWrite);
        
        JRadioButton rdbtnAdWrite = new JRadioButton("Advanced");
        rdbtnAdWrite.setForeground(Color.WHITE);
        rdbtnAdWrite.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnAdWrite.setBackground(new Color(86, 86, 86));
        rdbtnAdWrite.setBounds(10, 273, 174, 21);
        panel_1.add(rdbtnAdWrite);
        
        JRadioButton rdbtnNatWrite = new JRadioButton("Native");
        rdbtnNatWrite.setForeground(Color.WHITE);
        rdbtnNatWrite.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnNatWrite.setBackground(new Color(86, 86, 86));
        rdbtnNatWrite.setBounds(10, 297, 174, 21);
        panel_1.add(rdbtnNatWrite);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Select your speech skill level:");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_1_1_1.setBounds(10, 51, 334, 30);
        panel_1.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Select your writing skill level:");
        lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_1_1_1_1.setBounds(10, 188, 334, 30);
        panel_1.add(lblNewLabel_1_1_1_1);
        
        ButtonGroup Speech = new ButtonGroup();
        Speech.add(rdbtnNatSpeech);
        Speech.add(rdbtnAdSpeech);
        Speech.add(rdbtnInterSpeech);
        Speech.add(rdbtnBegSpeech);
        
        ButtonGroup Write = new ButtonGroup();
        Write.add(rdbtnNatWrite);
        Write.add(rdbtnAdWrite);
        Write.add(rdbtnInterWrite);
        Write.add(rdbtnBegWrite);
        
        JButton btnAdd = new JButton("Add an entry");
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (!Write.isSelected(null) && !Speech.isSelected(null)) {
        			langsText.append(txtLang.getText() + ": \nWriting: " + getSelectedButtonText(Write) + "\nSpeech: " + getSelectedButtonText(Speech) + "\n");
        			Language lang = new Language(
        					txtLang.getText().toString(), 
        					getSelectedButtonText(Write), 
        					getSelectedButtonText(Speech)
        			);
        			for (int i = 0; i < langs.length; i++) {
        				System.out.println(i);
        				if (langs[i] == null) {
        					langs[i] = lang;
        					break;
        				}
        			}
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "You also must select both skill levels to add an entry to the CV");
        		}
        	}		
        });
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setBackground(new Color(128, 128, 128));
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAdd.setBounds(10, 353, 154, 23);
        panel_1.add(btnAdd);
        
        JButton btnNewButton = new JButton("Clear 3 last lines");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int end;
				try {
					end = langsText.getLineEndOffset(2);
					langsText.replaceRange("", 0, end);
				} catch (BadLocationException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
        	}
        });
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(128, 128, 128));
        btnNewButton.setBounds(174, 353, 170, 23);
        panel_1.add(btnNewButton);
        
        txtLang = new JTextField();
        txtLang.setBounds(170, 12, 174, 30);
        panel_1.add(txtLang);
        txtLang.setColumns(10);
    }
}
