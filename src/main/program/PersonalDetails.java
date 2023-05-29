package program;

import structs.CV;
import structs.Details;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class PersonalDetails extends Information {
	private final CV cv;
	private JFrame frame;
	private JTextField txtNimi;
	private JTextField txtKotiosoite;
	private JTextField txtSahkoposti;
	private JTextField txtPuhnumero;
	private final Details details = new Details();
	private JTextField txtKaupunki;
	private JTextField txtPostinumero;
	private JTextField textOther;
	
	private static String lang;
    private ResourceBundle r;
	

	/**
	 * Launch the application.
	 */
	public static void main(CV curriculumVitae) {
		lang = curriculumVitae.LOCALE;
		EventQueue.invokeLater(() -> {
            try {
                PersonalDetails window = new PersonalDetails(curriculumVitae);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	/**
	 * Create the application.
	 */
	public PersonalDetails(CV curriculumVitae) {
		cv = curriculumVitae;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
    private void initialize() {
        Locale l = new Locale(lang);
    	r = ResourceBundle.getBundle("resources/Bundle_"+lang, l);
    	
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(39, 39, 39));
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(49, 49, 49));
        panel.setBounds(378, 21, 398, 437);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel(r.getString("details"));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Ebrima", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnNext = new JButton(r.getString("next"));
        btnNext.setForeground(new Color(255, 255, 255));
        btnNext.setBackground(new Color(128, 128, 128));
        btnNext.addActionListener(e -> {
            Strengths.main(cv);
            frame.dispose();
        });
        btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNext.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnNext);
        
        JButton btnFinish = new JButton(r.getString("back"));
        btnFinish.addActionListener(e -> {
            cv.details = details;
            Referees.main(cv);
            frame.dispose();
        });
        btnFinish.setForeground(new Color(255, 255, 255));
        btnFinish.setBackground(new Color(128, 128, 128));
        btnFinish.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnFinish.setBounds(127, 504, 112, 23);
        frame.getContentPane().add(btnFinish);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(10, 71, 358, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setForeground(new Color(255, 255, 255));
        tabbedPane.setBackground(new Color(128, 128, 128));
        tabbedPane.setBounds(10, 11, 378, 415);
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
        itText.setText(r.getString("skills") + ":\n");
        
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

        tabbedPane.setSelectedIndex(0);
        
        JLabel lblNewLabel_1 = new JLabel(r.getString("name"));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_1.setBounds(10, 31, 49, 14);
        panel_1.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel(r.getString("address"));
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setBackground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(10, 62, 83, 14);
        panel_1.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel(r.getString("email"));
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_3.setBounds(10, 95, 131, 14);
        panel_1.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel(r.getString("phone"));
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4.setBounds(10, 126, 105, 14);
        panel_1.add(lblNewLabel_4);
        
        txtNimi = new JTextField();
        txtNimi.setBounds(146, 30, 202, 20);
        panel_1.add(txtNimi);
        txtNimi.setColumns(10);
        
        txtKotiosoite = new JTextField();
        txtKotiosoite.setBounds(146, 61, 202, 20);
        panel_1.add(txtKotiosoite);
        txtKotiosoite.setColumns(10);
        
        txtSahkoposti = new JTextField();
        txtSahkoposti.setBounds(146, 94, 202, 20);
        panel_1.add(txtSahkoposti);
        txtSahkoposti.setColumns(10);
        
        txtPuhnumero = new JTextField();
        txtPuhnumero.setBounds(146, 125, 202, 20);
        panel_1.add(txtPuhnumero);
        txtPuhnumero.setColumns(10);
        
        txtKaupunki = new JTextField();
        txtKaupunki.setBounds(146, 156, 202, 20);
        panel_1.add(txtKaupunki);
        txtKaupunki.setColumns(10);
        
        txtPostinumero = new JTextField();
        txtPostinumero.setBounds(146, 187, 202, 20);
        panel_1.add(txtPostinumero);
        txtPostinumero.setColumns(10);
        
        textOther = new JTextField();
        textOther.setColumns(10);
        textOther.setBounds(146, 218, 202, 20);
        panel_1.add(textOther);
        
        JButton btnNewButton = new JButton(r.getString("setInfo"));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(128, 128, 128));
        btnNewButton.addActionListener(e -> {
            details.address = txtKotiosoite.getText();
            details.email = txtSahkoposti.getText();
            details.name = txtNimi.getText();
            details.phone = txtPuhnumero.getText();
            details.town = txtKaupunki.getText();
            details.zip = txtPostinumero.getText();

            if (textOther.getText().length() > 0) {
                details.other = textOther.getText();
            }

            cv.details = details;
            getCV(cv, detailsText, strengthsText, degreeText, courseText, expText, itText, langsText, hobbyText, positionText, refereeText);
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnNewButton.setBounds(96, 264, 171, 20);
        panel_1.add(btnNewButton);
        
        JLabel lblNewLabel_5 = new JLabel(r.getString("town"));
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setForeground(new Color(255, 255, 255));
        lblNewLabel_5.setBounds(10, 156, 83, 17);
        panel_1.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel(r.getString("zip"));
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setBackground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_6.setBounds(10, 186, 105, 19);
        panel_1.add(lblNewLabel_6);
        
        JLabel lblNewLabel_6_1 = new JLabel(r.getString("other"));
        lblNewLabel_6_1.setForeground(Color.WHITE);
        lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_6_1.setBackground(Color.WHITE);
        lblNewLabel_6_1.setBounds(10, 219, 105, 19);
        panel_1.add(lblNewLabel_6_1);
        
        JLabel lblNewLabel_7 = new JLabel("Img selected");
        lblNewLabel_7.setForeground(new Color(255, 255, 255));
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel_7.setBounds(32, 329, 81, 22);
        panel_1.add(lblNewLabel_7);
        
        JLabel lblImgChosen = new JLabel("");
        lblImgChosen.setForeground(new Color(255, 255, 255));
        lblImgChosen.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblImgChosen.setBounds(32, 351, 316, 22);
        panel_1.add(lblImgChosen);
        
        JLabel img = new JLabel("");
        img.setBounds(137, 295, 211, 81);
        panel_1.add(img);
        
        JButton btnNewButton_1 = new JButton(r.getString("browse"));
        btnNewButton_1.addActionListener(e -> {
            JFileChooser jImgPick = new JFileChooser();
            String path;

            jImgPick.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter(r.getString("pngFiles"), "png");
            jImgPick.addChoosableFileFilter(filter);
            jImgPick.showOpenDialog(null);

            path = jImgPick.getSelectedFile().getAbsolutePath();
            cv.image = path;

            BufferedImage bi = null;
            try {
                bi = ImageIO.read(new File(path));
            } catch(IOException err) {
                err.printStackTrace();
            }
            assert bi != null;
            Image dimg = bi.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(dimg);
            img.setIcon(ii);
        });
        btnNewButton_1.setBounds(22, 295, 105, 23);
        panel_1.add(btnNewButton_1);
    }
}
