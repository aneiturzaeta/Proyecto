import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelContactoExtra extends JPanel{
	
	
	 private JButton imagen;
	 
	public PanelContactoExtra (){
		
		setLayout(null);
		
		imagen = new JButton();
		
		imagen = new JButton(new ImageIcon( frmPrincipal.class.getResource("img/mail_imag.png"))); //añadimos un boton
		imagen.setOpaque(false);
		imagen.setContentAreaFilled(false);
		imagen.setBounds(60, 50, 300, 300);
		imagen.setBorderPainted(false);
		add(imagen);
			
				
	}

}
