package main;

import java.awt.Color; 
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import structs.Language;

import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Languages {

	private JFrame frame;
	private Language[] langs = new Language[10];

	
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
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
					Languages window = new Languages();
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
	public Languages() {
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
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 11, 334, 415);
        panel.add(tabbedPane);
        
        JScrollPane scrollPane = new JScrollPane();
        tabbedPane.addTab("CV", null, scrollPane, null);
        
        JTextArea txtCV = new JTextArea();
        txtCV.setEditable(false);
        scrollPane.setViewportView(txtCV);
        txtCV.setFont(new Font("Monospaced", Font.BOLD, 15));
        
        JLabel lblNewLabel = new JLabel("Language Skills");
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
        
        JLabel lblNewLabel_1 = new JLabel("Select a language:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(10, 10, 150, 30);
        panel_1.add(lblNewLabel_1);
        
        JComboBox<Object> cmbxLang = new JComboBox<Object>();
        cmbxLang.setForeground(new Color(255, 255, 255));
        cmbxLang.setModel(new DefaultComboBoxModel<Object>(new String[] {"Finnish", "English", "Spanish", "German", "Japanese", "Chinese", "Swedish", "Norwegian", "Danish"}));
        cmbxLang.setBackground(new Color(86, 86, 86));
        cmbxLang.setFont(new Font("Tahoma", Font.BOLD, 15));
        cmbxLang.setBounds(170, 10, 174, 30);
        panel_1.add(cmbxLang);
        
        JRadioButton rdbtnBegSpeech = new JRadioButton("Beginner");
        rdbtnBegSpeech.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnBegSpeech.setForeground(new Color(255, 255, 255));
        rdbtnBegSpeech.setBackground(new Color(86, 86, 86));
        rdbtnBegSpeech.setBounds(170, 97, 174, 21);
        panel_1.add(rdbtnBegSpeech);
        
        JRadioButton rdbtnInterSpeech = new JRadioButton("Intermediate");
        rdbtnInterSpeech.setForeground(Color.WHITE);
        rdbtnInterSpeech.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnInterSpeech.setBackground(new Color(86, 86, 86));
        rdbtnInterSpeech.setBounds(170, 128, 174, 21);
        panel_1.add(rdbtnInterSpeech);
        
        JRadioButton rdbtnAdSpeech = new JRadioButton("Advanced");
        rdbtnAdSpeech.setForeground(Color.WHITE);
        rdbtnAdSpeech.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnAdSpeech.setBackground(new Color(86, 86, 86));
        rdbtnAdSpeech.setBounds(170, 160, 174, 21);
        panel_1.add(rdbtnAdSpeech);
        
        JRadioButton rdbtnNatSpeech = new JRadioButton("Native");
        rdbtnNatSpeech.setForeground(Color.WHITE);
        rdbtnNatSpeech.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnNatSpeech.setBackground(new Color(86, 86, 86));
        rdbtnNatSpeech.setBounds(170, 193, 174, 21);
        panel_1.add(rdbtnNatSpeech);
        
        JRadioButton rdbtnBegWrite = new JRadioButton("Beginner");
        rdbtnBegWrite.setForeground(Color.WHITE);
        rdbtnBegWrite.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnBegWrite.setBackground(new Color(86, 86, 86));
        rdbtnBegWrite.setBounds(9, 264, 174, 21);
        panel_1.add(rdbtnBegWrite);
        
        JRadioButton rdbtnInterWrite = new JRadioButton("Intermediate");
        rdbtnInterWrite.setForeground(Color.WHITE);
        rdbtnInterWrite.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnInterWrite.setBackground(new Color(86, 86, 86));
        rdbtnInterWrite.setBounds(10, 294, 174, 21);
        panel_1.add(rdbtnInterWrite);
        
        JRadioButton rdbtnAdWrite = new JRadioButton("Advanced");
        rdbtnAdWrite.setForeground(Color.WHITE);
        rdbtnAdWrite.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnAdWrite.setBackground(new Color(86, 86, 86));
        rdbtnAdWrite.setBounds(10, 323, 174, 21);
        panel_1.add(rdbtnAdWrite);
        
        JRadioButton rdbtnNatWrite = new JRadioButton("Native");
        rdbtnNatWrite.setForeground(Color.WHITE);
        rdbtnNatWrite.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnNatWrite.setBackground(new Color(86, 86, 86));
        rdbtnNatWrite.setBounds(10, 353, 174, 21);
        panel_1.add(rdbtnNatWrite);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Select your speech skill level:");
        lblNewLabel_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_1_1_1.setBounds(10, 50, 334, 30);
        panel_1.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Select your writing skills:");
        lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_1_1_1_1.setBounds(10, 228, 334, 30);
        panel_1.add(lblNewLabel_1_1_1_1);
        
        ButtonGroup Speech = new ButtonGroup();
        Speech.add(rdbtnNatSpeech);
        Speech.add(rdbtnAdSpeech);
        Speech.add(rdbtnInterSpeech);
        Speech.add(rdbtnBegSpeech);
        
        ButtonGroup Write = new ButtonGroup();
        Write.add(rdbtnNatWrite);
        Write.add(rdbtnAdWrite);
        Write.add(rdbtnInterWrite);
        Write.add(rdbtnBegWrite);
        
        JButton btnAdd = new JButton("Add an entry");
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (!Write.isSelected(null) && !Speech.isSelected(null)) {
        			txtCV.append(cmbxLang.getSelectedItem() + ": \nWriting: " + getSelectedButtonText(Write) + "\nSpeech: " + getSelectedButtonText(Speech) + "\n");
        			Language lang = new Language(
        					cmbxLang.getSelectedItem().toString(), 
        					getSelectedButtonText(Write), 
        					getSelectedButtonText(Speech)
        			);
        			for (int i = 0; i < langs.length; i++) {
        				System.out.println(i);
        				if (langs[i] == null) {
        					langs[i] = lang;
        					break;
        				}
        			}
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "You also must select both skill levels to put to the CV");
        		}
        	}		
        });
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setBackground(new Color(128, 128, 128));
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAdd.setBounds(190, 354, 154, 23);
        panel_1.add(btnAdd);
        
        JButton btnNewButton = new JButton("Clear 3 last lines");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int end;
				try {
					end = txtCV.getLineEndOffset(2);
					txtCV.replaceRange("", 0, end);
				} catch (BadLocationException e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
        	}
        });
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(128, 128, 128));
        btnNewButton.setBounds(190, 324, 154, 20);
        panel_1.add(btnNewButton);
    }
}
