
package program;

import com.toedter.calendar.JDateChooser;
import structs.CV;
import structs.Experience;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.ResourceBundle;

public class WorkExperience extends Information {
	private final CV cv;
	private final Experience[] experience;
	private JFrame frame;
	private JTextField textWorkplace;
	private JTextField textJob;
    private JTextField textJobTitle;

    private ResourceBundle r;
	private static String lang;

	private LocalDateTime convertToLocalDateTime(java.util.Date date) {
		return date.toInstant()
    		.atZone(ZoneId.systemDefault())
            .toLocalDateTime();
	}
	
	private String daysToString(float days) {
		int years = (int) (days / 365);
		int months = (int) ((days - years * 365) / 30);
		int weeks = (int) ((days - years * 365 - months * 30) / 7);
		
		String time = "";
		String yPlural = "";
		String mPlural = "";
		String wPlural = "";
		
		if (years > 1) yPlural = "s";
		if (months > 1) mPlural = "s";
		if (weeks > 1) wPlural = "s";
		
		if (years > 0) time += years + " " + r.getString("year"+yPlural) + ", ";
		if (months > 0) time += months + " " + r.getString("month"+mPlural) + ", ";
		if (weeks > 0 && years == 0) time += weeks + " " + r.getString("week"+wPlural);
		
		return time;
	}
	
	public static void main(CV curriculumVitae) {
		lang = curriculumVitae.LOCALE;
		EventQueue.invokeLater(() -> {
            try {
                WorkExperience window = new WorkExperience(curriculumVitae);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
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
        Locale l = new Locale(lang);
    	r = ResourceBundle.getBundle("resources/Bundle_"+lang, l);
    	
        frame = new JFrame();
        frame.getContentPane().setLocation(-25, -71);
        frame.getContentPane().setBackground(new Color(39, 39, 39));
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 800, 600);
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
        itText.setText(r.getString("skills") + ":\n");
        
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
        
        JLabel lblNewLabel = new JLabel(r.getString("experience"));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        
        JButton btnBack = new JButton(r.getString("back"));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(128, 128, 128));
        btnBack.addActionListener(e -> {
            cv.experience = experience;
            Courses.main(cv);
            frame.dispose();
        });
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnBack.setBounds(127, 504, 112, 23);
        frame.getContentPane().add(btnBack);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(10, 71, 340, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JDateChooser start_date = new JDateChooser();
        start_date.setBounds(134, 134, 200, 20);
        panel_1.add(start_date);
        
        JDateChooser end_date = new JDateChooser();
        end_date.setBounds(134, 165, 200, 20);
        panel_1.add(end_date);
        
        JButton btnAdd = new JButton(r.getString("add"));
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAdd.setBackground(new Color(128, 128, 128));
        btnAdd.addActionListener(e -> {
        	String workplace = textWorkplace.getText();
        	String job = textJob.getText();
        	String jobtitle = textJobTitle.getText();

        	LocalDateTime start = convertToLocalDateTime(start_date.getDate());
        	LocalDateTime end = convertToLocalDateTime(end_date.getDate());
            float duration = Float.parseFloat(Long.toString(Duration.between(start, end).toDays()));

            String timeString = daysToString(duration);

         	for (int i = 0; i < experience.length; i++) {
        		if (experience[i] == null) {
        			Experience exp = new Experience();

        			exp.workplace = workplace;
        			exp.job = job;
        			exp.jobtitle = jobtitle;
        			exp.length = timeString;

        			experience[i] = exp;

        			break;
        		}
        	}
         	cv.experience = experience;
         	getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        });
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnAdd.setBackground(Color.GRAY);
        btnAdd.setBounds(16, 297, 154, 20);
        panel_1.add(btnAdd);
        
        JButton btnNext = new JButton(r.getString("next"));
        btnNext.setForeground(new Color(255, 255, 255));
        btnNext.setBackground(new Color(128, 128, 128));
        btnNext.addActionListener(e -> {
            cv.experience = experience;
            ITSkills.main(cv);
            frame.dispose();
        });
        btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNext.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnNext);
        
        
        JLabel lblNewLabel_1 = new JLabel(r.getString("workPlace") + ":");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(10, 35, 91, 28);
        panel_1.add(lblNewLabel_1);
        
        JButton btnRemove = new JButton("Remove");
        btnRemove.setForeground(new Color(255, 255, 255));
        btnRemove.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnRemove.setBackground(new Color(128, 128, 128));
        btnRemove.addActionListener(e -> {
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
});
        btnRemove.setBounds(180, 297, 154, 20);
 		panel_1.add(btnRemove);  
 		detailsText.setText(" ");
 		
 		JLabel lblNewLabel_1_1 = new JLabel(r.getString("job")+":");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_1.setBounds(10, 68, 81, 28);
        panel_1.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_3 = new JLabel(r.getString("date1")+":");
        lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_3.setForeground(Color.WHITE);
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_3.setBounds(10, 128, 79, 28);
        panel_1.add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_1_4 = new JLabel(r.getString("date2")+":");
        lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_4.setForeground(Color.WHITE);
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1_4.setBounds(10, 167, 108, 20);
        panel_1.add(lblNewLabel_1_4);
        
        textWorkplace = new JTextField();
        textWorkplace.setBounds(134, 41, 200, 20);
        panel_1.add(textWorkplace);
        textWorkplace.setColumns(10);
        
        textJob = new JTextField();
        textJob.setColumns(10);
        textJob.setBounds(134, 72, 200, 20);
        panel_1.add(textJob);
        
        JLabel lblNewLabel_2 = new JLabel(r.getString("title")+":");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(10, 104, 83, 14);
        panel_1.add(lblNewLabel_2);
        textJobTitle = new JTextField();
        textJobTitle.setColumns(10);
        textJobTitle.setBounds(134, 103, 200, 20);
        panel_1.add(textJobTitle);
        
       
    
       
        
	}
}
        		
        		