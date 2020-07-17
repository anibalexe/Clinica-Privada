package interfaces;

import java.io.IOException;
import java.util.ArrayList;

import transacciones.Pago;

public interface ReportablePagos {
	public void generarReporte(ArrayList<Pago> pagos) throws IOException ;
}
