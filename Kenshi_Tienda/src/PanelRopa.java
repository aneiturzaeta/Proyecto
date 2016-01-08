import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;


public class PanelRopa extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private JLabel textRopa;
	private JButton Añadir;
	
	/**
	 * Create the panel.
	 */
	public PanelRopa() {
		
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		
		String[] columnas = {"Codigo","Nombre", "Descripcion", "Precio",  "Talla", "Material", "Estilo"};
	
		
		//se cargan desde la BD. 
		//se cogen si tipoProducto = 0;
		Object[][] datos = { 
				
				{"01", "Jersey", "Azul. Cuello redondo", 20+" €",  "L", "Algodon", "Hipster"},
				{"02", "Jersey", "Verde. Cuello redondo", 20+" €",  "S", "Algodon", "Hipster"},
				{"03", "Jersey", "Rojo. Cuello redondo", 20+" €",  "L", "Algodon", "Hipster"},
				{"04", "Jersey", "Azul. Cuello redondo", 20+" €",  "L", "Algodon", "Hipster"},
		};	
		
		
			
						
		table = new JTable(datos, columnas);
		table.setBounds(20, 65, 420, 64);
		
		//JScrollPane tableContainer = new JScrollPane(table);
		//this.add(tableContainer, BorderLayout.CENTER);
		
		table.getColumn("Codigo").setPreferredWidth(25);
		table.getColumn("Precio").setPreferredWidth(35);
		table.getColumn("Talla").setPreferredWidth(20);
		
		
//		table.setEnabled(false);

		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);				
		this.add(table);
		
	
		
		textRopa = new JLabel();
		textRopa.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		textRopa.setText("Nuestra ropa");
		textRopa.setForeground(Color.BLACK);
		textRopa.setBounds(148, 22, 181, 20);
		add(textRopa);
		
		Añadir = new JButton("A\u00F1adir Producto");
		Añadir.setBounds(169, 160, 110, 23);
		Añadir.addActionListener(this);
		Añadir.setActionCommand("Añadir");
		add(Añadir);
	
		
		
	}
//	table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//	
//		@Override
//	    public void valueChanged(ListSelectionEvent event) {
//	        if (table.getSelectedRow() > -1) {
//	            // print first column value from selected row
//	            System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
//	        }
//	    }
//	});

	
			
//	table.addMouseListener(new MouseAdapter() {
//		  public void mouseClicked(MouseEvent e) {
//		    if (e.getClickCount() == 2) {
//		      JTable target = (JTable)e.getSource();
//		      int row = target.getSelectedRow();
//		      
//		      añadir(row, "fila");
//		      
//		      //int column = target.getSelectedColumn();
//		      // do some action if appropriate column
//		    }
//		  
//		  }
//	});
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	
		switch (e.getActionCommand()) {
		
			case "Añadir":
				
				añadir(0, "añadir");
				
				JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun producto");
				
								
				//if get selected row is not null --> actuar
				
				//getselectedrow (el numero)
				
				//insertar reserva BD de ese numero y con el nombre de usuario
				
				
				break;
			
		}
	}
	
	
	
	public void añadir (int fila, String etiqueta){
		
		int filaSele;
		boolean añadir = false;
		
		switch (etiqueta){
		
			case "Añadir": añadir = true; break;
						
			case "Fila": filaSele = fila; break;
		
		}
		
		
		Date fecha = new Date();
				
		Random r= new Random(33);
				
		int numeroPedido = r.nextInt(10000);
		
		int codigo = 0; //el codigo del producto;
		
		String usuario="5"; //el nombre de usuario
		
//		Pedido nuevo = new Pedido(numeroPedido, fecha, codigo, usuario);
		
	
		
//		llamar a base de datos
//		insertarReserva(nuevo);
		
		
	}
	
	
	
	
	
	  public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
}
