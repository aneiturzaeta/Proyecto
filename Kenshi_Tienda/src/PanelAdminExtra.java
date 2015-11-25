import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelAdminExtra extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JButton imagen;
	
	
	public PanelAdminExtra() {
		setLayout(null);
		
	imagen = new JButton();
	
	imagen = new JButton(new ImageIcon( frmPrincipal.class.getResource("img/admin.gif"))); //añadimos un boton
	imagen.setOpaque(false);
	imagen.setContentAreaFilled(false);
	imagen.setBounds(60, 50, 300, 300);
	imagen.setBorderPainted(false);
	add(imagen);
		
		
		
	}

}
