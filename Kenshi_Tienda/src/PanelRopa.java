import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;
import java.awt.SystemColor;


import java.awt.Color;


import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
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
	
	private Cliente sesion;
	
	/**
	 * Create the panel.
	 */
	public PanelRopa() {
		
		setBackground(SystemColor.activeCaption);
		
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
		table.setBounds(31, 97, 389, 64);
		
		table.getColumn("Codigo").setPreferredWidth(25);
		table.getColumn("Precio").setPreferredWidth(35);
		table.getColumn("Talla").setPreferredWidth(20);
		setLayout(null);
		
//		JScrollPane tableContainer = new JScrollPane(table);
//
//		this.add(tableContainer, BorderLayout.CENTER);
					
		
//		table.setEnabled(false);

		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);				
		this.add(table);
		
//		this.add(tableContainer);
		
		
		
		textRopa = new JLabel();
		textRopa.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		textRopa.setText("Nuestra ropa");
		textRopa.setForeground(Color.BLACK);
		textRopa.setBounds(148, 22, 181, 20);
		add(textRopa);
		
		Añadir = new JButton("Añadir Producto");
		Añadir.setBounds(0, 187, 450, 49);
		Añadir.setFont(new Font("Century Gothic", Font.BOLD, 16));
		Añadir.setContentAreaFilled(false);
		Añadir.setBorderPainted(false);
		Añadir.addActionListener(this);
		Añadir.setActionCommand("Añadir");
		add(Añadir);
		
//		BSalir.setBounds(100, 103, 150, 30);
	
		
		
	
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	
	table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	
		@Override
	    public void valueChanged(ListSelectionEvent event) {
	        if (table.getSelectedRow() > -1) {
	            	           
	        	//codigo producto
	        	String codigoSeleccion = table.getValueAt(table.getSelectedRow(), 0).toString(); //imprime el codigo del producto seleccionado
	            System.out.println(codigoSeleccion);
	        	
	            //nombreusuario
	            
	            String nombreusuario = sesion.getNombreusuario();
	            
	            
	            //fecha
	            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	            Date fechaDate = Calendar.getInstance().getTime();        
	            String fecha = df.format(fechaDate);
	            
	                        
	            
	            BaseDeDatos.insertarPedido(codigoSeleccion, nombreusuario, fecha);
	            
	            
	        }
	    }
	});
	
	}

	
			
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
				
						
				JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun producto");
				
								
				//if get selected row is not null --> actuar
				
				//getselectedrow (el numero)
				
				//insertar reserva BD de ese numero y con el nombre de usuario
				
				
				break;
			
		}
	}
	
	
	
	public void sesion(Cliente sesion) {
		
		
		this.sesion = sesion;
	
	}
	
	
	  public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
}
