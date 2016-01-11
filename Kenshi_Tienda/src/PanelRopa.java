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
	
	  String codigoSeleccion;
      String nombreusuario;
      String fecha;
      
      
      int seleccionado= 0;
	
	/**
	 * Create the panel.
	 */
	public PanelRopa() {
		
		setBackground(SystemColor.activeCaption);
		
		String[] columnas = {"Codigo","Nombre", "Descripcion", "Precio",  "Talla", "Material", "Estilo"};
	
		
		//se cargan desde la BD. 
		//se cogen si tipoProducto = 0;
		Object[][] datos = { 
				
				{"01", "Jersey", "Azul. Cuello redondo", 20+" €",  "L", "Terciopelo", "Hipster"},
				{"02", "Jersey", "Verde. Cuello redondo", 20+" €",  "S", "Lino", "Básico"},
				{"03", "Jersey", "Rojo. Cuello de pico", 20+" €",  "L", "Algodon", "Hipster"},
				{"04", "Jersey", "Rojo. Cuello de pico", 20+" €",  "L", "Algodon", "Hipster"},
				{"05", "Jersey", "Lentejuelas. Corto", 20+" €",  "S", "Algodon", "Gala"},
				{"06", "Jersey", "Lentejuelas. Corto", 20+" €",  "M", "Algodon", "Gala"},
				{"07", "Jersey", "Lentejuelas. Corto", 20+" €",  "L", "Algodon", "Gala"},
				{"08", "Camiseta", "Dibujo Floral. Coral", 15+" €",  "U", "Algodon", "Hipster"},
				{"09", "Camiseta", "Dibujo Floral. Azulado", 15+" €",  "U", "Algodon", "Hipster"},
				{"10", "Camiseta", "Crop Top. Negro", 8+" €",  "M", "Algodon", "Básico"},
				{"11", "Camiseta", "Crop Top. Azul", 8+" €",  "M", "Algodon", "Básico"},
		};	
		
		
			
						
		table = new JTable(datos, columnas);
		
		
		table.getColumn("Codigo").setPreferredWidth(50);
		table.getColumn("Nombre").setPreferredWidth(70);
		table.getColumn("Descripcion").setPreferredWidth(160);
		table.getColumn("Precio").setPreferredWidth(50);
		table.getColumn("Talla").setPreferredWidth(50);
		table.getColumn("Material").setPreferredWidth(90);
		table.getColumn("Estilo").setPreferredWidth(60);
		setLayout(null);
		
		
		JScrollPane scrollp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollp.setSize(395, 200);
		scrollp.setLocation(22, 101);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		
		this.add(scrollp, BorderLayout.WEST);
					
		
		
		textRopa = new JLabel();
		textRopa.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
		textRopa.setText("Nuestra ropa");
		textRopa.setForeground(Color.BLACK);
		textRopa.setBounds(148, 50, 181, 20);
		add(textRopa);
		
		Añadir = new JButton("Añadir Producto");
		Añadir.setBounds(106, 330, 200, 23);
		Añadir.setFont(new Font("Century Gothic", Font.BOLD, 16));
		Añadir.setContentAreaFilled(false);
		Añadir.setBorderPainted(false);
		Añadir.addActionListener(this);
		Añadir.setActionCommand("Añadir");
		add(Añadir);
		
//		BSalir.setBounds(100, 103, 150, 30);
	
		
		
	
//	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
			
//	table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	
		
//	    public void valueChanged(ListSelectionEvent event) {
//	        if (table.getSelectedRow() > -1) {
//	            	           
//	        	//codigo producto
//	        	codigoSeleccion = table.getValueAt(table.getSelectedRow(), 0).toString(); //imprime el codigo del producto seleccionado
//	            System.out.println(codigoSeleccion);
//	        	
//	            //nombreusuario
//	            
//	            nombreusuario = sesion.getNombreusuario();
//	            
//	            
//	            //fecha
//	            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//	            Date fechaDate = Calendar.getInstance().getTime();        
//	            fecha = df.format(fechaDate);
//	            
//	            	 
//	            seleccionado = 1;
//	 
//	        }
//	    }
//	});
//	
//	}

	
			
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
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	
		switch (e.getActionCommand()) {
		
			case "Añadir":
				
				if (sesion.getNombreusuario().equals("")){
					
					
					JOptionPane.showMessageDialog(this, "Primero inicia la sesion");			
					
					
				}
				
				else { //si la sesion esta iniciada
					
									
						if (table.getSelectedRow() == -1){
							
							JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun producto");
							
							return;
						}
						
						else if (table.getSelectedRow() > -1){
						
						System.out.println(table.getValueAt(table.getSelectedRow(), 0));			
						
			        	//codigo producto
			        	codigoSeleccion = table.getValueAt(table.getSelectedRow(), 0).toString(); //imprime el codigo del producto seleccionado
			            System.out.println(codigoSeleccion);
			        	
			            //nombreusuario
			            
			            nombreusuario = sesion.getNombreusuario();
			            
			            
			            //fecha
			            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			            Date fechaDate = Calendar.getInstance().getTime();        
			            fecha = df.format(fechaDate);
						
									
						BaseDeDatos.insertarPedido(codigoSeleccion, nombreusuario, fecha);
				
						}
				
				}
				
				break;
		}
		
	}
	
	
	
	public void pasarSesion(Cliente sesion) {
		
		
		this.sesion = sesion;
	
	}



//	@Override
//	public void valueChanged(ListSelectionEvent event) {
//		// TODO Auto-generated method stub
//		
//		if( event.getSource() == table.getSelectionModel()
//				&& event.getFirstIndex() >= 0 )
//		{
//		
////        if (table.getSelectedRow() > -1) {
//	           
//        	//codigo producto
//        	codigoSeleccion = table.getValueAt(table.getSelectedRow(), 0).toString(); //imprime el codigo del producto seleccionado
//            System.out.println(codigoSeleccion);
//        	
//            //nombreusuario
//            
//            nombreusuario = sesion.getNombreusuario();
//            
//            
//            //fecha
//            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//            Date fechaDate = Calendar.getInstance().getTime();        
//            fecha = df.format(fechaDate);
//            
//            	 
//            seleccionado = 1;
// 
//        }
  


}
		

	

