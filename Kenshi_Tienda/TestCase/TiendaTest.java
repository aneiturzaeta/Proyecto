import static org.junit.Assert.fail;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



//import PanelRegistro;


public class TiendaTest extends TestCase{
	
	
	private PanelRegistro usuario;
	
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	@Before
	 public void setUp() throws Exception {
	 
	 } 
	
	@After
	 public void tearDown() {
	 
	 }
	
	@Test
	public void testNotNull() {
		
		usuario = new PanelRegistro();
		assertNotNull(usuario);
		
	}
	
	@Test
	public void testEquals() {
		
		//Podemos hacer con usuario o contraseña
	}

	
}
