package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Workexperience {

	private JFrame frame;
	private JTextField job;
	private JTextField workplace;
	private JTextField year;
	private String lengt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Workexperience window = new Workexperience();
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
	public Workexperience() {
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
	        
	        JTextArea Yhteenveto = new JTextArea();
	        Yhteenveto.setBounds(10, 11, 334, 415);
	        panel.add(Yhteenveto);
	        
	        JLabel lblNewLabel = new JLabel("Työkokemus");
	        lblNewLabel.setForeground(new Color(255, 255, 255));
	        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
	        lblNewLabel.setBounds(28, 11, 354, 49);
	        frame.getContentPane().add(lblNewLabel);
	        
	        JButton btnReturn = new JButton("Palaa ");
	        btnReturn.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Main.main(null);
					frame.setVisible(false);
	        	}
	        });
	        btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        btnReturn.setBounds(650, 504, 112, 23);
	        frame.getContentPane().add(btnReturn);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBackground(new Color(49, 49, 49));
	        panel_1.setBounds(28, 71, 354, 387);
	        frame.getContentPane().add(panel_1);
	        panel_1.setLayout(null);
	        
	        JLabel lblNewLabel_3 = new JLabel("Kirjoita ammatti");
	        lblNewLabel_3.setForeground(Color.WHITE);
	        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblNewLabel_3.setBounds(10, 188, 334, 37);
	        panel_1.add(lblNewLabel_3);
	        
	        job = new JTextField();
	        job.setBounds(10, 236, 334, 37);
	        panel_1.add(job);
	        job.setColumns(10);
	        
	        JLabel lblNewLabel_4 = new JLabel("Kirjoita yritys");
	        lblNewLabel_4.setForeground(Color.WHITE);
	        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblNewLabel_4.setBounds(10, 285, 334, 37);
	        panel_1.add(lblNewLabel_4);
	        
	        workplace = new JTextField();
	        workplace.setColumns(10);
	        workplace.setBounds(10, 339, 334, 37);
	        panel_1.add(workplace);
	        
	        JLabel lblNewLabel_1 = new JLabel("työkokemus vuosina");
	        lblNewLabel_1.setForeground(Color.WHITE);
	        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblNewLabel_1.setBounds(10, 11, 191, 37);
	        panel_1.add(lblNewLabel_1);
	        
	        year = new JTextField();
	        year.setBounds(211, 11, 133, 37);
	        panel_1.add(year);
	        year.setColumns(10);
	        
	        JLabel lblNewLabel_1_1 = new JLabel("työkokemus kuukaudet");
	        lblNewLabel_1_1.setForeground(Color.WHITE);
	        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblNewLabel_1_1.setBounds(10, 76, 334, 37);
	        panel_1.add(lblNewLabel_1_1);
	        
	        JComboBox month = new JComboBox();
	        month.setModel(new DefaultComboBoxModel(new String[] {"Valitse kuukausien määrä", "1 Kuukausi", "2 Kuukautta", "3 Kuukautta", "4 Kuukautta", "5 Kuukautta", "6 Kuukautta", "7 Kuukautta", "8 Kuukautta", "9 Kuukautta", "10 Kuukautta", "11 Kuukautta", "12 Kuukautta"}));
	        month.setBounds(10, 140, 324, 37);
	        panel_1.add(month);
	        
	        JButton btnTulosta = new JButton("Tulosta työkokemus");
	        btnTulosta.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Yhteenveto.append("Ammatti: "
	        				+job.getText()
	        				+"\n Yritys: "
	        				+workplace.getText()
	        				+"\nVuosien ja kuukausien määrä: "
	        				+year.getText()+" vuotta ja "+month.getSelectedItem());
	        	}
	        });
	        btnTulosta.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        btnTulosta.setBounds(262, 504, 158, 23);
	        frame.getContentPane().add(btnTulosta);
	        
	        JButton btnFinish = new JButton("Valmis ja tallenna");
	        btnFinish.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {

	        	}
	        });
	        btnFinish.setBounds(43, 505, 149, 23);
	        frame.getContentPane().add(btnFinish);
	        
	        JButton btnNewButton = new JButton("Tyhjennä");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		job.setText("");
	        		workplace.setText("");
	        		month.setSelectedItem("Valitse kuukausien määrä");
	        		year.setText("");
	        		Yhteenveto.setText("");
	        	}
	        });
	        btnNewButton.setBounds(480, 505, 120, 23);
	        frame.getContentPane().add(btnNewButton);
	}
}
