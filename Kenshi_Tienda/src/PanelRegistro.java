import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class PanelRegistro extends JPanel implements ActionListener{


	private JTextField Nombre;
	private JLabel textN;
	
	private JTextField Ciudad;
	private JLabel textCiudad;
	
	private JTextField Contraseņa;
	private JLabel textCont;
	
	private JTextField Usuario;
	private JLabel textU;
	
	private JButton Aceptar;
	
	public PanelRegistro(){
		
		
setLayout(null);


		Nombre = new JTextField();
		//Nombre.setFont(new Font("Century Gothic", Font.BOLD, 50));
		Nombre.setBounds(94, 75, 231, 20);
		//Nombre.setEnabled(true);
		Nombre.setEditable(true);
		this.add(Nombre);
		Nombre.setColumns(10);
		
		textN = new JLabel();
		textN.setText("Nombre y apellidos \r\n");
		textN.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textN.setBounds(94, 45, 231, 20);
		this.add(textN);
		

		Ciudad = new JTextField();
		//Nombre.setFont(new Font("Century Gothic", Font.BOLD, 50));
		Ciudad.setBounds(94, 135, 231, 20);
		//Nombre.setEnabled(true);
		Ciudad.setEditable(true);
		this.add(Ciudad);
		Ciudad.setColumns(10);
		
		textCiudad = new JLabel();
		textCiudad.setText("Ciudad \r\n");
		textCiudad.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textCiudad.setBounds(94, 105, 231, 20);
		this.add(textCiudad);
		
		
		Usuario = new JTextField();
		//Usuario.setFont(new Font("Century Gothic", Font.BOLD, 50));
		Usuario.setBounds(94, 195, 231, 20);
		Usuario.setEditable(true);
		this.add(Usuario);
		Usuario.setColumns(10);
		
		textU = new JLabel();
		textU.setText("Nombre de usuario \r\n");
		textU.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textU.setBounds(94, 165, 231, 20);
		this.add(textU);
			
		
		
		Contraseņa = new JPasswordField();
		//Contraseņa.setFont(new Font("Century Gothic", Font.BOLD, 50));
		Contraseņa.setBounds(94, 255, 231, 20);
		//Contraseņa.setEnabled(true);
		Contraseņa.setEditable(true);
		this.add(Contraseņa);
		
		textCont = new JLabel();
		textCont.setText("Contrasena nueva \r\n");
		textCont.setSize(100, 32);
		textCont.setLocation(200, 100);
		textCont.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textCont.setBounds(94, 225, 231, 20);
		this.add(textCont);
			
		
		Aceptar = new JButton("Aceptar");
		Aceptar.setSize(100, 32);
		Aceptar.setLocation(100,300 );
		Aceptar.setFont(new Font("Century Gothic", Font.BOLD, 16));
//		BSalir.setBounds(100, 103, 150, 30);
		Aceptar.addActionListener(this);
		Aceptar.setActionCommand("Aceptar");
		Aceptar.setContentAreaFilled(false);
		Aceptar.setBorderPainted(false);
		this.add(Aceptar);
	

	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		switch(e.getActionCommand()){
		
		case "Aceptar":
			
		String nombre = Nombre.getText();
		
		String ciudad = Ciudad.getText();
		
		String usuario = Usuario.getText();
			
		String contraseņa = Contraseņa.getText();
		
		try {
			
			comprobarUsuario (usuario);
		
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
				
		
		//aqui se aņadira un nuevo usuario a la base de datos					
			
		break;
		}
		
		
	}

	private void comprobarUsuario(String usuario) throws ExcepUsuario{
		// TODO Auto-generated method stub
		if(usuario.isEmpty()){
			
			throw new ExcepUsuario ();
			
		}
		//mirar tambien si existe el nombre de usuario
	}

}
