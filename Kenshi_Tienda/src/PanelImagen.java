
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class PanelImagen extends JPanel 
{
 
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Image bgImage;
 
 public PanelImagen() 
 {
  super();
 
  // Hacemos que el panel sea transparente
  this.setOpaque(false);
 }
 
 /**
  * Lo utilizaremos para establecerle su imagen de fondo.
  * @param bgImage La imagen en cuestion
  */
 public void setBackgroundImage(Image bgImage) {
  this.bgImage = bgImage;
 }
 
 
  
 public ImageIcon createImage(String path) {
  URL imgURL = getClass().getResource(path);
     if (imgURL != null) {
    	 //return new Image(imgURL);
    	 return new ImageIcon(imgURL);
         
     } else {
         System.err.println("Couldn't find file: " + path);
         return null;
     }
 }
 
 @Override
 public void paint(Graphics g) 
 {
 
  // Pintamos la imagen de fondo...
  if(bgImage != null) 
  {
   g.drawImage(bgImage, 0, 0, null);
  }
 
  // Y pintamos el resto de cosas que pueda tener el panel
  super.paint(g);
 
 }
}
