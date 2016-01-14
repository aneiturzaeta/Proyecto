import java.sql.ResultSet;
import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PanelRegistroTest extends TestCase{

	private PanelRegistro pRegis ;
	private String nombreUsuario ;
	private PanelRopa pRopa ;
	
	private Cliente cliente ;
	
	private Cliente sesion;
	private Cliente sesion1;
	
	
	
	@Before
	 public void setUp() throws Exception {
		
		pRegis = new PanelRegistro();
		pRopa = new PanelRopa();
		
		nombreUsuario = "";
			
			
	 } 
	
	@After
	 public void tearDown() {
	 
			
	 }
	
	@Test
	public void testNotNull() {
		
		
		assertNotNull(pRegis);
		
	}
	
	@Test
	public void testSesion() {
		
		pRegis.pasarSesion(sesion);
		
		pRopa.pasarSesion(sesion1);
		
		assertEquals(sesion1, sesion);
		
	}
	
	
	
	
	
}
