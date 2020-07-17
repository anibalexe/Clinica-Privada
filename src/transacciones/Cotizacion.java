package transacciones;

import java.util.ArrayList;

public class Cotizacion {
	private ArrayList<Servicio> servicios;
	private float montoNeto;
	
	public Cotizacion(float montoNeto) {
		this.montoNeto = montoNeto;
	}
	
	public float getMontoNeto() {
		return montoNeto;
	}
	public void setMontoNeto(float montoNeto) {
		this.montoNeto = montoNeto;
	}
	//agrega un servicio a la cotizacion
	public void agregarServicio(Servicio ser) {
		servicios.add(ser);
	}
	//agrega un arraylist de servicios a la cotizacion
	public void agregarServicio(ArrayList<Servicio> newServicios) {
		for(int i=0; i<newServicios.size();i++) {
			servicios.add(newServicios.get(i));
		}
	}
	//recorre todos los servicios de la cotizacion y retorna el monto bruto total
	public double calcularMontoNeto() {
		double brutoTotal = 0;
		for(int i=0; i<servicios.size();i++) {
			brutoTotal = brutoTotal+servicios.get(i).getMontoBruto();
		}
		return brutoTotal;
	}
}
