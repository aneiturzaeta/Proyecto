import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//mail


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class PanelContacto extends JPanel implements ActionListener{
	
	private JLabel textAsunto;
	private JTextField Asunto;
	private JTextArea Cuerpo;
	private JLabel textCuerpo;
	private JButton BEnviar;
	
	private Cliente sesion;
	
//	mail
//	http://crunchify.com/java-mailapi-example-send-an-email-via-gmail-smtp/
	
	
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;	
	
	
	
	public PanelContacto (){
		
		setLayout(null);
		
		textAsunto = new JLabel();
		textAsunto.setText("Asunto \r\n");
		textAsunto.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textAsunto.setBounds(50, 45, 80, 25);
		add(textAsunto);
		
		
		Asunto = new JTextField();
//		textCont.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Asunto.setBounds(105, 45, 195, 25);
		Asunto.setColumns(10);
		add(Asunto);

		
		textCuerpo = new JLabel();
		textCuerpo.setText("Cuerpo del mensaje \r\n");
		textCuerpo.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textCuerpo.setBounds(50, 85, 280, 25);
		add(textCuerpo);
		
		
		
		Cuerpo = new JTextArea();
//		textCuerpo.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Cuerpo.setBackground(Color.WHITE);
		Cuerpo.setEditable(true);
		Cuerpo.setBounds(50, 10+110, 300, 250);
		add(Cuerpo);
		
		BEnviar = new JButton("Enviar");
		BEnviar.setSize(100, 32);
		BEnviar.setLocation(156, 380);
		BEnviar.setFont(new Font("Century Gothic", Font.BOLD, 16));
//		BSalir.setBounds(100, 103, 150, 30);
		BEnviar.addActionListener(this);
		BEnviar.setActionCommand("Enviar");
		BEnviar.setContentAreaFilled(false);
		BEnviar.setBorderPainted(false);
		add(BEnviar);
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			
		switch(e.getActionCommand()){
		
		
			case "Enviar":
		
		
				String cuerpo = Cuerpo.getText();
				String asunto = Asunto.getText();
				
				
				//se enviara el email
				
				try {
					
					comprobarCuerpo (cuerpo);
									 	
					enviar(asunto, cuerpo);
					
					JOptionPane.showMessageDialog(this, "Email enviado con exito! Muchas gracias por contactar con nosotras. \n Le responderemos lo antes posible");
				
					Asunto.setText("");
					Cuerpo.setText("");
					
				
				}
					
				catch (ExcepContacto e1) {
				
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e1.Informar());
				} catch (AddressException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
					
			
			break;
		
		}
		
		
		
	}



	private void comprobarCuerpo(String cuerpo) throws ExcepContacto{
		// TODO Auto-generated method stub
		if (cuerpo.equals("")){
			 
			throw new ExcepContacto ();
		}
		
	}
	
	
	private void enviar(String asunto, String cuerpo) throws AddressException, MessagingException {
		// TODO Auto-generated method stub

 		 
			// Step1
			System.out.println("\n 1st ===> setup Mail Server Properties..");
			mailServerProperties = System.getProperties();
			mailServerProperties.put("mail.smtp.port", "587");
			mailServerProperties.put("mail.smtp.auth", "true");
			mailServerProperties.put("mail.smtp.starttls.enable", "true");
			System.out.println("Mail Server Properties have been setup successfully..");
	 
			// Step2
			System.out.println("\n\n 2nd ===> get Mail Session..");
			getMailSession = Session.getDefaultInstance(mailServerProperties, null);
			generateMailMessage = new MimeMessage(getMailSession);
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("aneiturzaeta@gmail.com"));
//			generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
			generateMailMessage.setSubject(asunto);
			
			String nombreUsuario;
			String email;
			
			if (sesion.getNombreusuario()!= null && !sesion.getNombreusuario().isEmpty()){
				
				nombreUsuario= sesion.getNombreusuario();
				
				email = sesion.getEmail();
				
			}
			
			else {
				
				nombreUsuario = "Anonimo";
				
				email = "desconocido";
				
			}
			
			
			
			String emailBody = cuerpo + "Email mandado desde el usuario: " + nombreUsuario + " con email : " + email + ". Este email esta mandado por la aplicacion de Ane y Leire";
			generateMailMessage.setContent(emailBody, "text/html");
			System.out.println("Mail Session has been created successfully..");
	 
			// Step3
			System.out.println("\n\n 3rd ===> Get Session and Send mail");
			Transport transport = getMailSession.getTransport("smtp");
	 
			// Enter your correct gmail UserID and Password
			// if you have 2FA enabled then provide App Specific Password
			transport.connect("smtp.gmail.com", "leireaneprogramazioa@gmail.com", "123456ane");
			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
			transport.close();
		}
		
	
	public void sesion(Cliente sesion) {
		
		
		this.sesion = sesion;
	
	}
	
		
}
	

