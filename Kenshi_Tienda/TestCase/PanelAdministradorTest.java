import static org.junit.Assert.fail;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



//import PanelRegistro;


public class PanelAdministradorTest extends TestCase{
	
	
	private PanelAdministrador pAdmin;
	private String contraseņa1;
	private String contraseņa2;
	
	

	
	@Before
	 public void setUp() throws Exception {
		
		pAdmin = new PanelAdministrador();
	 
		contraseņa1 = "2"; //esta mal
		contraseņa2 = "1"; //esta bien
		
			
	 } 
	
	@After
	 public void tearDown() {
	 
			
	 }
	
	@Test
	public void testNotNull() {
		
		
		assertNotNull(pAdmin);
		
	}


	@Test (expected = ExcepAdminKo.class)
	public void testComprobarContra() throws ExcepAdminKo {
		
		pAdmin = new PanelAdministrador();
		


		
		pAdmin.comprobarContra(contraseņa2);
				
	}
	

	
	
}
