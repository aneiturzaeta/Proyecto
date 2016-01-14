
public class Ropa extends Producto {

	
	private String talla;
	private String material;
	private String estilo;
	
	
	
	public Ropa(String codigo, String nombre, String descripcion, String precio, String talla, String material, String estilo) {
		super(codigo, nombre, descripcion, precio);
		this.talla = talla;
		this.material = material;
		this.estilo = estilo;
	}



	public String getTalla() {
		return talla;
	}



	public void setTalla(String talla) {
		this.talla = talla;
	}



	public String getMaterial() {
		return material;
	}



	public void setMaterial(String material) {
		this.material = material;
	}



	public String getEstilo() {
		return estilo;
	}



	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	
	
	
	
	
	
	
	
}
