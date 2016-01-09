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
	private JTextField Contrase�a;
	private JLabel textU;
	private JTextField Usuario;
		
	private JButton Aceptar;
	
	private Cliente sesion;
	
	
	public PanelEntrar(){
		
		
setLayout(null);

		Usuario = new JTextField();
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
		
		
		
		Contrase�a = new JPasswordField();
		Contrase�a.setBounds(94, 159, 231, 20);
		Contrase�a.setEnabled(true);
		Contrase�a.setEditable(true);
		add(Contrase�a);
		
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
			
			String contrase�a = Contrase�a.getText();
			
			String usuario = Usuario.getText();
			
			
			if (sesion.getNombreusuario()== "" ){
			
			
			
					try {
						
						comprobarUsu (usuario);
					

					}
						
					catch (ExcepUsuario e1) {
					
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(this, e1.Informar());
					}
						
					try {

						comprobarCont(contrase�a);
					
					}
					catch (ExcepCont e1){
						
						JOptionPane.showMessageDialog(this, e1.Informar());
					}
					
					
			int ok = BaseDeDatos.comprobarUsuarioContrase�a(usuario, contrase�a);		
					
				if (ok == 1){
					
					
					sesion.setNombreusuario(usuario);
					sesion.setContrase�a(contrase�a);
									
					
					JOptionPane.showMessageDialog(this, "Has iniciado sesion correctamente con nombre de usuario " + usuario);
					
					Contrase�a.setText("");
					Usuario.setText("");
													
					this.repaint();
					
				}
				
				else JOptionPane.showMessageDialog(this, "Error en la contrase�a o nombre de usuario");				
					
				Contrase�a.setText("");
				Usuario.setText("");
							
							
				this.repaint();				
				
			}
			
			
			else {
								
				JOptionPane.showMessageDialog(this, "Estas con una sesion iniciada. Primero cierra la sesion");
				
			}
				
			
		break;
		
		}
		
	}

	private void comprobarCont(String contrase�a) throws ExcepCont {
		// TODO Auto-generated method stub
		if(contrase�a.isEmpty()){
			
			throw new ExcepCont ();
			
		} //comprobar tambien si son los correctos
	}

	private void comprobarUsu(String usuario) throws ExcepUsuario {
		// TODO Auto-generated method stub
		if(usuario.isEmpty()){
			
			throw new ExcepUsuario ();
			
		}// mirar si existe el nombre de usuario
	}
	
	
	public Cliente devolverSesion(){
		
		return sesion;
					
	}
	
	
	public void pasarSesion(Cliente sesion) {
		
		
		this.sesion = sesion;
	
	}
	
	
	
	
	
}
