package transacciones;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import conexiones.BaseDeDatos;
import cuentas.Usuario;
import excepciones.UsuarioOClaveInvalidaException;
import interfaces.ReportablePagos;
import stocks.Insumo;

public class Historial {
	private ArrayList<Servicio> servicios;
	private ArrayList<Convenio> convenios;
	private ArrayList<Pago> pagos;
	private HashMap<String,Usuario> cuentas;
	private ReportablePagos formato;
	
	public Historial() {
		servicios = new ArrayList<Servicio>();
	 	convenios = new ArrayList<Convenio>();
	 	pagos = new ArrayList<Pago>();
	 	cuentas = new HashMap<String,Usuario>();
	}
	//Agrega un servicio al historial
	public void agregarServicioArray(Servicio ser) {
		servicios.add(ser);
	}
	//Agrega un covenio al historial
	public void agregarConvenioArray(Convenio con) {
		convenios.add(con);
	}
	//Agrega un pago al historial
	public void agregarPagoArray(Pago pago) throws SQLException {
		pagos.add(pago);
	}
	//Agrega un servicio al historial
	public void agregarServicio(Servicio ser) throws SQLException {
		BaseDeDatos.almacenarServicio(ser);
		servicios.add(ser);
	}
	/*//Agrega un covenio al historial
	public void agregarConvenio(Convenio con) {
		BaseDeDatos.almacenarConvenio(pago);
		convenios.add(con);
	}*/
	//Agrega un pago al historial
	public void agregarPago(Pago pago) throws SQLException {
		BaseDeDatos.almacenarPago(pago);
		pagos.add(pago);
	}
	//*Verifica si el usuario es correcto
	public boolean verificarCuenta(String clave) throws UsuarioOClaveInvalidaException {
		if(!cuentas.containsKey(clave)) {
			throw new UsuarioOClaveInvalidaException();
		}
		return cuentas.containsKey(clave);
	}
	//Obtiene un arraylist con todos los pagos realizados entre dos fechas
	public ArrayList<Pago> obtenerPagosEntreFechas(Date fechaMenor,Date fechaMayor){		
		ArrayList<Pago> listaDePagos= new ArrayList<Pago>();
		for (int i=0;i<pagos.size();i++) {
			Pago pago=pagos.get(i);
			if(pago.getFecha().after(fechaMenor) && pago.getFecha().before(fechaMayor)) {
				listaDePagos.add(pago);
			}
				pago=null;
			}
		return listaDePagos;
	}
	//calcula el monto total 
	public float calcularTotal() {
		float total = 0;
		for(int i=0; i<pagos.size(); i++) {
			total += pagos.get(i).getMontoNeto();
		}
		return total;
	}
	//retorna el servicio en la posicion
	public Servicio obtenerServicioPos(int pos) {
		return servicios.get(pos);
	}
	//duelve el tamaño del arrayList de servicios
	public int calcularTamañoServicios() {
		return servicios.size();
	}
	public void setFormatoReporte(ReportablePagos formato) {
		this.formato = formato;
	}
	public void generarReportePagos() throws IOException {
		formato.generarReporte(pagos);
	}

}
