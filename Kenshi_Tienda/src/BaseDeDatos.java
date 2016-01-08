import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JOptionPane;


public class BaseDeDatos {

	
	public BaseDeDatos() {
		
		//para inicializar la base de datos
	}
	
	
	//GENÉRICO
		
	private static Connection connection = null;
	private static Statement statement = null;

	/** Inicializa una BD SQLITE y devuelve una conexión con ella. Debe llamarse a este 
	 * método antes que ningún otro, y debe devolver no null para poder seguir trabajando con la BD.
	 * @param nombreBD	Nombre de fichero de la base de datos
	 * @return	Conexión con la base de datos indicada. Si hay algún error, se devuelve null
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
	
	/** Cierra la conexión con la Base de Datos
	 */
	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** Devuelve la conexión si ha sido establecida previamente (#initBD()).
	 * @return	Conexión con la BD, null si no se ha establecido correctamente.
	 */
	public static Connection getConnection() {
		return connection;
	}
	
	/** Devuelve una sentencia para trabajar con la BD,
	 * si la conexión si ha sido establecida previamente (#initBD()).
	 * @return	Sentencia de trabajo con la BD, null si no se ha establecido correctamente.
	 */
	public static Statement getStatement() {
		return statement;
	}
	
	
	
	
	//CREACION DE NUESTRA BASE DE DATOS
	
	
	public boolean chequearYaEnTabla( Statement st ) {
		try {
			String sentSQL = "select * from cliente ";
					//"where (fichero = '" + file.getAbsolutePath() + "')";
			System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
			ResultSet rs = st.executeQuery( sentSQL );
			if (rs.next()) {  // Normalmente se recorre con un while, pero aquí solo hay que ver si ya existe
				rs.close();
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
/*	public void getValues(String table_name) {
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
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            
            //Si aqui sale error se crea la tabla, si no no 
        }
    }*/
	
	public static void crearTablaBD() {
		if (statement==null) return;
		
		try {
			statement.executeUpdate
			
					("create table if not exists cliente (nombreusuario text, nombreapellido text, ciudad string, email string, contraseña string)" +
							
					"create table if not exists pedido (numeroPedido integer, fecha date, codigo integer, nombreusuario text)"+
				
					
					"create table if not exists productoRopa (codigo integer, nombre text, descripcion text, precio integer, talla text, material text, estilo text)" +
					
					"create table if not exists productoComplemento (codigotipo integer, nombre text, descripcion text, precio integer, material text, origen text)" 
					
					);
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			e.printStackTrace();  
		}
	}
	
	
	public static void inicializarValores(){
		
		
		//ponemos unos datos de prueba. pero antes probamos que los datos no estén
		
		
	}
	
	
	//GESTION DE NUESTRA BASE DE DATOS
	
	
	public void insertarCliente (Cliente cliente){
		
		
		String nombreUsuario = cliente.getNombreusuario();
		String nombre = cliente.getNombreapellido();
		String ciudad = cliente.getCiudad();
		String email = cliente.getEmail();
		String contra = cliente.getContraseña();
		

		//final String sent = "insert into cliente values nombreusuario, nombre, ciudad, email, contra";
		
		try {
			String Query = "INSERT INTO cliente VALUES("
	                + " ' " + nombreUsuario + " ', "
	                + " ' " + nombre + " ', "
	                + " ' " + ciudad + " ', "
	                + " ' " + email + " ', "
	                + " ' " + contra + " ')";
	        Statement st = connection.createStatement();
	        st.executeUpdate(Query);
	        JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
	        
			} catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
	    }
	}
	
	
	public void insertarProductoRopa (Producto producto, Ropa ropa) { 
		
		int codigo = producto.getCodigo();
		String nombre = producto.getNombre();
		String descripcion = producto.getDescripcion();
		int precio = producto.getPrecio();
		String talla = ropa.getTalla();
		String material = ropa.getMaterial();
		String estilo = ropa.getEstilo();
		//int existencias = producto.getExistencias();
		//int tipoProducto = producto.getTipoProducto();
		
		
		//Ya sabemos estos datos, por lo que meterlos a mano
		try {
			
		statement.executeUpdate( "insert into productoRopa values (01, 'Jersey', 'Azul. Cuello redondo', 20,'L', 'Algodon', 'Hipster')");
		statement.executeUpdate( "insert into productoRopa values (02, 'Jersey', 'Verde. Cuello redondo', 20, 'S', 'Algodon', 'Hipster')");
		statement.executeUpdate( "insert into productoRopa values (03, 'Jersey', 'Rojo. Cuello redondo', 20, 'L', 'Algodon', 'Hipster')");
		statement.executeUpdate( "insert into productoRopa values (04, 'Jersey', 'Azul. Cuello redondo', 20, 'L', 'Algodon', 'Hipster')");
		

		} 
		catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
    }
		
	}
	
public void insertarProductoComplemento (Producto producto, Complemento complemento) { 
		
		int codigo = producto.getCodigo();
		String nombre = producto.getNombre();
		String descripcion = producto.getDescripcion();
		int precio = producto.getPrecio();
		String material = complemento.getMaterial();
		String origen = complemento.getOrigen();
		
		//int existencias = producto.getExistencias();
		//int tipoProducto = producto.getTipoProducto();
		
		
		//Ya sabemos estos datos, por lo que meterlos a mano
		
	
		try {
			
		statement.executeUpdate( "insert into productoComplemento values (11, 'Collar', 'Gargantilla', 10, 'Plata', 'Étnico')");
		statement.executeUpdate( "insert into productoComplemento values (12, 'Collar', 'Ópera', 16, 'Cuerdas', 'Hawaiano')");
		statement.executeUpdate( "insert into productoComplemento values (13, 'Bufanda', 'Negra', 19.5, 'Algodon', 'Australiano')");
		statement.executeUpdate( "insert into productoComplemento values (14, 'Pulsera', 'Brazalete', 40, 'Oro', 'Árabe')");
		

		} 
		catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
    }
		
	}
	
	
	
	public void insertarPedido (Pedido pedido, Cliente cliente){
		
		int numeroPedido = pedido.getNumeroPedido();
		Date fecha = pedido.getFecha();
		int codigo = pedido.getCodigo();
		String nombreusuario = cliente.getNombreusuario();
		
		try {
			String Query = "INSERT INTO pedido VALUES("
	                + " '" + numeroPedido + " ', "
	                + " '" + fecha + " ', "
	                + " '" + codigo + " ', "
	                + " '" + nombreusuario + " ')";
	        Statement st = connection.createStatement();
	        st.executeUpdate(Query);
	        JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
	        
			} catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
	    }
		
	}
	
	
	
	
}
