package program;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

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

public class Courses extends Information {
	private final CV cv;
	private String[] courses;
	private JFrame frame;
	private JTextField coursesField;

    /**
	 * Launch the application.
	 */
	public static void main(CV curriculumVitae) {
		EventQueue.invokeLater(() -> {
            try {
                Courses window = new Courses(curriculumVitae);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	/**
	 * Create the application.
	 */
	public Courses(CV curriculumVitae) {
		cv = curriculumVitae;
        courses = cv.courses;
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
        panel.setBounds(374, 21, 402, 437);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
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

        tabbedPane.setSelectedIndex(3);
        
        JButton btnBack = new JButton(r.getString("back"));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(128, 128, 128));
        btnBack.addActionListener(e -> {
            cv.courses = courses;
            Degrees.main(null, cv);
            frame.dispose();
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnBack.setBounds(127, 504, 112, 23);
        frame.getContentPane().add(btnBack);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(10, 71, 354, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        coursesField = new JTextField();
        coursesField.setBounds(23, 168, 310, 20);
        panel_1.add(coursesField);
        coursesField.setColumns(10);
        
        JButton btnAdd = new JButton(r.getString("add"));
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setBackground(new Color(128, 128, 128));
        btnAdd.addActionListener(e -> {
            String course = coursesField.getText();
            courseText.append(course + "\n");
            for (int i = 0; i < course.length(); i++) {
                if (Objects.equals(courses[i], "") || courses[i] == null) {
                    courses[i] = course;
                    break;
                }
            }
        });
        btnAdd.setBounds(10, 201, 163, 20);
        panel_1.add(btnAdd);
        
        JButton btnNext = new JButton(r.getString("next"));
        btnNext.setForeground(new Color(255, 255, 255));
        btnNext.setBackground(new Color(128, 128, 128));
        btnNext.addActionListener(e -> {
            cv.courses = courses;
            WorkExperience.main(cv);
            frame.dispose();
        });
        btnNext.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNext.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnNext);
        
        
        JLabel lblNewLabel_1 = new JLabel(r.getString("yourCourses")+":");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(75, 130, 206, 28);
        panel_1.add(lblNewLabel_1);
        
        /*JButton btnRemove = new JButton("Remove");
        btnRemove.setForeground(new Color(255, 255, 255));
        btnRemove.setBackground(new Color(128, 128, 128));
        btnRemove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
       			String newText = courseText.getText().replace("\n" + coursesField.getText() + "\n", "\n");
           		for (int i = 0; i < 10; i++) {
           			if (courses[i] == coursesField.getText()) {
           				courses[i] = "";                				
            		}
            	}
        		strengthsText.setText(newText);*/
        JButton btnRemove = new JButton(r.getString("remove"));
        btnRemove.setForeground(new Color(255, 255, 255));
        btnRemove.setBackground(new Color(128, 128, 128));
        btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnRemove.setBounds(186, 201, 161, 20);
        btnRemove.addActionListener(e -> {
            for(int i = 0; i < 10; i++) {
                if (courses[i] == null) {
                    try {
                        courses[i - 1] = null;
                    } catch (Exception e1) {
                        System.out.println(" ");
                    }
                }
            }
            cv.courses = courses;
            getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        });
        panel_1.add(btnRemove);
        
        JLabel lblNewLabel = new JLabel(r.getString("courses"));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(38, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        //GET TAB INFO
        getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        
	}
}
