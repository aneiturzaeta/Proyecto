import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//mail




public class PanelContacto extends JPanel implements ActionListener{
	
	private JLabel textAsunto;
	private JTextField Asunto;
	private JTextArea Cuerpo;
	private JLabel textCuerpo;
	private JButton BEnviar;
	
	public PanelContacto (){
		
		setLayout(null);
		
		textAsunto = new JLabel();
		textAsunto.setText("Asunto \r\n");
		textAsunto.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textAsunto.setBounds(80, 95, 80, 25);
		add(textAsunto);
		
		
		Asunto = new JTextField();
//		textCont.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Asunto.setBounds(165, 95, 195, 25);
		Asunto.setColumns(10);
		add(Asunto);

		
		textCuerpo = new JLabel();
		textCuerpo.setText("Cuerpo del mensaje \r\n");
		textCuerpo.setFont(new Font("Century Gothic", Font.BOLD, 12));
		textCuerpo.setBounds(80, 70+85, 280, 25);
		add(textCuerpo);
		
		
		
		Cuerpo = new JTextArea();
//		textCuerpo.setFont(new Font("Century Gothic", Font.BOLD, 12));
		Cuerpo.setBackground(Color.WHITE);
		Cuerpo.setEditable(true);
		Cuerpo.setBounds(80, 80+110, 280, 90);
		add(Cuerpo);
		
		BEnviar = new JButton("Enviar");
		BEnviar.setSize(100, 32);
		BEnviar.setLocation(156, 290);
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
				
					 	
					//mandar email
					
					//JOptionPane.showInputDialog("Entrado bien");
				}
					
				catch (ExcepContacto e1) {
				
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this, e1.Informar());
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
}
	

