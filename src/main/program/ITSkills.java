package program;

import structs.CV;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class ITSkills extends Information {
	private final CV cv;
	private final String[] itSkills = new String[10];
	private JFrame frame;
	private JTextField textField;

    /**
	 * Launch the application.
	 */
	public static void main(CV curriculumVitae) {
		EventQueue.invokeLater(() -> {
            try {
                ITSkills window = new ITSkills(curriculumVitae);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
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
        Locale l = new Locale(cv.LOCALE);
        ResourceBundle r = ResourceBundle.getBundle("resources/Bundle_" + cv.LOCALE, l);
    	
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
        
        getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        // COPY ABOVE

        tabbedPane.setSelectedIndex(5);
        
        JLabel lblNewLabel = new JLabel(r.getString("skills"));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnNext = new JButton(r.getString("next"));
        btnNext.setForeground(new Color(255, 255, 255));
        btnNext.setBackground(new Color(128, 128, 128));
        btnNext.addActionListener(e -> {
            cv.itSkills = itSkills;
            Languages.main(null, cv);
            frame.dispose();
        });
        btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNext.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnNext);
        
        JButton btnBack = new JButton(r.getString("back"));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(128, 128, 128));
        btnBack.addActionListener(e -> {
            cv.itSkills = itSkills;
            WorkExperience.main(cv);
            frame.dispose();
        });
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBack.setBounds(129, 504, 112, 23);
        frame.getContentPane().add(btnBack);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(10, 71, 357, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel(r.getString("urSkilz")+":");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(75, 130, 206, 28);
        panel_1.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setBounds(23, 168, 310, 20);
        panel_1.add(textField);
        textField.setColumns(10);
        
        JButton btnAdd = new JButton(r.getString("add"));
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setBackground(new Color(128, 128, 128));
        btnAdd.addActionListener(e -> {
            itText.append(textField.getText() + "\n");
            for (int i = 0; i < itSkills.length; i++) {
                if (itSkills[i] == null) {
                    itSkills[i] = textField.getText();
                    break;
                }
            }
            cv.itSkills = itSkills;
            getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        });
        btnAdd.setBounds(10, 201, 163, 20);
        panel_1.add(btnAdd);
        
        JButton btnRemove = new JButton(r.getString("remove"));
        btnRemove.setForeground(new Color(255, 255, 255));
        btnRemove.setBackground(new Color(128, 128, 128));
        btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnRemove.setBounds(186, 201, 161, 20);
        btnRemove.addActionListener(e -> {
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
        });
        panel_1.add(btnRemove);
        
        textField.setText(" ");
        detailsText.setText(" ");
        
            		}
            	}       		
