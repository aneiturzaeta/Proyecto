import java.awt.Font;
import java.awt.SystemColor;
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
	private JTable table;
	
	
	public PanelGestionAdministrador() {

		
		
		setBackground(SystemColor.activeCaption);
		setLayout(null);
		
		
		table = new JTable();
		table.setBounds(35, 65, 298, 295);
		add(table);
		
		
				
		BGuardar = new JButton("Guardar");
		BGuardar.setSize(100, 32);
		BGuardar.setLocation(156, 215);
		BGuardar.setFont(new Font("Century Gothic", Font.BOLD, 16));
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
				
			
			//se guarda en la base de datos
				
				
							
			
				
				
			break;
				
		}
			
	}	
	

}
