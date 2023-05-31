package program;

import java.awt.Color; 
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import structs.CV;
import structs.Language;

import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Languages extends Information {
	private CV cv;
	private JFrame frame;
	private Language[] langs;
	private JTextField txtLang;
	private boolean nativeSet = false;

	
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
        langs = cv.langs;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
    	Locale l = new Locale(cv.LOCALE);
    	ResourceBundle r = ResourceBundle.getBundle("resources/Bundle_"+cv.LOCALE, l);
    	
		frame = new JFrame();
        frame.getContentPane().setBackground(new Color(39, 39, 39));
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(49, 49, 49));
        panel.setBounds(374, 21, 402, 437);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        
        // TABS
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setForeground(new Color(255, 255, 255));
        tabbedPane.setBackground(new Color(128, 128, 128));
        tabbedPane.setBounds(10, 11, 382, 415);
        panel.add(tabbedPane);
        
        JScrollPane detailsTab = new JScrollPane();
        tabbedPane.addTab(r.getString("details"), null, detailsTab, null);
        
        JTextArea detailsText = new JTextArea();
        detailsText.setEditable(false);
        detailsTab.setViewportView(detailsText);
        
        JScrollPane strengthsTab = new JScrollPane();
        tabbedPane.addTab(r.getString("strengths"), null, strengthsTab, null);
        
        JTextArea strengthsText = new JTextArea();
        strengthsText.setEditable(false);
        strengthsTab.setViewportView(strengthsText);
        
        JScrollPane degreeTab = new JScrollPane();
        tabbedPane.addTab(r.getString("degrees"), null, degreeTab, null);
        
        JTextArea degreeText = new JTextArea();
        degreeText.setEditable(false);
        degreeTab.setViewportView(degreeText);
        
        JScrollPane courseTab = new JScrollPane();
        tabbedPane.addTab(r.getString("courses"), null, courseTab, null);
        
        JTextArea courseText = new JTextArea();
        courseText.setEditable(false);
        courseTab.setViewportView(courseText);
        
        JScrollPane expTab = new JScrollPane();
        tabbedPane.addTab(r.getString("experience"), null, expTab, null);
        
        JTextArea expText = new JTextArea();
        expText.setEditable(false);
        expTab.setViewportView(expText);
        
        JScrollPane itTab = new JScrollPane();
        tabbedPane.addTab(r.getString("skills"), null, itTab, null);
        
        JTextArea itText = new JTextArea();
        itText.setEditable(false);
        itTab.setViewportView(itText);
        
        JScrollPane langTab = new JScrollPane();
        tabbedPane.addTab(r.getString("languages"), null, langTab, null);
        
        JTextArea langsText = new JTextArea();
        langsText.setEditable(false);
        langTab.setViewportView(langsText);
        
        JScrollPane hobbyTab = new JScrollPane();
        tabbedPane.addTab(r.getString("hobbies"), null, hobbyTab, null);
        
        JTextArea hobbyText = new JTextArea();
        hobbyText.setEditable(false);
        hobbyTab.setViewportView(hobbyText);
        
        JScrollPane positionTab = new JScrollPane();
        tabbedPane.addTab(r.getString("positions"), null, positionTab, null);
        
        JTextArea positionText = new JTextArea();
        positionText.setEditable(false);
        positionTab.setViewportView(positionText);
        
        JScrollPane refereeTab = new JScrollPane();
        tabbedPane.addTab(r.getString("references"), null, refereeTab, null);
        
        JTextArea refereeText = new JTextArea();
        refereeText.setEditable(false);
        refereeTab.setViewportView(refereeText);

       	for (int i = 0; i < cv.langs.length; i++) {
       		if (cv.langs[i] != null && cv.langs[i].nativeLang == true) {
       			nativeSet = true;
       		}
       	}

        tabbedPane.setSelectedIndex(6);
        
        JLabel lblNewLabel = new JLabel(r.getString("langSkill"));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        //To the next part
        JButton btnNext = new JButton(r.getString("next"));
        btnNext.setForeground(new Color(255, 255, 255));
        btnNext.setBackground(new Color(128, 128, 128));
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.langs = langs;
        		Hobbies.main(cv);
        		frame.dispose();
        	}
        });
        btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNext.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnNext);
        //Go back to the previous part
        JButton btnBack = new JButton(r.getString("back"));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(128, 128, 128));
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.langs = langs;
        		ITSkills.main(cv);
        		frame.dispose();
        	}
        });
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBack.setBounds(127, 504, 112, 23);
        frame.getContentPane().add(btnBack);
        //Panel for languages selection
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(10, 71, 354, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel(r.getString("langIn"));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(10, 5, 150, 30);
        panel_1.add(lblNewLabel_1);
        //Radio button for "Beginner speech"
        JRadioButton rdbtnBegSpeech = new JRadioButton(r.getString("beginner"));
        rdbtnBegSpeech.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnBegSpeech.setForeground(new Color(255, 255, 255));
        rdbtnBegSpeech.setBackground(new Color(86, 86, 86));
        rdbtnBegSpeech.setBounds(170, 88, 174, 21);
        panel_1.add(rdbtnBegSpeech);
        //Radio button for "Intermediate speech"
        JRadioButton rdbtnInterSpeech = new JRadioButton(r.getString("intermediate"));
        rdbtnInterSpeech.setForeground(Color.WHITE);
        rdbtnInterSpeech.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnInterSpeech.setBackground(new Color(86, 86, 86));
        rdbtnInterSpeech.setBounds(170, 112, 174, 21);
        panel_1.add(rdbtnInterSpeech);
        //Radio button for "Advanced speech"
        JRadioButton rdbtnAdSpeech = new JRadioButton(r.getString("advanced"));
        rdbtnAdSpeech.setForeground(Color.WHITE);
        rdbtnAdSpeech.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnAdSpeech.setBackground(new Color(86, 86, 86));
        rdbtnAdSpeech.setBounds(170, 136, 174, 21);
        panel_1.add(rdbtnAdSpeech);
        //Radio button for "Fluent speech"
        JRadioButton rdbtnFluSpeech = new JRadioButton(r.getString("fluent"));
        rdbtnFluSpeech.setForeground(Color.WHITE);
        rdbtnFluSpeech.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnFluSpeech.setBackground(new Color(86, 86, 86));
        rdbtnFluSpeech.setBounds(170, 160, 174, 21);
        panel_1.add(rdbtnFluSpeech);
        //Radio button for "Beginner Writing"
        JRadioButton rdbtnBegWrite = new JRadioButton(r.getString("beginner"));
        rdbtnBegWrite.setForeground(Color.WHITE);
        rdbtnBegWrite.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnBegWrite.setBackground(new Color(86, 86, 86));
        rdbtnBegWrite.setBounds(10, 225, 174, 21);
        panel_1.add(rdbtnBegWrite);
        //Radio button for "Intermediate Writing"
        JRadioButton rdbtnInterWrite = new JRadioButton(r.getString("intermediate"));
        rdbtnInterWrite.setForeground(Color.WHITE);
        rdbtnInterWrite.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnInterWrite.setBackground(new Color(86, 86, 86));
        rdbtnInterWrite.setBounds(10, 249, 174, 21);
        panel_1.add(rdbtnInterWrite);
        //Radio button for "Advanced Writing"
        JRadioButton rdbtnAdWrite = new JRadioButton(r.getString("advanced"));
        rdbtnAdWrite.setForeground(Color.WHITE);
        rdbtnAdWrite.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnAdWrite.setBackground(new Color(86, 86, 86));
        rdbtnAdWrite.setBounds(10, 273, 174, 21);
        panel_1.add(rdbtnAdWrite);
        //Radio button for "Fluent writing"
        JRadioButton rdbtnFluWrite = new JRadioButton(r.getString("fluent"));
        rdbtnFluWrite.setForeground(Color.WHITE);
        rdbtnFluWrite.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnFluWrite.setBackground(new Color(86, 86, 86));
        rdbtnFluWrite.setBounds(10, 297, 174, 21);
        panel_1.add(rdbtnFluWrite);
        //label for "Select Speech"
        JLabel lblNewLabel_1_1_1 = new JLabel(r.getString("selectSpeech")+":");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1.setBounds(10, 51, 334, 30);
        panel_1.add(lblNewLabel_1_1_1);
        //label for "Select written"
        JLabel lblNewLabel_1_1_1_1 = new JLabel(r.getString("selectWritten")+":");
        lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1_1_1.setBounds(10, 188, 334, 30);
        panel_1.add(lblNewLabel_1_1_1_1);
        //Button group for "Speech"
        ButtonGroup Speech = new ButtonGroup();
        Speech.add(rdbtnFluSpeech);
        Speech.add(rdbtnAdSpeech);
        Speech.add(rdbtnInterSpeech);
        Speech.add(rdbtnBegSpeech);
        //Button group for "Write"
        ButtonGroup Write = new ButtonGroup();
        Write.add(rdbtnFluWrite);
        Write.add(rdbtnAdWrite);
        Write.add(rdbtnInterWrite);
        Write.add(rdbtnBegWrite);
        //CheckBox to check that the language is native for the person
        JCheckBox checkboxNative = new JCheckBox("");
        checkboxNative.setEnabled(!nativeSet);
        checkboxNative.setForeground(Color.WHITE);
        checkboxNative.setBackground(new Color(49, 49, 49));
        checkboxNative.setBounds(229, 326, 97, 23);
        panel_1.add(checkboxNative);
        //adds the language to the list
        JButton btnAdd = new JButton(r.getString("add"));
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		for (int i = 0; i < langs.length; i++) {
        			if (langs[i] == null) {
        				Language l = new Language();
        				l.langName = txtLang.getText();
        				l.spoken = getSelectedButtonText(Speech);
        				l.written = getSelectedButtonText(Write);
        				
                		if (checkboxNative.isSelected()) {
                			l.nativeLang = true;
                			l.spoken = r.getString("fluent");
                			l.written = r.getString("fluent");
                			nativeSet = true;
                		}
                		
        				if (l.spoken == null && !l.nativeLang) l.spoken = r.getString("beginner");
        				if (l.written == null && !l.nativeLang) l.written = r.getString("beginner");
        				
        				langs[i] = l;
        				
        				break;
        			}
        		}
                checkboxNative.setEnabled(!nativeSet);
                
    			checkboxNative.setSelected(!nativeSet);
    			Write.setSelected(null, false);
    			Speech.setSelected(null, false);
    			txtLang.setText(null);
    			
        		cv.langs = langs;
        		getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        	}		
        });
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setBackground(new Color(128, 128, 128));
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAdd.setBounds(10, 353, 154, 23);
        panel_1.add(btnAdd);
        //removes the language from the list
        JButton btnRemove = new JButton(r.getString("remove"));
        btnRemove.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnRemove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		for(int i = 0; i < langs.length; i++) {
        			if (langs[i] == null) {
						if (langs[i - 1].nativeLang) {
							nativeSet = false;
							checkboxNative.setEnabled(!nativeSet);
						}
						langs[i - 1] = null;
						
						break;
        			}
        		}
				
				cv.langs = langs;
				getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        	}
        });
        btnRemove.setForeground(new Color(255, 255, 255));
        btnRemove.setBackground(new Color(128, 128, 128));
        btnRemove.setBounds(174, 353, 170, 23);
        panel_1.add(btnRemove);
        //For writing the name of the language
        txtLang = new JTextField();
        txtLang.setBounds(170, 12, 174, 21);
        panel_1.add(txtLang);
        txtLang.setColumns(10);
        //label for "Set Native"
        JLabel lblNewLabel_2 = new JLabel(r.getString("setNative"));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(10, 325, 213, 21);
        panel_1.add(lblNewLabel_2);

        //GET TAB INFO
        getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
    }
}
