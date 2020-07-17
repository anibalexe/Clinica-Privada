package cuentas;

public class Administrador extends Usuario {
	
	public Administrador(String nombreCuenta, String clave, String nombre, int rut) {
		super(nombreCuenta, clave, nombre);
	}

	public String validarCuenta() {
		return "Administrador";
	}
}
