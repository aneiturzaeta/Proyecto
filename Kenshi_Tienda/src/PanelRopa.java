import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.SystemColor;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelRopa extends JPanel implements ActionListener {
	
	private JTable table;
	private JLabel textRopa;
	
	/**
	 * Create the panel.
	 */
	public PanelRopa() {
		
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		table = new JTable();
		table.setBounds(35, 65, 298, 295);
		add(table);
		
		textRopa = new JLabel();
		textRopa.setFont(new Font("Century Gothic", Font.BOLD, 15));
		textRopa.setText("Nuestra ropa");
		textRopa.setOpaque(false);
		//textRopa.setForeground(new Color(0, 0, 0));
		textRopa.setForeground(Color.BLACK);
		textRopa.setBounds(121, 22, 107, 20);
		add(textRopa);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
