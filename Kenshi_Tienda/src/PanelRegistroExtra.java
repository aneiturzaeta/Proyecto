import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelRegistroExtra extends JPanel{

	
		private JButton imagen;
		private JLabel nuevo;
	
	public PanelRegistroExtra() {
	
		setLayout(null);
		
	imagen = new JButton();
	
	imagen = new JButton(new ImageIcon( frmPrincipal.class.getResource("img/user-account.png"))); //añadimos un boton
	imagen.setOpaque(false);
	imagen.setContentAreaFilled(false);
	imagen.setBounds(60, 50, 300, 300);
	imagen.setBorderPainted(false);
	add(imagen);
	
	
	nuevo = new JLabel();
	nuevo.setText("NUEVO USUARIO \r\n");
	nuevo.setSize(100, 32);
	nuevo.setFont(new Font("Century Gothic", Font.BOLD, 25));
	nuevo.setBounds(30, 20, 300, 20);
	this.add(nuevo);
	
	
}


	
	

}