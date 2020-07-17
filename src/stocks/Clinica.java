package stocks;

import java.io.IOException;
import java.sql.SQLException;

import conexiones.BaseDeDatos;
import interfaces.ReportePagosDOCX;
import transacciones.Historial;
import transacciones.Pago;


public class Clinica {

	public static void main(String[] args){
		try {
			BaseDeDatos.getConexion();
			Almacen al = BaseDeDatos.cargarStock();
			Historial his = BaseDeDatos.cargarHistorial();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			BaseDeDatos.desconectar();
	}
}