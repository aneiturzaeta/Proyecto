import java.util.Date; //o sql????


public class Pedido {

	
	private String fecha;
	private String codigo;
	private String nombreusuario;
	
	
	
	public Pedido(String fecha, String codigo, String nombreusuario) {
		super();
		
		this.fecha = fecha;
		this.codigo = codigo;
		this.nombreusuario = nombreusuario;
	}



	public String getFecha() {
		return fecha;
	}



	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public String getNombreusuario() {
		return nombreusuario;
	}



	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	
	
	
	
	
	
}
