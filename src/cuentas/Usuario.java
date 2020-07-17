package cuentas;

public abstract class Usuario {
	private String nombreCuenta;
	private String clave;
	private String nombre;
	
	public Usuario(String nombreCuenta, String clave, String nombre) {
		this.nombreCuenta = nombreCuenta;
		this.clave = clave;
		this.nombre = nombre;
	}
	
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public abstract String validarCuenta();
}
