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
import structs.Details;
import structs.Language;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ITSkills {
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
        strengthsText.setEditable(false);
        strengthsTab.setViewportView(strengthsText);
        String[] strengths = cv.getStrengths();
        strengthsText.setText("Strengths:\n");
        for (int i = 0; i < strengths.length; i++) {
        	if (strengths[i] != null && strengths[i] != "") strengthsText.append(strengths[i] + "\n");
        }
        
        JScrollPane langTab = new JScrollPane();
        tabbedPane.addTab("Languages", null, langTab, null);
        
        JTextArea langsText = new JTextArea();
        langsText.setEditable(false);
        langTab.setViewportView(langsText);
        langsText.setText("Languages:\n");
        Language[] languages = cv.getLanguages();
        for (int i = 0; i < languages.length; i++) {
        	if (languages[i] != null) {
        		langsText.append(
        				languages[i].getLangName() + "\n" +
        				"Writing: " + languages[i].getWritten() + "\n" +
        				"Speech: " + languages[i].getSpoken()
        		);
        	}
        }
        
        JScrollPane scrollPane = new JScrollPane();
        tabbedPane.addTab("IT Skills", null, scrollPane, null);
        
        JTextArea itText = new JTextArea();
        itText.setEditable(false);
        scrollPane.setViewportView(itText);
        itText.setText("IT Skills:\n");
        itSkills = cv.getItSkills();
        for (int i = 0; i < itSkills.length; i++) {
        	if (itSkills[i] != null) itText.append(itSkills[i] + "\n");
        }
        
        JLabel lblNewLabel = new JLabel("IT Skills");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Languages.main(null, cv);
        		frame.dispose();
        	}
        });
        btnNext.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNext.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnNext);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.setItSkills(itSkills);
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
        
        JLabel lblNewLabel_1 = new JLabel("Program");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 114, 334, 57);
        panel_1.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setBounds(47, 182, 260, 37);
        panel_1.add(textField);
        textField.setColumns(10);
        
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				itText.append(textField.getText() + "\n");
        		for (int i = 0; i < itSkills.length; i++) {
        			if (itSkills[i] == null) {
        				itSkills[i] = textField.getText();
        				break;
        			}
        		}
        		textField.setText("");
        	}
        });
        btnAdd.setBounds(40, 272, 116, 37);
        panel_1.add(btnAdd);
        
        JButton btnRemove = new JButton("Remove");
        btnRemove.setBounds(196, 272, 116, 37);
        panel_1.add(btnRemove);
    }
}
