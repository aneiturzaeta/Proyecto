
public class Producto {

	
	private int codigo;
	private String nombre;
	private String descripcion;
	private int precio;
	private int existencias;
	private int tipoProducto;
	
		

	public Producto() {
		super();
	}
	
	
	public Producto(int codigo, String nombre, String descripcion, int precio,
			int existencias, int tipoProducto) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.existencias = existencias;
		this.tipoProducto = tipoProducto;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public int getExistencias() {
		return existencias;
	}


	public void setExistencias(int existencias) {
		this.existencias = existencias;
	}


	public int getTipoProducto() {
		return tipoProducto;
	}


	public void setTipoProducto(int tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	
	
	
}