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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

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
import java.util.ArrayList;
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
		
		
			
						
		table = new JTable();
		
		DefaultTableModel model = new DefaultTableModel();
		 
		table.setModel(model);
		
		
		String[] columnas = {"Codigo","Nombre", "Descripcion", "Precio",  "Talla", "Material", "Estilo"};
		
		 model.setColumnIdentifiers(columnas);
		 
		
		 ArrayList <Ropa> ropas = new ArrayList<Ropa>();
		 
		 ropas.add(new Ropa("ROPAjer1", "Jersey", "Azul. Cuello redondo", 20+" €",  "M", "Lana", "Hipster"));
		 ropas.add(new Ropa("ROPAjer2", "Jersey", "Azul. Cuello redondo", 20+" €",  "L", "Lana", "Hipster"));
		 ropas.add(new Ropa("ROPAjer3", "Jersey", "Verde. Cuello redondo", 20+" €",  "M", "Lana", "Hipster"));
		 ropas.add(new Ropa("ROPAjer4", "Jersey", "Verde. Cuello redondo", 20+" €",  "L", "Lana", "Hipster"));
		 ropas.add(new Ropa("ROPAjer5", "Jersey", "Negro. Cuello redondo", 20+" €",  "M", "Lana", "Hipster"));
		 ropas.add(new Ropa("ROPAjer6", "Jersey", "Negro. Cuello redondo", 20+" €",  "L", "Lana", "Hipster"));
		 
		 ropas.add(new Ropa("ROPAcam1", "Camiseta", "Azul. Básica Hombre", 12+" €",  "S", "Algodón", "Hipster"));
		 ropas.add(new Ropa("ROPAcam2", "Camiseta", "Azul. Básica Hombre", 12+" €",  "M", "Algodón", "Hipster"));
		 ropas.add(new Ropa("ROPAcam3", "Camiseta", "Azul. Básica Hombre", 12+" €",  "L", "Algodón", "Hipster"));
		 ropas.add(new Ropa("ROPAcam4", "Camiseta", "Gris. Básica Mujer", 10+" €",  "S", "Algodón", "Hipster"));
		 ropas.add(new Ropa("ROPAcam5", "Camiseta", "Gris. Básica Mujer", 10+" €",  "M", "Algodón", "Hipster"));
		 ropas.add(new Ropa("ROPAcam6", "Camiseta", "Gris. Básica Mujer", 10+" €",  "L", "Algodón", "Hipster"));
		 ropas.add(new Ropa("ROPAcam7", "Camiseta", "Blanca con mensaje", 12+" €",  "U", "Algodón", "Hipster"));
		 
		 ropas.add(new Ropa("ROPAblu1", "Blusa", "Brillantes. Dorado", 15+" €",  "S", "Terciopelo", "Fiesta"));
		 ropas.add(new Ropa("ROPAblu2", "Blusa", "Brillantes. Dorado", 15+" €",  "M", "Terciopelo", "Fiesta"));
		 ropas.add(new Ropa("ROPAblu3", "Blusa", "Brillantes. Dorado", 15+" €",  "L", "Terciopelo", "Fiesta"));
		 ropas.add(new Ropa("ROPAblu4", "Blusa", "Brillantes. Dorado", 15+" €",  "XL", "Terciopelo", "Fiesta"));
		 ropas.add(new Ropa("ROPAblu5", "Blusa", "Blanca, detalles negros", 20+" €",  "S", "Lana", "Elegante"));
		 ropas.add(new Ropa("ROPAblu6", "Blusa", "Blanca, detalles negros", 20+" €",  "M", "Lana", "Elegante"));
		 ropas.add(new Ropa("ROPAblu7", "Blusa", "Blanca, detalles negros", 20+" €",  "L", "Lana", "Elegante"));
		 ropas.add(new Ropa("ROPAblu8", "Blusa", "Blanca, detalles negros", 20+" €",  "XL", "Lana", "Elegante"));
		 
		 
		 for ( Ropa ropa : ropas){
		   
			 String codigo = ropa.getCodigo();
			 String nombre = ropa.getNombre();
			 String descripcion = ropa.getDescripcion();
			 String precio = ropa.getPrecio();
			 String talla = ropa.getTalla();
			 String material = ropa.getMaterial();
			 String estilo = ropa.getEstilo();
			 
		   
		model.addRow(new Object[]{codigo, nombre, descripcion, precio, talla, material, estilo});	
		
		 }

		
		table.getColumn("Codigo").setPreferredWidth(80);
		table.getColumn("Nombre").setPreferredWidth(70);
		table.getColumn("Descripcion").setPreferredWidth(120);
		table.getColumn("Precio").setPreferredWidth(50);
		table.getColumn("Talla").setPreferredWidth(50);
		table.getColumn("Material").setPreferredWidth(90);
		table.getColumn("Estilo").setPreferredWidth(60);
		setLayout(null);
		
		
		JScrollPane scrollp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollp.setSize(405, 200);
		scrollp.setLocation(12, 101);
		
		//pinchar etiqueta de columna --> ordenar
		
		TableRowSorter <DefaultTableModel> ordenarFilas = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(ordenarFilas);
		
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
						
									
						BaseDeDatos.insertarPedido(codigoSeleccion, fecha, nombreusuario);
				
						}
				
				}
				
				break;
		}
		
	}
	
	
	
	public void pasarSesion(Cliente sesion) {
		
		
		this.sesion = sesion;
	
	}



}
		

	

