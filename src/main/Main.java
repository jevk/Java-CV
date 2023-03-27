package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private String[] strengths = { "", "", "", "", "" };

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
        
        JLabel lblNewLabel = new JLabel("CV Generator");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		getStrengths();
        	}
        });
        btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnRefresh.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnRefresh);
        
        JButton btnFinish = new JButton("Finish");
        btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnFinish.setBounds(127, 504, 112, 23);
        frame.getContentPane().add(btnFinish);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(28, 71, 354, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JButton btnContacts = new JButton("Henkil\u00F6tiedot");
        btnContacts.setBounds(10, 11, 334, 50);
        panel_1.add(btnContacts);
        
        JButton btnBuffs = new JButton("Vahvuudet");
        btnBuffs.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Strengths.main(null);
        	}
        });
        btnBuffs.setBounds(10, 72, 334, 50);
        panel_1.add(btnBuffs);
	}
}
