package main;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;

public class Henkilotiedot {
	private JFrame frame;
	private JTextField txtNimi;
	private JTextField txtKotiosoite;
	private JTextField txtSahkoposti;
	private JTextField txtPuhnumero;
	
	/**
     * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
     */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Henkilotiedot window = new Henkilotiedot();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public Henkilotiedot() {
		initialize();
	}
	
    private void initialize() {
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(new Color(39, 39, 39));
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(408, 21, 354, 437);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JList list = new JList();
        list.setBackground(new Color(221, 218, 155));
        list.setBounds(10, 11, 334, 415);
        panel.add(list);
        
        /*JLabel lblNewLabel = new JLabel("Section title");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);*/
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(28, 71, 354, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Nimi");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBackground(new Color(255, 255, 255));
        lblNewLabel_2.setBounds(10, 23, 75, 30);
        panel_1.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Kotiosoite");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_3.setBounds(10, 58, 107, 17);
        panel_1.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Sähköpostiosoite");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_4.setBounds(10, 86, 129, 17);
        panel_1.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Puhelinnumero");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_5.setBounds(10, 114, 107, 17);
        panel_1.add(lblNewLabel_5);
        
        txtNimi = new JTextField();
        txtNimi.setBounds(150, 30, 194, 20);
        panel_1.add(txtNimi);
        txtNimi.setColumns(10);
        
        txtKotiosoite = new JTextField();
        txtKotiosoite.setBounds(150, 58, 194, 20);
        panel_1.add(txtKotiosoite);
        txtKotiosoite.setColumns(10);
        
        txtSahkoposti = new JTextField();
        txtSahkoposti.setBounds(149, 86, 195, 20);
        panel_1.add(txtSahkoposti);
        txtSahkoposti.setColumns(10);
        
        txtPuhnumero = new JTextField();
        txtPuhnumero.setBounds(150, 114, 194, 20);
        panel_1.add(txtPuhnumero);
        txtPuhnumero.setColumns(10);
        
        JButton btnNewButton = new JButton("Lähetä tiedot");
        btnNewButton.setBounds(20, 190, 119, 23);
        panel_1.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("Henkilötiedot");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 25));
        lblNewLabel_1.setBounds(35, 21, 330, 39);
        frame.getContentPane().add(lblNewLabel_1);
    }
}
