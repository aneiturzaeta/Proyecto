import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		
			String sentencia = "CREATE TABLE IF NOT EXISTS CLIENTE (NOMBREUSUARIO TEXT, NOMBREAPELLIDO TEXT, CIUDAD TEXT, EMAIL TEXT, CONTRASEÑA TEXT)";
							
			String sentencia2= "CREATE TABLE IF NOT EXISTS PEDIDO (CODIGO TEXT, FECHA TEXT, NOMBREUSUARIO TEXT)";
				
					
//					" + create table if not exists productoRopa (codigo integer, nombre text, descripcion text, precio integer, talla text, material text, estilo text)" +

//					"create table if not exists productoComplemento (codigotipo integer, nombre text, descripcion text, precio integer, material text, origen text)" 
					
			
			statement.executeUpdate(sentencia);
			
			statement.executeUpdate(sentencia2);
	
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			e.printStackTrace();  
		}
	}
	
	
	public static void inicializarValores(){
		
		
		try {
			
			
			String sentenciaInicial = "INSERT INTO CLIENTE VALUES('ane', 'Ane Iturzaeta', 'Beasain', 'aneiturzaeta@opendeusto.es', 'ane')"; 
			
			String sentenciaInicial2= "INSERT INTO CLIENTE VALUES('leire', 'Leire Jauregi', 'Legazpi', 'leire.jauregi@opendeusto.es', 'leire')"; 
					
			
		statement.executeUpdate(sentenciaInicial);
		
		statement.executeUpdate(sentenciaInicial2);
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	
	//GESTION DE NUESTRA BASE DE DATOS
	
	
	public static void insertarCliente (Cliente cliente){ //se le llamara desde Registro de clientes
		
		
		String nombreUsuario = cliente.getNombreusuario();
		String nombre = cliente.getNombreapellido();
		String ciudad = cliente.getCiudad();
		String email = cliente.getEmail();
		String contra = cliente.getContraseña();
		

		try {
			String Query = "INSERT INTO CLIENTE VALUES( ' " + nombreUsuario + " ', ' " + nombre + " ', ' " + ciudad + " ', ' " + email + " ', ' " + contra + " ')";
			

			statement.executeUpdate(Query);
			
		
	        JOptionPane.showMessageDialog(null, "Usuario almacenado de forma exitosa");
	        
			} catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
	    }
	}
	
	
//	public void insertarProductoRopa (Producto producto, Ropa ropa) { 
//		
//		int codigo = producto.getCodigo();
//		String nombre = producto.getNombre();
//		String descripcion = producto.getDescripcion();
//		int precio = producto.getPrecio();
//		String talla = ropa.getTalla();
//		String material = ropa.getMaterial();
//		String estilo = ropa.getEstilo();
//		//int existencias = producto.getExistencias();
//		//int tipoProducto = producto.getTipoProducto();
//		
//		
//		//Ya sabemos estos datos, por lo que meterlos a mano
//		try {
//			
//		statement.executeUpdate( "insert into productoRopa values (01, 'Jersey', 'Azul. Cuello redondo', 20,'L', 'Algodon', 'Hipster')");
//		statement.executeUpdate( "insert into productoRopa values (02, 'Jersey', 'Verde. Cuello redondo', 20, 'S', 'Algodon', 'Hipster')");
//		statement.executeUpdate( "insert into productoRopa values (03, 'Jersey', 'Rojo. Cuello redondo', 20, 'L', 'Algodon', 'Hipster')");
//		statement.executeUpdate( "insert into productoRopa values (04, 'Jersey', 'Azul. Cuello redondo', 20, 'L', 'Algodon', 'Hipster')");
//		
//
//		} 
//		catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
//    }
//		
//				
//		try {
//			String Query = "INSERT INTO ropa VALUES("
//	                + " ' " + codigo + " ', "
//	                + " ' " + descripcion + " ', "
//	                + " ' " + ciudad + " ', "
//	                + " ' " + email + " ', "
//	                + " ' " + contra + " ')";
//	        Statement st = connection.createStatement();
//	        st.executeUpdate(Query);
//	        JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
//	        
//			} catch (SQLException ex) {
//	        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
//	    }
//		
//	}
//	
//public void insertarProductoComplemento (Producto producto, Complemento complemento) { 
//		
//		int codigo = producto.getCodigo();
//		String nombre = producto.getNombre();
//		String descripcion = producto.getDescripcion();
//		int precio = producto.getPrecio();
//		String material = complemento.getMaterial();
//		String origen = complemento.getOrigen();
//		
//		//int existencias = producto.getExistencias();
//		//int tipoProducto = producto.getTipoProducto();
//		
//		
//		//Ya sabemos estos datos, por lo que meterlos a mano
//		
//	
//		try {
//			
//		statement.executeUpdate( "insert into productoComplemento values (11, 'Collar', 'Gargantilla', 10, 'Plata', 'Étnico')");
//		statement.executeUpdate( "insert into productoComplemento values (12, 'Collar', 'Ópera', 16, 'Cuerdas', 'Hawaiano')");
//		statement.executeUpdate( "insert into productoComplemento values (13, 'Bufanda', 'Negra', 19.5, 'Algodon', 'Australiano')");
//		statement.executeUpdate( "insert into productoComplemento values (14, 'Pulsera', 'Brazalete', 40, 'Oro', 'Árabe')");
//		
//
//		} 
//		catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
//    }
//		
//	}
	
	
	
	public static void insertarPedido (String codigo, String nombreUsuario, String fecha){
		
				
		try {
			String Query = "INSERT INTO PEDIDO VALUES('" + codigo + " ', ' "+ fecha + " ', '" + nombreUsuario + " ') " ;	       

			
			statement.executeUpdate(Query);
			
	        JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
	        
			} catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
	    }
		
	}

	public static void borrarPedidos(Cliente sesion) {
		// TODO Auto-generated method stub
	
		
			try {
			
			
			statement.executeUpdate("DELETE FROM PEDIDO WHERE NOMBREUSUARIO = " + "'" + sesion.getNombreusuario() + "'"
			
			);
		
			JOptionPane.showMessageDialog(null, "Todos sus pedidos borrados");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "Pedidos no borrados. Ha habido un problema");
			
		}
	
	
		
	}
	
	
	public static int comprobarUsuario(String nombreUsuario){
		
		
		int comprobacion = 0;
		
				
		try {
			
			ResultSet rs = statement.executeQuery ("SELECT NOMBREUSUARIO FROM USUARIO");
		     
			while(rs.next())
		     
				{
		        
				if (rs.getString("nombreusuario").equals(nombreUsuario)) {
					
					comprobacion = 1;
					
					return comprobacion;
					
				}
				
				else comprobacion = 0;
				
		      }
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			comprobacion = 0;
			
		}
		
		
		
		
		return comprobacion;
		
		
	}
	
	
	public static int comprobarUsuarioContraseña(String nombreusuario, String contraseña){
		
		
		int ok= 0;
		
		try {
			
			String query = "SELECT NOMBREUSUARIO, CONTRASEÑA FROM CLIENTE";
			
			ResultSet rs = statement.executeQuery (query);
		     
			while(rs.next())
		     
				{
		        
				if (rs.getString("NOMBREUSUARIO").equals(nombreusuario)) {
					
					
					if (rs.getString("CONTRASEÑA").equals(contraseña)){
						
						ok = 1;						
						
						return ok;
					}	
					
					else ok = 0;
					
				}
				
				else ok = 0;
				
		      }	
		rs.close();
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "No se ha podido realizar operacion SQL");
			
		}
		
		return ok;
	}
	
	
	public static ArrayList<Pedido> buscarPedidos(String nombreusuario){
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		
			try {
								
				
			String query = "SELECT CODIGO, FECHA FROM PEDIDO WHERE NOMBREUSUARIO = " + "'"+  nombreusuario + "'";
			
			ResultSet rs;
			
			rs = statement.executeQuery (query);
			
			while(rs.next())
		     
				{		       
				
				Pedido pedido = new Pedido(rs.getString("CODIGO"),rs.getString("FECHA"), rs.getString("NOMBREUSUARIO"));
				
				pedidos.add(pedido);
								
				}	
			
			rs.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
			
	return pedidos;
		
		
		
	}
		
}
