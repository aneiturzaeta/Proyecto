import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class PanelCarro extends JPanel implements ActionListener{

	
	private JTable table;
	private JLabel textComplemento;
	
	private JButton bBorrar;
	
	 
	private Cliente sesion;
	
	
	public PanelCarro (){
			
			setBackground(SystemColor.activeCaption);
			setLayout(null);
			
			table = new JTable();
			table.setBounds(49, 65, 298, 295);
			add(table);
			
			textComplemento = new JLabel();
			textComplemento.setFont(new Font("Century Gothic", Font.BOLD, 12));
			textComplemento.setText("Estos son los productos que tienes en tu carro");
			textComplemento.setOpaque(false);
			textComplemento.setForeground(Color.BLACK);
			textComplemento.setBounds(60, 23, 280, 20);
			add(textComplemento);
			
			bBorrar = new JButton("Borrar pedidos");
			bBorrar.setSize(100, 32);
			bBorrar.setLocation(156, 380);
			bBorrar.setFont(new Font("Century Gothic", Font.BOLD, 16));
			bBorrar.addActionListener(this);
			bBorrar.setActionCommand("Borrar");
			bBorrar.setContentAreaFilled(false);
			bBorrar.setBorderPainted(false);
			add(bBorrar);
	
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
	
	
	public void sesion(Cliente sesion) {
	
	
		this.sesion = sesion;
	
	}

}
