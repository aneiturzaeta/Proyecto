import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.JOptionPane;


public class ExcepAdminKo extends Exception {


		public String Informar(int maxFallos, int fallos){
			
			String salida;	
			
			if (fallos < maxFallos) {
			
			salida = "Error! Contraseña erronea o no insertada. Te quedan " + (3 - fallos) + " intentos";				
				
			}
			
			else {
				
				
			salida = "Se te han acabado los intentos";
				
				
			}
				
							
			return salida;
		}
		
		
		
}
	
	
