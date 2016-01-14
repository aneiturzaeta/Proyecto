import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
				
		
			statement.executeUpdate(sentencia);
			
			statement.executeUpdate(sentencia2);
	
		} catch (SQLException e) {
			// Si hay excepción es que la tabla ya existía (lo cual es correcto)
			e.printStackTrace();  
		}
	}
	
	
	public static void inicializarValores(){
		
		boolean ok = comprobarInicializados();
		
		
		if (ok ==false){
			
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
		
		
		else System.out.println("Tabla ya inicializada con usuario ane y leire, con las mismas contraseñas");
	}

	
	private static  boolean comprobarInicializados() {
		// TODO Auto-generated method stub
		
		boolean ok= false;
		
		try {
		
			String query = "SELECT NOMBREUSUARIO FROM CLIENTE WHERE NOMBREUSUARIO = 'ane'";
				
			ResultSet rs = statement.executeQuery (query);
			
			String nombre = rs.getString(1);
			
			if (nombre.equals("ane")){
				
				ok = true;
			
					
			}
			
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return ok;
	}
	
	
	//GESTION DE NUESTRA BASE DE DATOS
	
	


	public static void insertarCliente (Cliente cliente){ //se le llamara desde Registro de clientes
		
		
		String nombreUsuario = cliente.getNombreusuario();
		String nombre = cliente.getNombreapellido();
		String ciudad = cliente.getCiudad();
		String email = cliente.getEmail();
		String contra = cliente.getContraseña();
		

		try {
			String Query = "INSERT INTO CLIENTE VALUES( '" + nombreUsuario + "', '" + nombre + "', '" + ciudad + "', '" + email + "', '" + contra + "')";
			

			statement.executeUpdate(Query);
			
		
	        JOptionPane.showMessageDialog(null, "Usuario almacenado de forma exitosa");
	        
			} catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
	    }
	}
	
	
	
	public static void insertarPedido (String codigo, String fecha, String nombreusuario){
		
				
		try {
			String Query = "INSERT INTO PEDIDO VALUES('" + codigo + "', '"+ fecha + "', '" + nombreusuario + "') " ;	       

			
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
			
			ResultSet rs = statement.executeQuery ("SELECT NOMBREUSUARIO FROM CLIENTE");
		     
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
	
public static Cliente sacarCliente(String nombreusuario){
		
		
	Cliente cliente = new Cliente("","","","","");
		
		try {
			
			String query = "SELECT * FROM CLIENTE WHERE NOMBREUSUARIO = '" +nombreusuario+"'" ;
			
			ResultSet rs = statement.executeQuery (query);
		     
			while(rs.next())
		     
				{
		        
				cliente = new Cliente (rs.getString("NOMBREUSUARIO"),rs.getString("NOMBREAPELLIDO"), rs.getString("CIUDAD"), rs.getString("EMAIL"), rs.getString("CONTRASEÑA"));
				
				return cliente;
				
		      }	
		rs.close();
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "No se ha podido realizar operacion SQL");
			
		}
		
		return cliente;
	}
	
	
	
	
	
	
	public static ResultSet buscarPedidos(String nombreusuario){
		
	
			try {
								
			System.out.println(nombreusuario);
				
			String query = "SELECT * FROM PEDIDO WHERE NOMBREUSUARIO = " + "'"+  nombreusuario + "'";
			
		
			ResultSet rs = statement.executeQuery (query);
						
//			ResultSetMetaData metadata = rs.getMetaData();
//			int numcols = metadata.getColumnCount();
//			
//			List<List<String>> result = new ArrayList<>();  // List of list, one per row
//			
//			while (rs.next()) {
//			  
//				
//				List<String> row = new ArrayList<>(numcols); // new list per row
//			   
//				int i = 1;
//			    while (i <= numcols) {  // don't skip the last column, use <=
//			        row.add(rs.getString(i++));
//			    }
//			    result.add(row); // add it to the result
//			}
//			
//			if(result.isEmpty()){
//			
//			System.out.println("vacio");
//		}
//			
			
//			rs.close();	
				
			return rs;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
			
	return null;
		
				
	}
		
}
