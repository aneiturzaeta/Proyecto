import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class PanelComplemento extends JPanel implements ActionListener{

	/**
	 * Create the panel.
	 */
	
	private JTable table;
	private JLabel textComplemento;
	private JButton A�adir;

	
	public PanelComplemento() {

		
		/**
		 * Create the panel.
		 */
			
			setBackground(SystemColor.activeCaption);
			setLayout(null);
			
			
			
			String[] columnas = {"Codigo","Nombre", "Descripcion", "Precio", "Existencias", "Material", "Or�gen"};
			
			
			//se cargan desde la BD. 
			//se cogen si tipoProducto = 1;
			Object[][] datos = { 
					
					{"11", "Collar", "Gargantilla", 10+" �", 5, "Plata", "Etn�co"},
					{"12", "Collar", "�pera", 16+" �", 5, "Cuerdas", "Hawaiano"},
					{"13", "Bufanda", "Negra", 19,5+" �", 7, "Algodon", "Australiano"},
					{"14", "Pulsera", "Brazalete", 40+" �", 20, "Oro", "�rabe"},
			};	
			
			
			table = new JTable(datos, columnas);
			table.setBounds(20, 65, 405, 64);
			
			
			table.getColumn("Codigo").setPreferredWidth(25);
			table.getColumn("Existencias").setPreferredWidth(25);
			table.getColumn("Precio").setPreferredWidth(35);
			
			
//			table.setEnabled(false);

			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);				
			this.add(table);
			
			
			
			
			textComplemento = new JLabel();
			textComplemento.setFont(new Font("Century Gothic", Font.BOLD, 15));
			textComplemento.setText("Nuestros complementos");
			textComplemento.setOpaque(false);
			textComplemento.setForeground(Color.BLACK);
			//textComplemento.setEnabled(false);
			textComplemento.setBounds(119, 24, 236, 20);
			add(textComplemento);
			
			
			A�adir = new JButton("A\u00F1adir Producto");
			A�adir.setBounds(169, 160, 110, 23);
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
			
			a�adir(0, "a�adir");
			
			JOptionPane.showMessageDialog(this, "No se ha seleccionado ningun producto");
			
							
			//if get selected row is not null --> actuar
			
			//getselectedrow (el numero)
			
			//insertar reserva BD de ese numero y con el nombre de usuario
			
			
			break;
		
	}
	}
	
	public void a�adir (int fila, String etiqueta){
		
		int filaSele;
		boolean a�adir = false;
		
		switch (etiqueta){
		
			case "A�adir": a�adir = true; break;
						
			case "Fila": filaSele = fila; break;
		
		}
		
		
		Date fecha = new Date();
				
		Random r= new Random(33);
				
		int numeroPedido = r.nextInt(10000);
		
		int codigo = 1; //el codigo del producto;
		
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
