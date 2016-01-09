
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.sql.Connection;


public class frmPrincipal extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7046431761927583577L;
	

	//private PanelImagen conImagen;
	
	private JPanel PanelSuperior;
	
	private JPanel PanelInferior;
	
	private PanelRopa panelRopa = new PanelRopa ();
		
	private PanelComplemento panelComplemento = new PanelComplemento ();
			
	
	private PanelAdministrador panelAdmin = new PanelAdministrador();
	private PanelAdminExtra panelAdminExtra = new PanelAdminExtra();
	
	
	private PanelRegistro panelRegis = new PanelRegistro ();
	private PanelRegistroExtra panelRegisExtra = new PanelRegistroExtra();
	
	private PanelContacto panelCont = new PanelContacto ();
	private PanelContactoExtra panelContExtra = new PanelContactoExtra ();
	
	private PanelCarro panelCarro = new PanelCarro ();
	private PanelCarroExtra panelCarroExtra = new PanelCarroExtra ();
	
	
	private PanelEntrar panelEntrar = new PanelEntrar();
	private PanelEntrarExtra panelEntrarExtra = new PanelEntrarExtra();
	
	
	Cliente sesion;
	
	
	private JButton BAdmin;
	private JButton BRegistro;
	private JButton BEntrar;
	private JButton Bcarro;
	private JButton BSalir;
	private JButton BEmail;
	private JButton BMenu;
	private JButton BLogOut;
	
	private JTextArea K, E, N, S, H , I;
	private JTextArea informacion;
	
	
	private Reloj reloj;
	
			
	public frmPrincipal() {
	
		sesion =  new Cliente("", "", "", "", "");
		
		
		BMenu = new JButton(new ImageIcon( frmPrincipal.class.getResource("img/menu.png"))); //añadimos un boton
		BMenu.setFont(new Font("Century Gothic", Font.BOLD, 12));
		//BAtras.setLocation(100,100);
		BMenu.addActionListener(this);
		BMenu.setActionCommand("Menu");
		BMenu.setOpaque(false);
		BMenu.setContentAreaFilled(false);
		BMenu.setBorderPainted(false);
		
		BAdmin = new JButton("Administradores"); //añadimos un boton
		BAdmin.setFont(new Font("Century Gothic", Font.BOLD, 12));
		BAdmin.setLocation(100,100);
		BAdmin.addActionListener(this);
		BAdmin.setActionCommand("Admin");
		BAdmin.setOpaque(false);
		BAdmin.setContentAreaFilled(false);
		BAdmin.setBorderPainted(false);
				
		
		BEntrar = new JButton("Entrar"); //añadimos un boton
		BEntrar.setFont(new Font("Century Gothic", Font.BOLD, 12));
//		BEntrar.setBounds(324, 62, 300, 30);
		BEntrar.addActionListener(this);
		BEntrar.setActionCommand("Entrar");
		BEntrar.setOpaque(false);
		BEntrar.setContentAreaFilled(false);
		BEntrar.setBorderPainted(false);
		
			
		BRegistro = new JButton("Registrarse"); //añadimos un boton
		BRegistro.setFont(new Font("Century Gothic", Font.BOLD, 12));
		//BRegistro.setBounds(237, 103, 300, 30);
		BRegistro.addActionListener(this);
		BRegistro.setActionCommand("Registro");
		BRegistro.setOpaque(false);
		BRegistro.setContentAreaFilled(false);
		BRegistro.setBorderPainted(false);
		
		
		Bcarro = new JButton(new ImageIcon( frmPrincipal.class.getResource("img/carro.png"))); //añadimos un boton
		Bcarro.addActionListener(this);
		Bcarro.setActionCommand("Carro");
		Bcarro.setOpaque(false);
		Bcarro.setContentAreaFilled(false);
		Bcarro.setBorderPainted(false);
		
		
		BEmail = new JButton(new ImageIcon( frmPrincipal.class.getResource("img/mail.png"))); //añadimos un boton
		BEmail.addActionListener(this);
		BEmail.setActionCommand("Email");
		BEmail.setOpaque(false);
		BEmail.setContentAreaFilled(false);
		BEmail.setBorderPainted(false);
		
		BSalir = new JButton(new ImageIcon(frmPrincipal.class.getResource("img/salir.png"))); //añadimos un boton
		BSalir.setFont(new Font("Century Gothic", Font.BOLD, 12));
		BSalir.addActionListener(this);
		BSalir.setActionCommand("Salir");
		BSalir.setOpaque(false);
		BSalir.setContentAreaFilled(false);
		BSalir.setBorderPainted(false);
		
		
		BLogOut = new JButton("Log out"); //añadimos un boton
		BLogOut.setFont(new Font("Century Gothic", Font.BOLD, 12));
		BLogOut.addActionListener(this);
		BLogOut.setActionCommand("Logout");
		BLogOut.setOpaque(false);
		BLogOut.setContentAreaFilled(false);
		BLogOut.setBorderPainted(false);		
		
		
		K = new JTextArea();
		K.setText("K");
		K.setForeground(new Color(0, 0, 0));
		K.setFont(new Font("Century Gothic", Font.BOLD, 50));
		K.setEnabled(false);
		K.setBackground(Color.GRAY);
		
		E = new JTextArea();
		E.setText("e");
		E.setForeground(new Color(0, 0, 0));
		E.setFont(new Font("Century Gothic", Font.BOLD, 35));
		E.setEnabled(false);
		E.setBackground(Color.GRAY);		
		
		N = new JTextArea();
		N.setText("N");
		N.setForeground(new Color(0, 0, 0));
		N.setFont(new Font("Century Gothic", Font.BOLD, 45));
		N.setEnabled(false);
		N.setBackground(Color.GRAY);
		
		S = new JTextArea();
		S.setText("S");
		S.setForeground(new Color(0, 0, 0));
		S.setFont(new Font("Century Gothic", Font.BOLD, 30));
		S.setEnabled(false);
		S.setBackground(Color.GRAY);
		
		H = new JTextArea();
		H.setText("h");
		H.setForeground(new Color(0, 0, 0));
		H.setFont(new Font("Century Gothic", Font.BOLD, 40));
		H.setEnabled(false);
		H.setBackground(Color.GRAY);
				
		I = new JTextArea();
		I.setText("I");
		I.setForeground(new Color(0, 0, 0));
		I.setFont(new Font("Century Gothic", Font.BOLD, 50));
		I.setEnabled(false);
		I.setBackground(Color.GRAY);
		
		
		informacion = new JTextArea();
		informacion.setText("       Ane Iturzaeta aneiturzaeta@opendeusto.es y Leire Jauregi leire.jauregi@opendeusto.es,                  Programacion III, ADE + II, Deusto");
		informacion.setForeground(new Color(0, 0, 0));
		informacion.setFont(new Font("Century Gothic", Font.BOLD, 12));
		informacion.setEnabled(false);
		informacion.setBackground(Color.GRAY);
		
	
		//http://www.taringa.net/posts/hazlo-tu-mismo/16291610/Reloj-digital-con-fecha-en-java-clase-paso-a-paso.html
				reloj = new Reloj(0, 0, 0, 0);
				reloj.setForeground(new Color(0, 0, 0));
//				reloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
				reloj.setFont(new Font("Century Gothic", Font.BOLD, 11));//tipo de letra y tamaño 
				reloj.setBackground(Color.GRAY);		
			
		
		
		setTitle("KENSHI - HAZ TU COMPRA AQUI");
		setLocationRelativeTo( null );  // Centra la ventana en la pantalla
		setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		setBounds(250, 50, 880, 600); 
		//PanelSuperior.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(new BorderLayout());
		
		//PANEL SUPERIOR
		PanelSuperior = new JPanel();
		
		PanelSuperior.setPreferredSize( new Dimension( 50,  80 ) );
		PanelSuperior.setBackground(Color.GRAY);
							
		this.add(PanelSuperior, BorderLayout.NORTH);
		
		PanelSuperior.add(BSalir);
		PanelSuperior.add(BMenu);
		PanelSuperior.add(BAdmin);
		PanelSuperior.add(BEmail);
		PanelSuperior.add(K);
		PanelSuperior.add(E);
		PanelSuperior.add(N);
		PanelSuperior.add(S);
		PanelSuperior.add(H);
		PanelSuperior.add(I);
		PanelSuperior.add(Bcarro);
		PanelSuperior.add(BRegistro);
		PanelSuperior.add(BEntrar);
		PanelSuperior.add(BLogOut);
		
		
		
		
		//PANEL INFERIOR
		PanelInferior = new JPanel();
		
		PanelInferior.setPreferredSize( new Dimension( 50,  50 ) );
		PanelInferior.setBackground(Color.GRAY);
							
		this.add(PanelInferior, BorderLayout.SOUTH);
		PanelInferior.add(informacion);
		PanelInferior.add(reloj);
		
		
		//PANEL IZQUIERDA
		
		
		panelRopa.setPreferredSize( new Dimension( 430,125 ) );
		panelRopa.setBackground(SystemColor.activeCaption);
		
		panelRopa.pasarSesion(sesion);
		
		this.add(panelRopa, BorderLayout.WEST);
				
			
		
		//PANEL DERECHA
		
		
		panelComplemento.setPreferredSize( new Dimension( 430,  125 ) );
		panelComplemento.setBackground(SystemColor.activeCaption);
		
		panelComplemento.pasarSesion(sesion);
		
		this.add(panelComplemento, BorderLayout.EAST);
		
		this.setResizable(false);
		
	
		
	}

		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		switch(e.getActionCommand()){
		
		
		case "Admin":
					
			panelAdmin.setPreferredSize( new Dimension( 430,500 ) );
			panelAdmin.setBackground(SystemColor.activeCaption);
			this.add(panelAdmin, BorderLayout.WEST);
			
				
					
			panelAdminExtra.setPreferredSize( new Dimension( 430,500 ) );
			panelAdminExtra.setBackground(SystemColor.activeCaption);
			this.add(panelAdminExtra, BorderLayout.EAST);
			
				
			
			panelAdminExtra.setVisible(true);
			panelAdmin.setVisible(true);
			panelContExtra.setVisible(false);
			panelCont.setVisible(false);
			panelRegis.setVisible(false);
			panelRegisExtra.setVisible(false);
			panelCarro.setVisible(false);
			panelCarroExtra.setVisible(false);
			panelEntrar.setVisible(false);
			panelEntrarExtra.setVisible(false);
			panelRopa.setVisible(false);
			panelComplemento.setVisible(false);
			
			break;
			
		case "Entrar" :
			
			panelEntrar.setPreferredSize( new Dimension( 430,500 ) );
			panelEntrar.setBackground(SystemColor.activeCaption);
			
			panelEntrar.pasarSesion(sesion);
			sesion = panelEntrar.devolverSesion();
			
			this.add(panelEntrar, BorderLayout.WEST);
				
					
			panelEntrarExtra.setPreferredSize( new Dimension( 430,500 ) );
			panelEntrarExtra.setBackground(SystemColor.activeCaption);
			this.add(panelEntrarExtra, BorderLayout.EAST);
			
			panelContExtra.setVisible(false);
			panelCont.setVisible(false);
			panelAdmin.setVisible(false);
			panelAdminExtra.setVisible(false);
			panelRegis.setVisible(false);
			panelRegisExtra.setVisible(false);
			panelCarro.setVisible(false);
			panelCarroExtra.setVisible(false);
			panelEntrar.setVisible(true);
			panelEntrarExtra.setVisible(true);
			panelRopa.setVisible(false);
			panelComplemento.setVisible(false);
			
			break;
			
		case "Registro" :		
			
			panelRegis.setPreferredSize( new Dimension( 430,500 ) );
			panelRegis.setBackground(SystemColor.activeCaption);
			
			panelRegis.pasarSesion(sesion);
			
			this.add(panelRegis, BorderLayout.WEST);
				
					
			panelRegisExtra.setPreferredSize( new Dimension( 430,500 ) );
			panelRegisExtra.setBackground(SystemColor.activeCaption);
			this.add(panelRegisExtra, BorderLayout.EAST);
			
			panelRegisExtra.setVisible(true);
			panelRegis.setVisible(true);
			panelContExtra.setVisible(false);
			panelCont.setVisible(false);
			panelAdmin.setVisible(false);
			panelAdminExtra.setVisible(false);
			panelCarro.setVisible(false);
			panelCarroExtra.setVisible(false);
			panelEntrar.setVisible(false);
			panelEntrarExtra.setVisible(false);
			panelRopa.setVisible(false);
			panelComplemento.setVisible(false);
			
			break;
			
			
		case "Email" :
			
					
			panelCont.setPreferredSize (new Dimension (430, 500));
			panelCont.setBackground(SystemColor.activeCaption);
			
			panelCont.pasarSesion(sesion);
			
			this.add(panelCont, BorderLayout.WEST);
			
			panelContExtra.setPreferredSize (new Dimension (430, 500));
			panelContExtra.setBackground(SystemColor.activeCaption);
			this.add(panelContExtra, BorderLayout.EAST);
			
			panelContExtra.setVisible(true);
			panelCont.setVisible(true);
			panelAdmin.setVisible(false);
			panelAdminExtra.setVisible(false);
			panelRegis.setVisible(false);
			panelRegisExtra.setVisible(false);
			panelCarro.setVisible(false);
			panelCarroExtra.setVisible(false);
			panelEntrar.setVisible(false);
			panelEntrarExtra.setVisible(false);
			panelRopa.setVisible(false);
			panelComplemento.setVisible(false);
						
			break;
			
			
		case "Carro" : 
			
			panelCarroExtra.setPreferredSize (new Dimension (430, 500));
			panelCarroExtra.setBackground(SystemColor.activeCaption);
			this.add(panelCarroExtra, BorderLayout.WEST);
			
			panelCarro.setPreferredSize (new Dimension (430, 500));
			panelCarro.setBackground(SystemColor.activeCaption);
			
			panelCarro.pasarSesion(sesion);
			
			this.add(panelCarro, BorderLayout.EAST);
			
			panelAdmin.setVisible(false);
			panelAdminExtra.setVisible(false);
			panelRegis.setVisible(false);
			panelRegisExtra.setVisible(false);
			panelCont.setVisible(false);
			panelContExtra.setVisible(false);
			panelCarro.setVisible(true);
			panelCarroExtra.setVisible(true);
			panelEntrar.setVisible(false);
			panelEntrarExtra.setVisible(false);
			panelRopa.setVisible(false);
			panelComplemento.setVisible(false);
			
			break;
			
		case "Menu" : 
			
			panelAdmin.setVisible(false);
			panelAdminExtra.setVisible(false);
			
			panelRegis.setVisible(false);
			panelRegisExtra.setVisible(false);
			panelCont.setVisible(false);
			panelContExtra.setVisible(false);
			panelCarro.setVisible(false);
			panelCarroExtra.setVisible(false);
			panelEntrar.setVisible(false);
			panelEntrarExtra.setVisible(false);
			
				
			panelRopa.pasarSesion(sesion);
			panelRopa.setVisible(true);
						
			panelComplemento.pasarSesion(sesion);
			panelComplemento.setVisible(true);
			
			break;
			
		case "Salir":
			this.setVisible(false);
			break;
			
			
		case "Logout":
			
			sesion.setNombreusuario("");
			sesion.setNombreapellido("");
			sesion.setCiudad("");
			sesion.setEmail("");
			sesion.setContraseña("");
			
			JOptionPane.showMessageDialog(this, "Sesión cerrada");
			
		
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		frmPrincipal objPrincipal = new frmPrincipal ();
		objPrincipal.setVisible(true);
	
				
		BaseDeDatos.initBD("Kenshi.bd");
		BaseDeDatos.crearTablaBD();
		BaseDeDatos.inicializarValores();
			
		
	}

}

