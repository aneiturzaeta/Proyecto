import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelEntrarExtra extends JPanel {

	
private JButton imagen;
	
	
	public PanelEntrarExtra() {
	
		setLayout(null);
		
	imagen = new JButton();
	
	imagen = new JButton(new ImageIcon( frmPrincipal.class.getResource("img/user-account.png"))); //añadimos un boton
	imagen.setOpaque(false);
	imagen.setContentAreaFilled(false);
	imagen.setBounds(60, 50, 300, 300);
	imagen.setBorderPainted(false);
	add(imagen);
	
	
	
}

}
	
