package program;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.SwingConstants;

import structs.CV;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import static java.util.ResourceBundle.getBundle;

public class Main {

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
    	l = new Locale(language);
    	r = getBundle("Bundle_"+language, l);

        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(39, 39, 39));
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel(r.getString("cvGen"));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Ebrima", Font.BOLD, 45));
        lblNewLabel.setBounds(186, 11, 412, 76);
        frame.getContentPane().add(lblNewLabel);

        JButton btnQuit = new JButton(r.getString("leave"));
        btnQuit.setForeground(new Color(255, 255, 255));
        btnQuit.setBackground(new Color(128, 128, 128));
        btnQuit.addActionListener(e -> System.exit(0));
        btnQuit.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnQuit.setBounds(291, 292, 202, 49);
        frame.getContentPane().add(btnQuit);

        JButton btnStart = new JButton(r.getString("start"));
        btnStart.setForeground(new Color(255, 255, 255));
        btnStart.setBackground(new Color(128, 128, 128));
        btnStart.addActionListener(e -> {
			CV cv = new CV();
			cv.LOCALE = language;
			PersonalDetails.main(null, cv);
			frame.dispose();
		});
        btnStart.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnStart.setBounds(291, 213, 202, 49);
        frame.getContentPane().add(btnStart);

        JComboBox<String> pickLang = new JComboBox<>();
        pickLang.setModel(new DefaultComboBoxModel<>(new String[] {"suomi", "English", "Svenska", "Eesti", "Español"}));
        pickLang.setBounds(291, 381, 202, 31);
        pickLang.addActionListener(e -> {
			switch(pickLang.getSelectedIndex()) {
				case 0: language = "fi"; break;
				case 1: language = "en"; break;
				case 2: language = "se"; break;
				case 3: language = "ee"; break;
				case 4: language = "es"; break;
			}
			l = new Locale(language);
			r = getBundle("Bundle_"+language, l);

			lblNewLabel.setText(r.getString("cvGen"));
			btnQuit.setText(r.getString("leave"));
			btnStart.setText(r.getString("start"));

		});
        frame.getContentPane().add(pickLang);
	}
}
