

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelCarroExtra extends JPanel{


	 private JButton imagen;
	
	 
		public PanelCarroExtra (){
			
			setLayout(null);
			
			imagen = new JButton();
			
			imagen = new JButton(new ImageIcon( frmPrincipal.class.getResource("img/carro-compras.png"))); //añadimos un boton
			imagen.setOpaque(false);
			imagen.setContentAreaFilled(false);
			imagen.setBounds(60, 50, 300, 300);
			imagen.setBorderPainted(false);
			add(imagen);
			
	
				
					
		}
}
