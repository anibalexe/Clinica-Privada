package stocks;

import java.sql.SQLException;
import java.util.Date;

import conexiones.BaseDeDatos;

public class Insumo {
	private int id;
	private int valor;
	private int idEspacio;
	private String nombre;
	private Date fecha;
	private int diasParaCaducar;
	private Date fechaEliminado;

	@SuppressWarnings("deprecation")
	public Insumo(int id, int valor, String nombre, int año, int mes, int dia, int idEspacio) {
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		fecha = new Date(año-1900,mes-1,dia);
		this.idEspacio = idEspacio;
		diasParaCaducar = 0;
		fechaEliminado = null;
	}
	public Insumo(int id, int valor, String nombre, Date fecha, int idEspacio) {
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.fecha = fecha;
		this.idEspacio = idEspacio;
		diasParaCaducar = 0;
		fechaEliminado = null;
	}
	//para poder cargar los datos necesarios para un insumo perteneciente a un servicio
	public Insumo(int id, String nombre, int valor) {
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.fecha = null;
		this.idEspacio = 0;
		diasParaCaducar = 0;
		fechaEliminado = null;
	}

	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor=valor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getDiasParaCaducar() {
		return diasParaCaducar;
	}
	public void setDiasParaCaducar(int diasParaCaducar) {
		this.diasParaCaducar = diasParaCaducar;
	}
	public int getIdEspacio() {
		return idEspacio;
	}
	public void setIdEspacio(int idEspacio) {
		this.idEspacio = idEspacio;
	}
	public Date getFechaEliminado() {
		return fechaEliminado;
	}
	public void setFechaEliminado(Date fechaIngreso) {
		this.fechaEliminado = fechaIngreso;
	}
	
	//cambia id por newId
	public void modificarId(int newId) throws SQLException {
			BaseDeDatos.modificarInsumoId(getId(), newId);
			setId(newId);
	}
	//cambia el nombre por newNombre
	public void modificarNombre(String newNombre) throws SQLException {
			BaseDeDatos.modificarInsumoNombre(getId(), newNombre);
			setNombre(newNombre);
	}
	//cambia el valor por newValor
	public void modificarValor(int newValor) throws SQLException {
			BaseDeDatos.modificarInsumoValor(getId(), newValor);
			setValor(newValor);
	}
	//cambia la fecha de vencimiento por newFecha
	public void modificarFecha(Date newFecha) throws SQLException {
			BaseDeDatos.modificarInsumoFecha(getId(), newFecha);
			setFecha(newFecha);
	}
	//cambia el idEspacio por newIdEspacio
	public void modificarIdEspacio(int newIdEspacio) throws SQLException {
			BaseDeDatos.modificarInsumoIdEspacio(getId(), newIdEspacio);
			setIdEspacio(newIdEspacio);
	}
}

