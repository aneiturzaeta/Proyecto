import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

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
		
		
		String[] columnas = {"Codigo","Nombre", "Descripcion", "Precio", "Existencias", "Talla", "Material", "Estilo"};
	
		
		//se cargan desde la BD. 
		//se cogen si tipoProducto = 0;
		Object[][] datos = { 
				
				{"11", "Jersey", "Azul. Cuello redondo", 20+" €", 10, "L", "Algodon", "Hipster"},
				{"12", "Jersey", "Verde. Cuello redondo", 20+" €", 10, "S", "Algodon", "Hipster"},
				{"13", "Jersey", "Azul. Cuello redondo", 20, 10, "L", "Algodon", "Hipster"},
				{"14", "Jersey", "Azul. Cuello redondo", 20, 10, "L", "Algodon", "Hipster"},
		};	
		
		
			
						
		table = new JTable(datos, columnas);
		table.setBounds(20, 65, 370, 295);
		
		
		table.getColumn("Codigo").setPreferredWidth(25);
		table.getColumn("Existencias").setPreferredWidth(25);
		table.getColumn("Precio").setPreferredWidth(35);
		table.getColumn("Talla").setPreferredWidth(20);
		
		add(table.getTableHeader(), BorderLayout.NORTH);
		add(table, BorderLayout.CENTER);
		
	
		
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
	
	
	  public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	
	  

	
}
