
public class Cliente {

	
	private String nombreusuario;
	private String nombreapellido;
	private String ciudad;
	private String email;
	private String contrase�a;
	
	
	
	public Cliente(String nombreusuario, String nombreapellido, String ciudad,
			String email, String contrase�a) {
		super();
		this.nombreusuario = nombreusuario;
		this.nombreapellido = nombreapellido;
		this.ciudad = ciudad;
		this.email = email;
		this.contrase�a = contrase�a;
	}



	public String getNombreusuario() {
		return nombreusuario;
	}



	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}



	public String getNombreapellido() {
		return nombreapellido;
	}



	public void setNombreapellido(String nombreapellido) {
		this.nombreapellido = nombreapellido;
	}



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getContrase�a() {
		return contrase�a;
	}



	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	
	
	
	
	
}
