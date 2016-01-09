import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class PanelCarro extends JPanel implements ActionListener{

	
	private JTable table;
	private JLabel textComplemento;
	
	private JButton bBorrar;
	
	 
	private Cliente sesion = new Cliente("", "", "", "", "");
	
	
	public PanelCarro (){
			
			setBackground(SystemColor.activeCaption);
			setLayout(null);
			
			
			
			//rellenar la tabla. 1) buscar en BD. 2) Imprimir los datos
			
			
			
			ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
			
			
//			if (sesion.getNombreusuario().equals("")){
//				
//				
//				JOptionPane.showMessageDialog(this, "Primero inicia sesion. No hay cesta que mostrar");	
//				
//			}
//			
//			else {
//			
//			
////			pedidos = BaseDeDatos.buscarPedidos(sesion.getNombreusuario());
//			
//					
//			String[] columnas = {"Codigo Producto","Fecha"};
//			
//			
//			//se cargan desde la BD. 
//			
//			
//			for ( Pedido pedido : pedidos){
//				   
//				String codigo = pedido.getCodigo();
//				String fecha = pedido.getFecha();
//				   
//				//hay que ir metiendo fila por fila todas las entradas. 1 entrada = 1 pedido
//				
////				Object[][] datos = {codigo, fecha};
//
////				table = new JTable(datos, columnas);
//
//				}
//			
//			
//			
//			
//			
//			
//			
////			datos.add("01", "ww");
//			
//			
//			
//			table.setBounds(49, 65, 298, 295);
//			add(table);
//			
//			
//						
//			
//			textComplemento = new JLabel();
//			textComplemento.setFont(new Font("Century Gothic", Font.BOLD, 12));
//			textComplemento.setText("Estos son los productos que tienes en tu carro");
//			textComplemento.setOpaque(false);
//			textComplemento.setForeground(Color.BLACK);
//			textComplemento.setBounds(60, 23, 280, 20);
//			add(textComplemento);
//			
//			bBorrar = new JButton("Borrar todos los pedidos");
//			bBorrar.setSize(250, 32);
//			bBorrar.setLocation(70, 380);
//			bBorrar.setFont(new Font("Century Gothic", Font.BOLD, 16));
//			bBorrar.addActionListener(this);
//			bBorrar.setActionCommand("Borrar");
//			bBorrar.setContentAreaFilled(false);
//			bBorrar.setBorderPainted(false);
//			add(bBorrar);
//	
//			
//			
//			}
			
			
			
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		
		case "Borrar":
			
			
			BaseDeDatos.borrarPedidos(sesion);
			
			
			
			break;
		
		}
		
		
	}
	
	
	public void pasarSesion(Cliente sesion) {
		
		
		this.sesion = sesion;
	
	}

}
