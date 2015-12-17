import java.util.Date; //o sql????


public class Pedido {

	
	private int numeroPedido;
	private Date fecha;
	private int codigo;
	private String nombreusuario;
	
	
	
	public Pedido(int numeroPedido, Date fecha, int codigo,
			String nombreusuario) {
		super();
		this.numeroPedido = numeroPedido;
		this.fecha = fecha;
		this.codigo = codigo;
		this.nombreusuario = nombreusuario;
	}



	public int getNumeroPedido() {
		return numeroPedido;
	}



	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombreusuario() {
		return nombreusuario;
	}



	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	
	
	
	
	
	
}
