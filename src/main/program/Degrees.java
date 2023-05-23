package program;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import structs.CV;
import structs.Degree;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class Degrees extends Information {
	private CV cv;
	private Degree[] degrees = new Degree[10];
	private JFrame frame;
	private JTextField txtSchool;
	private JTextField txtEducation;
	private JTextField txtDegree;

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
    	Locale l = new Locale(cv.LOCALE);
    	ResourceBundle r = ResourceBundle.getBundle("resources/Bundle_"+cv.LOCALE, l);
    	
    	degrees = cv.degrees;
    	
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(39, 39, 39));
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(49, 49, 49));
        panel.setBounds(376, 21, 400, 437);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setForeground(new Color(255, 255, 255));
        tabbedPane.setBackground(new Color(128, 128, 128));
        tabbedPane.setBounds(10, 11, 380, 415);
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
        hobbyTab.setViewportView(hobbyText);
        
        JScrollPane positionTab = new JScrollPane();
        tabbedPane.addTab(r.getString("positions"), null, positionTab, null);
        
        JTextArea positionText = new JTextArea();
        positionTab.setViewportView(positionText);
        
        JScrollPane refereeTab = new JScrollPane();
        tabbedPane.addTab(r.getString("references"), null, refereeTab, null);
        
        JTextArea refereeText = new JTextArea();
        refereeTab.setViewportView(refereeText);
        
        getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        
        JLabel lblNewLabel = new JLabel(r.getString("degrees"));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnNext = new JButton(r.getString("next"));
        btnNext.setForeground(new Color(255, 255, 255));
        btnNext.setBackground(new Color(128, 128, 128));
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.degrees = degrees;
        		Courses.main(cv);
        		frame.dispose();
        	}
        });
        btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNext.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnNext);
        
        JButton btnBack = new JButton(r.getString("back"));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(128, 128, 128));
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cv.degrees = degrees;
        		Strengths.main(cv);
        		frame.dispose();
        	}
        });
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBack.setBounds(127, 504, 112, 23);
        frame.getContentPane().add(btnBack);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(10, 71, 356, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel(r.getString("school")+":");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(10, 24, 112, 21);
        panel_1.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel(r.getString("education")+":");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setBounds(10, 72, 112, 21);
        panel_1.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel(r.getString("degree")+":");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_2.setBounds(10, 119, 112, 21);
        panel_1.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_3 = new JLabel(r.getString("year1")+":");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_3.setForeground(Color.WHITE);
        lblNewLabel_1_3.setBounds(10, 168, 112, 21);
        panel_1.add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_1_4 = new JLabel(r.getString("year2")+":");
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_4.setForeground(Color.WHITE);
        lblNewLabel_1_4.setBounds(10, 219, 112, 21);
        panel_1.add(lblNewLabel_1_4);
        
        txtSchool = new JTextField(); 
        txtSchool.setBounds(132, 27, 211, 20);
        panel_1.add(txtSchool);
        txtSchool.setColumns(10);
        
        txtEducation = new JTextField();
        txtEducation.setColumns(10);
        txtEducation.setBounds(132, 75, 212, 20);
        panel_1.add(txtEducation);
        
        txtDegree = new JTextField();
        txtDegree.setColumns(10);
        txtDegree.setBounds(132, 122, 212, 20);
        panel_1.add(txtDegree);
        
        JSpinner selectStartYear = new JSpinner();
        selectStartYear.setBounds(132, 171, 215, 20);
        selectStartYear.setValue(2000);
        panel_1.add(selectStartYear);
        
        JSpinner selectEndYear = new JSpinner();
        selectEndYear.setBounds(132, 222, 213, 20);
        selectEndYear.setValue(2000);
        panel_1.add(selectEndYear);
        
		// degrees[i - 1] = null;
        
       
        
        JButton btnAdd = new JButton("Add");
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setBackground(new Color(128, 128, 128));
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		for(int i = 0; i < degrees.length; i++) {
        			if (degrees[i] == null) {
        				Degree deg = new Degree();
        				deg.school = txtSchool.getText();
        				deg.education = txtEducation.getText();
        				deg.degree = txtDegree.getText();
        				deg.startYear = Integer.toString((int)selectStartYear.getValue());
        				deg.endYear = Integer.toString((int)selectEndYear.getValue());
        				degrees[i] = deg;
        				break;
        			}
        			else if (txtSchool.getText().isEmpty()||txtEducation.getText().isEmpty()||txtDegree.getText().isEmpty()) {
        				JOptionPane.showMessageDialog(null, r.getString("enterAll"));
                    	break;
        			}
        			else if(txtSchool.getText().isEmpty())
                    {
                    	JOptionPane.showMessageDialog(null, r.getString("enterSchool"));
                    	break;
                    }
        			else if(txtEducation.getText().isEmpty())
        			{
        				JOptionPane.showMessageDialog(null, r.getString("enterEd"));
                    	break;
        			}
        			else if(txtDegree.getText().isEmpty())
        			{
        				JOptionPane.showMessageDialog(null, r.getString("enterDeg"));
                    	break;
        			}
        		}
				cv.degrees = degrees;
				getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        	}
        });
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnAdd.setBounds(10, 272, 169, 21);
        panel_1.add(btnAdd);
        
        JButton btnRemove = new JButton(r.getString("remove"));
        btnRemove.setForeground(new Color(255, 255, 255));
        btnRemove.setBackground(new Color(128, 128, 128));
        btnRemove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		for(int i = 0; i < degrees.length; i++) {
        			if (degrees[i] == null) {
        				try {
							degrees[i - 1] = null;
						} catch (Exception e1) {
							System.out.println("fucking retard xD");
						}
        			}
        		}
				cv.degrees = degrees;
				getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        	}
        });
        btnRemove.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnRemove.setBounds(190, 271, 154, 21);
        panel_1.add(btnRemove);
        
        JLabel errorlabel = new JLabel(r.getString("plsEnter"));
        errorlabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        errorlabel.setForeground(Color.RED);
        errorlabel.setBounds(253, 52, 92, 21);
        panel_1.add(errorlabel);
        
        JLabel errorlabel_1 = new JLabel(r.getString("plsEnter"));
        errorlabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        errorlabel_1.setForeground(Color.RED);
        errorlabel_1.setBounds(252, 94, 92, 28);
        panel_1.add(errorlabel_1);
        
        JLabel mgmghfafmgmasfmofEatingPorn = new JLabel(r.getString("plsEnter"));
        mgmghfafmgmasfmofEatingPorn.setFont(new Font("Tahoma", Font.BOLD, 11));
        mgmghfafmgmasfmofEatingPorn.setForeground(Color.RED);
        mgmghfafmgmasfmofEatingPorn.setBounds(249, 143, 95, 28);
        panel_1.add(mgmghfafmgmasfmofEatingPorn);
    }
}
