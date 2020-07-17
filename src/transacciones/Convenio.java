package transacciones;

public class Convenio {
	private int id;
	private String nombre;
	private double porcentajeDescuento;
	
	public Convenio(int id, String nombre, double porcentajeDescuento) {
		this.id = id;
		this.nombre = nombre;
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}
	public void setPorcentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	public double aplicarDescuento(double brutoTotal) {
		double montoNeto = 0;
		double descuento = 0;
		descuento = brutoTotal*getPorcentajeDescuento();
		montoNeto = brutoTotal-descuento;
		return montoNeto;
	}
}
