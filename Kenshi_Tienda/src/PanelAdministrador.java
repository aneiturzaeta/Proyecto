import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;


public class PanelAdministrador extends JPanel implements ActionListener {
	
	private JTextField passAdmin;
	private JLabel textPassAdmin;
	private JButton BAdminEntrar;
	
	private JButton Bsesion;
	
	private JButton Bverificar;

	private int fallos = 0;
	private int maxFallos = 3;
		
	private Cliente sesion;
	
	/**
	 * Create the panel.
	 */
	public PanelAdministrador() {
		setLayout(null);
		
		passAdmin = new JPasswordField();
		passAdmin.setFont(new Font("Century Gothic", Font.BOLD, 20));
		passAdmin.setBounds(94, 159, 231, 20);
		passAdmin.setEnabled(true);
		passAdmin.setEditable(true);
		add(passAdmin);
		
		textPassAdmin = new JLabel();
		textPassAdmin.setText("Inserte la contrasena de administrador\r\n");
		textPassAdmin.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textPassAdmin.setBounds(94, 95, 231, 20);
		textPassAdmin.setOpaque(false);
		add(textPassAdmin);
		
		
		BAdminEntrar = new JButton("Entrar");
		BAdminEntrar.setSize(100, 32);
		BAdminEntrar.setLocation(156, 215);
		BAdminEntrar.setFont(new Font("Century Gothic", Font.BOLD, 16));
//		BSalir.setBounds(100, 103, 150, 30);
		BAdminEntrar.addActionListener(this);
		BAdminEntrar.setActionCommand("Entrar");
		BAdminEntrar.setContentAreaFilled(false);
		BAdminEntrar.setBorderPainted(false);
		add(BAdminEntrar);
		
		
		Bsesion = new JButton("Cerrar sesion de administrador");
		Bsesion.setSize(300, 32);
		Bsesion.setLocation(56, 250);
		Bsesion.setFont(new Font("Century Gothic", Font.BOLD, 16));
		Bsesion.addActionListener(this);
		Bsesion.setActionCommand("Sesion");
		Bsesion.setContentAreaFilled(false);
		Bsesion.setBorderPainted(false);
		
		
		Bverificar = new JButton(new ImageIcon( PanelAdministrador.class.getResource("img/tick.png"))); //añadimos un boton
		Bverificar.setSize(100, 100);
		Bverificar.addActionListener(this);
		Bverificar.setLocation(156, 84);
		Bverificar.setActionCommand("Verificar");
		Bverificar.setOpaque(true);
		Bverificar.setContentAreaFilled(false);
		Bverificar.setBorderPainted(false);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand()){
		
			case "Entrar":
				
				String contra = passAdmin.getText();
				
				
				
			if (sesion != null){
				
				JOptionPane.showMessageDialog(this, "Primero cierra la sesion de usuario");
			
				this.remove(passAdmin);
				this.remove(textPassAdmin);
				this.remove(BAdminEntrar);
						
				passAdmin.setText("");
				passAdmin.repaint();
			
				this.repaint();
				
			}
				
				
			else {	
								
					try {
						
						comprobarContra (contra);
					
						fallos = 0;
						
						//ha entrado bien
							
						JOptionPane.showMessageDialog(this, "Has entrado como administrador");
						
						
						this.add(Bsesion);
						this.add(Bverificar);
						
						this.remove(passAdmin);
						this.remove(textPassAdmin);
						this.remove(BAdminEntrar);
								
						passAdmin.setText("");
						passAdmin.repaint();
						
						this.repaint();
						
						
					}
						
					catch (ExcepAdminKo e1) {
					
							fallos ++;
						
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(this, e1.Informar(maxFallos, fallos));
							
							if (fallos == maxFallos){
								
									
							this.remove(passAdmin);
							this.remove(textPassAdmin);
							this.remove(BAdminEntrar);
									
							this.repaint();
								
							}
							
							passAdmin.setText("");
							passAdmin.repaint();
					}
			
			}
			
			break;	
			
		
		
		case "Verificar":
		
				JOptionPane.showMessageDialog(this, "PROGRAMA VERIFICADO POR ADMINISTRADOR/A");
			
		
				this.remove(Bverificar);
				
				this.repaint();
				
			break;
			
			
		case "Sesion":
			
			JOptionPane.showMessageDialog(this, "SESION DE ADMINISTRADOR/A CERRADA");
					
			this.add(passAdmin);
			this.add(textPassAdmin);
			this.add(BAdminEntrar);
				
			this.remove(Bverificar);
			this.remove(Bsesion);
			
			this.repaint();

			
			break;
		
		
		}
				
	}
					

	void comprobarContra(String contra) throws ExcepAdminKo {
		// TODO Auto-generated method stub
		String contraReal = "1";
		
		if (!contraReal.equals(contra)){
			
			throw new ExcepAdminKo();
			
		}
	
		
	}
	
	public void sesion(Cliente sesion) {
		
		
		this.sesion = sesion;
	
	}
	

	
			
		
		
}

