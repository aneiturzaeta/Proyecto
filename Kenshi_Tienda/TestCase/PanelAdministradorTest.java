import static org.junit.Assert.fail;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



//import PanelRegistro;


public class PanelAdministradorTest extends TestCase{
	
	
	private PanelAdministrador pAdmin;
	private String contraseña1;
	private String contraseña2;
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	@Before
	 public void setUp() throws Exception {
		
		pAdmin = new PanelAdministrador();
	 
		contraseña1 = "2"; //esta mal
		contraseña2 = "1"; //esta bien
		
			
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
		


		
		pAdmin.comprobarContra(contraseña2);
				
	}
	

	
	
}
