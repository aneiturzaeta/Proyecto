import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class PanelCarro extends JPanel {

	
	private JTable table;
	private JLabel textComplemento;
	

	private Cliente sesion;
	
	
	
	public PanelCarro (){
			
			setBackground(SystemColor.activeCaption);
			setLayout(null);
			
					
			//la tabla se inicializa con la funcion sacarPedidos();
						
			
			textComplemento = new JLabel();
			textComplemento.setFont(new Font("Century Gothic", Font.BOLD, 12));
			textComplemento.setText("Estos son los productos que tienes en tu carro");
			textComplemento.setOpaque(false);
			textComplemento.setForeground(Color.BLACK);
			textComplemento.setBounds(60, 23, 280, 20);
			add(textComplemento);
		
			
			
			}
			


	
	public void sacarPedidos(){
		
		
		//rellenar la tabla. 1) buscar en BD. 2) Imprimir los datos
		
		
		
			
		if (sesion.getNombreusuario().equals("")){

			
			JOptionPane.showMessageDialog(this, "Primero inicia sesion. No hay cesta que mostrar");	
		
					
			
		}
		
		else {
		
		System.out.println(sesion.getNombreusuario());
			
		ResultSet rs = null;
				
		rs = BaseDeDatos.buscarPedidos(sesion.getNombreusuario());
		
		
			if (rs == null){
				
				JOptionPane.showMessageDialog(this, "No hay pedidos de este usuario");	
				
			}
			
			else {
				
					table = new JTable();
			
					String[] columnas = {"Codigo Producto","Fecha"};
	
									
					
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
					
					table.setEnabled(false);				
								
					
					
					  DefaultTableModel model = new DefaultTableModel();
					  table.setModel(model);
		
					  model.setColumnIdentifiers(columnas);
					
					  table.getColumn("Codigo Producto").setPreferredWidth(120);
					  table.getColumn("Fecha").setPreferredWidth(120);
					  
					 					  
					try{
						
						while (rs.next()){
						
//						for (List<String> p : pedidos) {
					
						  
							
							String codigo = rs.getString("CODIGO");
							String fecha = rs.getString("FECHA");
							   
							//hay que ir metiendo fila por fila todas las entradas. 1 entrada = 1 pedido
							
							
							model.addRow(new Object[]{codigo, fecha});	
						  
							
						}
						
						
					}catch (Exception e){
						
							
						
					}
					
					JScrollPane scrollp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					scrollp.setSize(270, 200);
					scrollp.setLocation(52, 101);
					
					this.add(scrollp, BorderLayout.WEST);	
					
					table.repaint();
					
//					this.repaint();
					
//					table = new JTable(datos, columnas);
					
//					for ( Pedido pedido : pedidos){
//						   
//						String codigo = pedido.getCodigo();
//						String fecha = pedido.getFecha();
//						   
//						//hay que ir metiendo fila por fila todas las entradas. 1 entrada = 1 pedido
//						
//						
//						model.addRow(new Object[]{codigo, fecha});	
//															
//						}
	
							
		}	
			
		}
		
}
	
	
	
	public void pasarSesion(Cliente sesion) {
		
		
		this.sesion = sesion;
	
	}

}
