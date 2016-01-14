
public class Complemento extends Producto  {

	
	private String material;
	private String origen;

	
	
	
	public Complemento(String codigo, String nombre, String descripcion, String precio, String material, String origen) {
		super(codigo, nombre, descripcion, precio);
		this.material = material;
		this.origen = origen;
	}




	public String getMaterial() {
		return material;
	}




	public void setMaterial(String material) {
		this.material = material;
	}




	public String getOrigen() {
		return origen;
	}




	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
		
	
	
	
}
