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
	private JButton A�adir;

	
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
					
					{"11", "Collar", "Gargantilla", 10+" �", "Plata", "Etn�co"},
					{"12", "Collar", "�pera", 16+" �", "Cuerdas", "Hawaiano"},
					{"13", "Bufanda", "Negra", 19+" �", "Algodon", "Australiano"},
					{"14", "Pulsera", "Brazalete", 40+" �", "Oro", "�rabe"},
			};	
			
			
			table = new JTable();
			
			DefaultTableModel model = new DefaultTableModel();
			 
			table.setModel(model);
			

			String[] columnas = {"Codigo","Nombre", "Descripcion", "Precio",  "Material", "Origen"};
			
			model.setColumnIdentifiers(columnas);
			

			 ArrayList <Complemento> complementos = new ArrayList<Complemento>();
			 
			 
			 complementos.add(new Complemento("Complemento1", "Collar", "Gargantilla", 10+" �", "Plata", "Etn�co"));
			 complementos.add(new Complemento("Complemento2", "Collar", "Gargantilla", 40+" �", "Oro", "Etn�co"));
			 complementos.add(new Complemento("Complemento3", "Collar", "�pera", 19+" �", "Cuerdas", "Hawaiano"));
			 complementos.add(new Complemento("Complemento4", "Collar", "�pera", 10+" �", "Cuerdas", "Etn�co"));
			 complementos.add(new Complemento("Complemento5", "Bufanda", "Negra", 19+" �", "Algod�n", "Australiano"));
			 complementos.add(new Complemento("Complemento6", "Bufanda", "Azul", 20+" �", "Algod�n", "Australiano"));
			 complementos.add(new Complemento("Complemento7", "Bufanda", "Azul marino", 20+" �", "Lana", "Etn�co"));
			 complementos.add(new Complemento("Complemento8", "Pulsera", "Brazalete", 40+" �", "Plata", "�rabe"));
			 complementos.add(new Complemento("Complemento9", "Pulsera", "Brazalete", 45+" �", "Oro", "�rabe"));
			
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
			
			
			A�adir = new JButton("A�adir Producto");
			A�adir.setBounds(106, 330, 200, 23);
			A�adir.setFont(new Font("Century Gothic", Font.BOLD, 16));
			A�adir.setContentAreaFilled(false);
			A�adir.setBorderPainted(false);
			A�adir.addActionListener(this);
			A�adir.setActionCommand("A�adir");
			add(A�adir);
				
		
		
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
//		      a�adir(row, "fila");
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
		
			case "A�adir":
				
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
