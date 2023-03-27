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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import structs.CV;

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
        
        JLabel lblNewLabel = new JLabel("CV Generator");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(215, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnQuit = new JButton("Quit");
        btnQuit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        btnQuit.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnQuit.setBounds(336, 504, 112, 23);
        frame.getContentPane().add(btnQuit);
        
        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		CV cv = new CV();
        		Strengths.main(null, cv);
        		frame.dispose();
        	}
        });
        btnStart.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnStart.setBounds(291, 213, 202, 49);
        frame.getContentPane().add(btnStart);
	}
}
