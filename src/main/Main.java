package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import structs.CV;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Main {

	private JFrame frame;
	private String[] strengths = { "", "", "", "", "" };
	private String language = "fi";
	private Locale l;
	private ResourceBundle r;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void getStrengths() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("strengths.txt"));
			String line = reader.readLine();
			
			int i = 0;
			while (line != null) {
				line = reader.readLine();
				
				strengths[i] = line;
				
				i++;
			}
			
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
    	l = new Locale(language);
    	r = ResourceBundle.getBundle("locales/Bundle_"+language, l);
    	
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
        btnQuit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        btnQuit.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnQuit.setBounds(291, 292, 202, 49);
        frame.getContentPane().add(btnQuit);
        
        JButton btnStart = new JButton(r.getString("start"));
        btnStart.setForeground(new Color(255, 255, 255));
        btnStart.setBackground(new Color(128, 128, 128));
        btnStart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CV cv = new CV();
        		cv.LOCALE = language;
        		PersonalDetails.main(null, cv);
        		frame.dispose();
        	}
        });
        btnStart.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnStart.setBounds(291, 213, 202, 49);
        frame.getContentPane().add(btnStart);
        
        JComboBox pickLang = new JComboBox();
        pickLang.setModel(new DefaultComboBoxModel(new String[] {"Suomi", "English"}));
        pickLang.setBounds(291, 381, 202, 31);
        pickLang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				switch(pickLang.getSelectedIndex()) {
					case 0: language = "fi"; break;
					case 1: language = "en"; break;
				}
		    	l = new Locale(language);
		    	r = ResourceBundle.getBundle("locales/Bundle_"+language, l);
		    	
		    	lblNewLabel.setText(r.getString("cvGen"));
		    	btnQuit.setText(r.getString("leave"));
		    	btnStart.setText(r.getString("start"));
				
			}
		});
        frame.getContentPane().add(pickLang);
	}
}
