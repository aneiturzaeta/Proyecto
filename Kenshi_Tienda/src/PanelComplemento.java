import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class PanelComplemento extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	
	private JTable table;
	private JLabel textComplemento;
	private JButton Añadir;

	
	private Cliente sesion;

	String codigoSeleccion;
    String nombreusuario;
    String fecha;
    
    int seleccionado= 0;
    
	
	public PanelComplemento() {

		
		/**
		 * Create the panel.
		 */
			
			setBackground(SystemColor.activeCaption);
			
					
			Object[][] datos = { 
					
					{"11", "Collar", "Gargantilla", 10+" €", "Plata", "Etníco"},
					{"12", "Collar", "Ópera", 16+" €", "Cuerdas", "Hawaiano"},
					{"13", "Bufanda", "Negra", 19+" €", "Algodon", "Australiano"},
					{"14", "Pulsera", "Brazalete", 40+" €", "Oro", "Árabe"},
			};	
			
			
			table = new JTable();
			
			DefaultTableModel model = new DefaultTableModel();
			 
			table.setModel(model);
			

			String[] columnas = {"Codigo","Nombre", "Descripcion", "Precio",  "Material", "Origen"};
			
			model.setColumnIdentifiers(columnas);
			

			 ArrayList <Complemento> complementos = new ArrayList<Complemento>();
			 
			 
			 complementos.add(new Complemento("Complemento1", "Collar", "Gargantilla", 10+" €", "Plata", "Etníco"));
			 complementos.add(new Complemento("Complemento2", "Collar", "Gargantilla", 40+" €", "Oro", "Etníco"));
			 complementos.add(new Complemento("Complemento3", "Collar", "Ópera", 19+" €", "Cuerdas", "Hawaiano"));
			 complementos.add(new Complemento("Complemento4", "Collar", "Ópera", 10+" €", "Cuerdas", "Etníco"));
			 complementos.add(new Complemento("Complemento5", "Bufanda", "Negra", 19+" €", "Algodón", "Australiano"));
			 complementos.add(new Complemento("Complemento6", "Bufanda", "Azul", 20+" €", "Algodón", "Australiano"));
			 complementos.add(new Complemento("Complemento7", "Bufanda", "Azul marino", 20+" €", "Lana", "Etníco"));
			 complementos.add(new Complemento("Complemento8", "Pulsera", "Brazalete", 40+" €", "Plata", "Árabe"));
			 complementos.add(new Complemento("Complemento9", "Pulsera", "Brazalete", 45+" €", "Oro", "Árabe"));
			
			 for ( Complemento complemento : complementos){
				   
				 String codigo = complemento.getCodigo();
				 String nombre = complemento.getNombre();
				 String descripcion = complemento.getDescripcion();
				 String precio = complemento.getPrecio();
				 String material = complemento.getMaterial();
				 String origen = complemento.getOrigen();
				 
			   
			model.addRow(new Object[]{codigo, nombre, descripcion, precio, material, origen});	
			
			 }
			 
			 
			table.getColumn("Codigo").setPreferredWidth(100);
			table.getColumn("Nombre").setPreferredWidth(70);
			table.getColumn("Descripcion").setPreferredWidth(160);
			table.getColumn("Precio").setPreferredWidth(50);
			table.getColumn("Material").setPreferredWidth(90);
			table.getColumn("Origen").setPreferredWidth(60);
			setLayout(null);
			
						
			JScrollPane scrollp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			scrollp.setSize(395, 200);
			scrollp.setLocation(22, 101);
			
			
			
			TableRowSorter <DefaultTableModel> ordenarFilas = new TableRowSorter<DefaultTableModel>(model);
			table.setRowSorter(ordenarFilas);
			
			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
			
			this.add(scrollp, BorderLayout.WEST);
			
			
			textComplemento = new JLabel();
			textComplemento.setFont(new Font("Bradley Hand ITC", Font.BOLD, 25));
			textComplemento.setText("Nuestros complementos");
			textComplemento.setOpaque(false);
			textComplemento.setForeground(Color.BLACK);
			//textComplemento.setEnabled(false);
			textComplemento.setBounds(100, 50, 350, 20);
			add(textComplemento);
			
			
			Añadir = new JButton("Añadir Producto");
			Añadir.setBounds(106, 330, 200, 23);
			Añadir.setFont(new Font("Century Gothic", Font.BOLD, 16));
			Añadir.setContentAreaFilled(false);
			Añadir.setBorderPainted(false);
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
