import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;


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
	
	
	public void getValues(String table_name) {
        try {
            String Query = "SELECT * FROM " + table_name;
            Statement st = connection.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);
 
            while (resultSet.next()) {
                System.out.println("Codigo: " + resultSet.getString("Codigo") + " "
                        + "Nombre: " + resultSet.getString("Nombre") + " " + resultSet.getString("Apellido") + " "
                        + "Ciudad: " + resultSet.getString("Ciudad"));
            }
 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisici�n de datos");
            
            //Si aqui sale error se crea la tabla, si no no 
        }
    }
	
	public static void crearTablaBD() {
		if (statement==null) return;
		
		try {
			statement.executeUpdate
			
					("create table if not exists cliente (nombreusuario text, nombreapellido text, ciudad string, email string, contrase�a string)" +
							
					"create table if not exists pedido (numeroPedido integer, fecha date, codigo integer, nombreusuario text)"+
					
					"create table if not exists pedido_producto (cantidad text, fecha date, numeropedido integer, codigoproducto integer)" +
					
					"create table if not exists producto (codigo integer, nombre text, descripcion text)" +
					
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
		
		try {
			String Query = "INSERT INTO " + cliente + " VALUES("
	                + "\"" + nombreUsuario + "\", "
	                + "\"" + nombre + "\", "
	                + "\"" + ciudad + "\", "
	                + "\"" + email + "\", "
	                + "\"" + contra + "\")";
	        Statement st = connection.createStatement();
	        st.executeUpdate(Query);
	        JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
	        
			} catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
	    }
	}
	
	
	public void insertarProducto (Producto producto) { //puede ser ropa o complemento
		
		int codigo = producto.getCodigo();
		String nombre = producto.getNombre();
		String descripcion = producto.getDescripcion();
		int precio = producto.getPrecio();
		int existencias = producto.getExistencias();
		int tipoProducto = producto.getTipoProducto();
		
		
		//material , talla,.....?
		//como diferenciar ropa y complemento ??
		
		
		//Ya sabemos estos datos, por lo que meterlos a mano
		try {
			
		statement.executeUpdate( "insert into producto values (01, 'Jersey', 'Azul. Cuello redondo', 20, 10)");
		statement.executeUpdate( "insert into producto values (02, 'Jersey', 'Verde. Cuello redondo', 20, 10)");
		statement.executeUpdate( "insert into producto values (03, 'Jersey', 'Rojo. Cuello redondo', 20, 10)");
		statement.executeUpdate( "insert into producto values (04, 'Jersey', 'Azul. Cuello redondo', 20, 10)");
		
		/*String Query = "INSERT INTO " + producto + " VALUES("
                + "\"" + codigo + "\", "
                + "\"" + nombre + "\", "
                + "\"" + descripcion + "\", "
                + "\"" + precio + "\", "
                + "\"" + existencias + "\", "
                + "\"" + tipoProducto + "\")";
        Statement st = connection.createStatement();
        st.executeUpdate(Query);
        JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        */
		} 
		catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
    }
		
	}
	
	
	
	public void insertarPedido (Pedido pedido){
		
		int numeroPedido = pedido.getNumeroPedido();
		Date fecha = pedido.getFecha();
		int codigo = pedido.getCodigo();
		String nombreusuario = pedido.getNombreusuario();
		
		try {
			String Query = "INSERT INTO " + pedido + " VALUES("
	                + "\"" + numeroPedido + "\", "
	                + "\"" + fecha + "\", "
	                + "\"" + codigo + "\", "
	                + "\"" + nombreusuario + "\")";
	        Statement st = connection.createStatement();
	        st.executeUpdate(Query);
	        JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
	        
			} catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
	    }
		
	}
	
	
	
	
}
