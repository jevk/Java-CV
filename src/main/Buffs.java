package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class Buffs {

	private JFrame frame;
	private JTextField textField;
	private String[] skills;
	private String getSelectedButton(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getName();
            }
        }

        return null;
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buffs window = new Buffs();
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
	public Buffs() {
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
        
        JLabel lblSkill1 = new JLabel("-");
        lblSkill1.setForeground(Color.WHITE);
        lblSkill1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSkill1.setBounds(10, 11, 223, 49);
        panel.add(lblSkill1);
        
        JLabel lblSkill2 = new JLabel("-");
        lblSkill2.setForeground(Color.WHITE);
        lblSkill2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSkill2.setBounds(10, 71, 223, 49);
        panel.add(lblSkill2);
        
        JLabel lblSkill3 = new JLabel("-");
        lblSkill3.setForeground(Color.WHITE);
        lblSkill3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSkill3.setBounds(10, 131, 223, 49);
        panel.add(lblSkill3);
        
        JLabel lblSkill4 = new JLabel("-");
        lblSkill4.setForeground(Color.WHITE);
        lblSkill4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSkill4.setBounds(10, 191, 223, 49);
        panel.add(lblSkill4);
        
        JLabel lblSkill5 = new JLabel("-");
        lblSkill5.setForeground(Color.WHITE);
        lblSkill5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSkill5.setBounds(10, 251, 223, 49);
        panel.add(lblSkill5);
        
        ButtonGroup btnGrp = new ButtonGroup();
        
        JRadioButton rdbtnNewRadioButton_0 = new JRadioButton("Select");
        rdbtnNewRadioButton_0.setForeground(Color.WHITE);
        rdbtnNewRadioButton_0.setBackground(new Color(49, 49, 49));
        rdbtnNewRadioButton_0.setBounds(239, 28, 109, 23);
        rdbtnNewRadioButton_0.setName("0");
        panel.add(rdbtnNewRadioButton_0);
        btnGrp.add(rdbtnNewRadioButton_0);
        
        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Select");
        rdbtnNewRadioButton_1.setForeground(Color.WHITE);
        rdbtnNewRadioButton_1.setBackground(new Color(49, 49, 49));
        rdbtnNewRadioButton_1.setBounds(239, 88, 109, 23);
        rdbtnNewRadioButton_1.setName("1");
        panel.add(rdbtnNewRadioButton_1);
        btnGrp.add(rdbtnNewRadioButton_1);
        
        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Select");
        rdbtnNewRadioButton_2.setForeground(Color.WHITE);
        rdbtnNewRadioButton_2.setBackground(new Color(49, 49, 49));
        rdbtnNewRadioButton_2.setBounds(239, 148, 109, 23);
        rdbtnNewRadioButton_2.setName("2");
        panel.add(rdbtnNewRadioButton_2);
        btnGrp.add(rdbtnNewRadioButton_2);
        
        JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Select");
        rdbtnNewRadioButton_3.setForeground(Color.WHITE);
        rdbtnNewRadioButton_3.setBackground(new Color(49, 49, 49));
        rdbtnNewRadioButton_3.setBounds(239, 208, 109, 23);
        rdbtnNewRadioButton_3.setName("3");
        panel.add(rdbtnNewRadioButton_3);
        btnGrp.add(rdbtnNewRadioButton_3);
        
        JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Select");
        rdbtnNewRadioButton_4.setForeground(Color.WHITE);
        rdbtnNewRadioButton_4.setBackground(new Color(49, 49, 49));
        rdbtnNewRadioButton_4.setBounds(239, 268, 109, 23);
        rdbtnNewRadioButton_4.setName("4");
        panel.add(rdbtnNewRadioButton_4);
        btnGrp.add(rdbtnNewRadioButton_4);
        
        JLabel lblNewLabel = new JLabel("Section title");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblNewLabel.setBounds(28, 11, 354, 49);
        frame.getContentPane().add(lblNewLabel);
        
        JButton btnReturn = new JButton("Return");
        btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnReturn.setBounds(545, 504, 112, 23);
        frame.getContentPane().add(btnReturn);
        
        JButton btnFinish = new JButton("Finish");
        btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnFinish.setBounds(127, 504, 112, 23);
        frame.getContentPane().add(btnFinish);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(49, 49, 49));
        panel_1.setBounds(28, 71, 354, 387);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JButton btnSet = new JButton("Set");
        btnSet.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (getSelectedButton(btnGrp) == null) {
        			rdbtnNewRadioButton_0.setSelected(true);
        		}
        		String text  = textField.getText();
        		int selectedButton = Integer.parseInt(getSelectedButton(btnGrp));
        		switch (selectedButton) {
        		case 0:
        			lblSkill1.setText("- " + text);
        			break;
        		case 1:
        			lblSkill2.setText("- " + text);
        			break;
        		case 2:
        			lblSkill3.setText("- " + text);
        			break;
        		case 3:
        			lblSkill4.setText("- " + text);
        			break;
        		case 4:
        			lblSkill5.setText("- " + text);
        			break;
        		}
        		skills[selectedButton] = text;
        	}
        });
        btnSet.setBounds(100, 328, 154, 48);
        panel_1.add(btnSet);
        
        textField = new JTextField();
        textField.setBounds(35, 218, 284, 29);
        panel_1.add(textField);
        textField.setColumns(10);
	}
}
