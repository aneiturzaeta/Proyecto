import java.util.Date; //o sql????


public class Pedido {

	
	private int numeroPedido;
	private Date fecha;
	private int pedido_cant;
	private String nombreusuario;
	
	
	
	public Pedido(int numeroPedido, Date fecha, int pedido_cant,
			String nombreusuario) {
		super();
		this.numeroPedido = numeroPedido;
		this.fecha = fecha;
		this.pedido_cant = pedido_cant;
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



	public int getPedido_cant() {
		return pedido_cant;
	}



	public void setPedido_cant(int pedido_cant) {
		this.pedido_cant = pedido_cant;
	}



	public String getNombreusuario() {
		return nombreusuario;
	}



	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	
	
	
	
	
	
}
