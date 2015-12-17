import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class BaseDeDatos {

	
	public BaseDeDatos() {
		
		//para inicializar la base de datos
	}
	
	
	//GEN�RICO
		
	private static Connection connection = null;
	private static Statement statement = null;

	/** Inicializa una BD SQLITE y devuelve una conexi�n con ella. Debe llamarse a este 
	 * m�todo antes que ning�n otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexi�n con la base de datos indicada. Si hay alg�n error, se devuelve null
	 */
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			statement = connection.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	
	/** Cierra la conexi�n con la Base de Datos
	 */
	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Devuelve la conexi�n si ha sido establecida previamente (#initBD()).
	 * @return	Conexi�n con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexi�n si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}
	
	
	
	
	//CREACION DE NUESTRA BASE DE DATOS
	
	public static void crearTablaBD() {
		if (statement==null) return;
		try {
			statement.executeUpdate
			
					("create table if not exists cliente (nombreusuario text, nombreapellido text, ciudad string, email string, contrase�a string)" +
							
					"create table if not exists pedido (numeropedido integer, fecha date, codigo integer, nombreusuario text)"+
					
					"create table if not exists pedido_producto (cantidad text, fecha date, numeropedido integer, codigoproducto integer)" +
					
					"create table if not exists producto (codigoproducto integer, nombre text, descripcion text)" +
					
					"create table if not exists tipoproducto (codigotipo integer, nombre text, descripcion text)" 
					
					);
		} catch (SQLException e) {
			// Si hay excepci�n es que la tabla ya exist�a (lo cual es correcto)
			e.printStackTrace();  
		}
	}
	
	
	public static void inicializarValores(){
		
		
		//ponemos unos datos de prueba. pero antes probamos que los datos no est�n
		
		
	}
	
	
	//GESTION DE NUESTRA BASE DE DATOS
	
	
	public void insertarCliente (Cliente cliente){
		
		
		String nombreUsuario = cliente.getNombreusuario();
		String nombre = cliente.getNombreapellido();
		String ciudad = cliente.getCiudad();
		String email = cliente.getEmail();
		String contra = cliente.getContrase�a();
		
		
		
		//final String sent = "insert into cliente values nombreusuario, nombre, ciudad, email, contra";
		
		
	}
	
	
	public void insertarProducto (Producto producto) { //puede ser ropa o complemento
		
		
		
	}
	
	
	
	public void insertarPedido (Pedido pedido){
		
		
		
		
		
	}
	
	
}
