import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;


public class PanelGestionAdministrador extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	
	private JButton BGuardar;
	private JTable tabla;
	
	
	public PanelGestionAdministrador() {

		BGuardar = new JButton("Guardar");
		BGuardar.setSize(100, 32);
		BGuardar.setLocation(156, 215);
		BGuardar.setFont(new Font("Century Gothic", Font.BOLD, 16));
//		BSalir.setBounds(100, 103, 150, 30);
		BGuardar.addActionListener(this);
		BGuardar.setActionCommand("Guardar");
		BGuardar.setContentAreaFilled(false);
		BGuardar.setBorderPainted(false);
		add(BGuardar);
		
		
		
		
		
		
		
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		
			case "Guardar":
				
			
				
				
				
				
			break;
				
		}
			
	}	
	

}
