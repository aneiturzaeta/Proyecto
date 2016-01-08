import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class PanelEntrar extends JPanel implements ActionListener {

	
	
	private JLabel textCont;
	private JTextField Contraseña;
	private JLabel textU;
	private JTextField Usuario;
		
	private JButton Aceptar;
	
	private Cliente sesion;
	
	
	public PanelEntrar(){
		
		
setLayout(null);

		Usuario = new JTextField();
		Usuario.setFont(new Font("Century Gothic", Font.BOLD, 50));
		Usuario.setBounds(94, 75, 231, 20);
		Usuario.setEnabled(true);
		Usuario.setEditable(true);
		add(Usuario);

		textU = new JLabel();
		textU.setText("Inserte el nombre de usuario \r\n");
		textU.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textU.setBounds(94, 45, 231, 20);
		textU.setOpaque(false);
		add(textU);
		
		
		
		Contraseña = new JPasswordField();
		Contraseña.setFont(new Font("Century Gothic", Font.BOLD, 50));
		Contraseña.setBounds(94, 159, 231, 20);
		Contraseña.setEnabled(true);
		Contraseña.setEditable(true);
		add(Contraseña);
		
		textCont = new JLabel();
		textCont.setText("Inserte la contrasena \r\n");
		textCont.setSize(100, 32);
		textCont.setLocation(200, 100);
		textCont.setOpaque(false);
		textCont.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textCont.setBounds(94, 125, 231, 20);
		add(textCont);
				
		
		Aceptar = new JButton("Entrar");
		Aceptar.setSize(100, 32);
		Aceptar.setLocation(156, 215);
		Aceptar.setFont(new Font("Century Gothic", Font.BOLD, 16));
//		BSalir.setBounds(100, 103, 150, 30);
		Aceptar.addActionListener(this);
		Aceptar.setActionCommand("Entrar");
		Aceptar.setContentAreaFilled(false);
		Aceptar.setBorderPainted(false);
		add(Aceptar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		switch (e.getActionCommand()){
		
		case "Entrar":
			
			String contraseña = Contraseña.getText();
			
			String usuario = Usuario.getText();
			
			
			if (sesion.getNombreusuario()!= null && !sesion.getNombreusuario().isEmpty()){
			
			
			
					try {
						
						comprobarUsu (usuario);
						
					
					//	PanelGestionContacto panelGestionCont = new PanelGestionContacto ();
						//panelGestionCont.setPreferredSize( new Dimension( 800,125 ) );
						//panelGestionCont.setBackground(SystemColor.activeCaption);
						//this.add(panelGestionCont, BorderLayout.CENTER);
					
						
						//JOptionPane.showInputDialog("Entrado bien");
					}
						
					catch (ExcepUsuario e1) {
					
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(this, e1.Informar());
					}
						
					try {
					comprobarCont(contraseña);
					}
					catch (ExcepCont e1){
						
						JOptionPane.showMessageDialog(this, e1.Informar());
					}
					
			
			//entrar como usuario. Cambiar la sesion
					
			}
			
			
			else {
								
				JOptionPane.showMessageDialog(this, "Estas con una sesion iniciada. Primero cierra la sesion");
				
			}
	
			
			
			
		break;
		
		}
		
	}

	private void comprobarCont(String contraseña) throws ExcepCont {
		// TODO Auto-generated method stub
		if(contraseña.isEmpty()){
			
			throw new ExcepCont ();
			
		} //comprobar tambien si son los correctos
	}

	private void comprobarUsu(String usuario) throws ExcepUsuario {
		// TODO Auto-generated method stub
		if(usuario.isEmpty()){
			
			throw new ExcepUsuario ();
			
		}// mirar si existe el nombre de usuario
	}
	
	
	
	public void sesion(Cliente sesion) {
		
		
		this.sesion = sesion;
	
	}
	
	
	
	
	
}
