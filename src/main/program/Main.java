package program;

import structs.CV;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.util.ResourceBundle.getBundle;

public class Main {
	// Initialize variables
	private JFrame frame;
	private String language = "fi";
	private Locale l;
	private ResourceBundle r;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Main window = new Main();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Set locales and resource bundles
    	l = new Locale(language);
    	r = getBundle("resources/Bundle_"+language, l);

		// Create frame
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(39, 39, 39));
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

		// Title label
        JLabel lblNewLabel = new JLabel(r.getString("cvGen"));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Ebrima", Font.BOLD, 45));
        lblNewLabel.setBounds(186, 11, 412, 76);
        frame.getContentPane().add(lblNewLabel);

		// Create quit button
        JButton btnQuit = new JButton(r.getString("leave"));
        btnQuit.setForeground(new Color(255, 255, 255));
        btnQuit.setBackground(new Color(128, 128, 128));
        btnQuit.addActionListener(e -> System.exit(0));
        btnQuit.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnQuit.setBounds(291, 292, 202, 49);
		// Exit program when button is pressed
		btnQuit.addActionListener(e -> System.exit(0));
        frame.getContentPane().add(btnQuit);

		// Create start button
        JButton btnStart = new JButton(r.getString("start"));
        btnStart.setForeground(new Color(255, 255, 255));
        btnStart.setBackground(new Color(128, 128, 128));
        btnStart.addActionListener(e -> {
			// Create new CV object and start PersonalDetails
			CV cv = new CV();
			cv.LOCALE = language;
			PersonalDetails.main(cv);
			frame.dispose();
		});
        btnStart.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnStart.setBounds(291, 213, 202, 49);
        frame.getContentPane().add(btnStart);

		// Create language picker
        JComboBox<String> pickLang = new JComboBox<>();
        pickLang.setModel(new DefaultComboBoxModel<>(new String[] {"suomi", "English"}));
        pickLang.setBounds(291, 381, 202, 31);
        pickLang.addActionListener(e -> {
			// Change language when language is picked
			switch(pickLang.getSelectedIndex()) {
				case 0: language = "fi"; break;
				case 1: language = "en"; break;
			}

			// Update locales and resource bundles
			l = new Locale(language);
			r = getBundle("resources/Bundle_"+language, l);

			// Update labels and buttons
			lblNewLabel.setText(r.getString("cvGen"));
			btnQuit.setText(r.getString("leave"));
			btnStart.setText(r.getString("start"));

		});

		// Add language picker to frame
        frame.getContentPane().add(pickLang);
	}
}
