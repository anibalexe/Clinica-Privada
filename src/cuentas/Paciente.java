package cuentas;

public class Paciente extends Usuario{
	public Paciente(String nombreCuenta, String clave, String nombre, int rut) {
		super(nombreCuenta, clave, nombre);
	}
	
	public String validarCuenta() {
		return "Paciente";
	}
}
