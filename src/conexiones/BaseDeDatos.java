package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

import stocks.Almacen;
import stocks.Espacio;
import stocks.Estante;
import stocks.Insumo;
import transacciones.Convenio;
import transacciones.Historial;
import transacciones.Pago;
import transacciones.Servicio;

public class BaseDeDatos {
	public static Connection conn;
    
    private BaseDeDatos() {

    }
    
    //
	public static Connection getConexion() throws SQLException, ClassNotFoundException {
		if(conn==null) {
			conectar();
		}
		 return conn;	
    }
	//
	public static void conectar() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicaprivada?useSSL=false", "root", "");
	}
	//
	public static void desconectar() throws SQLException {
		conn.close();
	}
	//Carga todos los datos de la base de datos al programa
	public static Almacen cargarStock() throws SQLException{
		Almacen al = new Almacen();
		return cargarInsumos(cargarEspacios(cargarEstantes(cargarAlmacen(al))));
	}
	//retorna los convenios y servicios de la clinica
	public static Historial cargarHistorial() throws SQLException {
		Historial his = new Historial();
		return cargarPagos(cargarConvenios(cargarInsumosServicios(cargarServicios(his))));
	}
    //Carga los almacenes al programa
	public static Almacen cargarAlmacen(Almacen al) throws SQLException {
		String sSQL =  "select * from almacen";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		ResultSet rs = pstm.executeQuery(sSQL);
		rs.next();
		al = new Almacen(rs.getInt(1),rs.getInt(2));
		return al;
	}
	//Agrega un estante a su respectiva sala
	public static Almacen cargarEstantes(Almacen al) throws SQLException {
		String sSQL =  "select * from estante";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		ResultSet rs = pstm.executeQuery(sSQL);
		while(rs.next()) {
			Estante es = new Estante(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			if(al.getSala()==es.getSala())
			al.agregarEstanteArray(es);
		}
		return al;
	}
	//Agrega un espacio a su respectivo estante
	public static Almacen cargarEspacios(Almacen al) throws SQLException {
		String sSQL =  "select * from espacio";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		ResultSet rs = pstm.executeQuery(sSQL);

		while(rs.next()) {
			Espacio es = new Espacio(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			for(int i=0;i<al.contarEstantes();i++) {
				if(al.mostrarEstantePosicion(i).getId()==es.getIdEstante()) {
				al.mostrarEstantePosicion(i).agregarEspacioArray(es);
				//System.out.println(al.mostrarEstantePosicion(i).getId());
				}
			}
		}
		return al;
	}
	//Agrega un insumo a su respectivo espacio
	public static Almacen cargarInsumos(Almacen al) throws SQLException {
		String sSQL =  "select * from insumo";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		ResultSet rs = pstm.executeQuery(sSQL);
		while(rs.next()) {
			Insumo in = new Insumo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getInt(5));		
			for(int i=0;i<al.contarEstantes();i++) {
				for(int j=0;j<al.mostrarEstantePosicion(i).contarEspacios();j++) {
					if(al.mostrarEstantePosicion(i).mostrarEspacioPosicion(j).getId()==in.getIdEspacio()) 
					al.mostrarEstantePosicion(i).mostrarEspacioPosicion(j).agregarInsumoArray(in);
				}
			}
		}
		return al;
	}
	//Saca los servicios de la base de datos y retorna un historial
	public static Historial cargarServicios(Historial his) throws SQLException{
		String sSQL =  "select * from servicio";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		ResultSet rs = pstm.executeQuery(sSQL);
		while(rs.next()) {
			Servicio ser = new Servicio(rs.getInt(1), rs.getString(2), rs.getInt(3));
			his.agregarServicioArray(ser);
		}
		return his;
	}
	//Saca los insumos de la base de datos y retorna un historial
	public static Historial cargarInsumosServicios(Historial his) throws SQLException {
		String sSQL =  "select * from insumosservicio";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		ResultSet rs = pstm.executeQuery(sSQL);

		for(int i=0;i<his.calcularTamañoServicios();i++) {
			while(rs.next()) {
				Insumo in = new Insumo(rs.getInt(1), rs.getString(2), rs.getInt(3));
				if(rs.getInt(4)==his.obtenerServicioPos(i).getId()) {
					his.obtenerServicioPos(i).agregarInsumo(in);
				}
			}
		}
		return his;
	}
	//Sala los convenios de la base de datos y retorna un historial
	public static Historial cargarConvenios(Historial his) throws SQLException {
		String sSQL =  "select * from cajadecompensacion inner join isapre inner join fonasa inner join seguro";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		ResultSet rs = pstm.executeQuery(sSQL);
		while(rs.next()) {
			Convenio con = new Convenio(rs.getInt(1), rs.getString(2), rs.getDouble(3));
			his.agregarConvenioArray(con);
		}
		return his;
	}
	//
	public static Historial cargarPagos(Historial his) throws SQLException{
		String sSQL =  "select * from pago";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		ResultSet rs = pstm.executeQuery(sSQL);
		while(rs.next()) {
			Pago pago = new Pago(rs.getInt(1), rs.getFloat(2), rs.getDate(3), rs.getString(4));
			his.agregarPagoArray(pago);
		}
		return his;
	}
	//metodos de insumo 
	//cambia id por newId
	public static void modificarInsumoId(int id, int newId) throws SQLException {
		String sSQL = "UPDATE insumo SET id = ?  WHERE id = ? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, newId);
		pstm.setInt(2, id);
		pstm.executeUpdate();
	}
	//cambia el nombre por newNombre
	public static void modificarInsumoNombre(int id, String newNombre) throws SQLException {
		String sSQL = "UPDATE insumo SET nombre = ?  WHERE id = ? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setString(1, newNombre);
		pstm.setInt(2, id);
		pstm.executeUpdate();
	}
	//cambia el valor por newValor
	public static void modificarInsumoValor(int id, int newValor) throws SQLException {
		String sSQL = "UPDATE insumo SET valor = ?  WHERE id = ? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, newValor);
		pstm.setInt(2, id);
		pstm.executeUpdate();
	}
	//cambia la fecha de vencimiento por newFecha
	public static void modificarInsumoFecha(int id, Date newFecha) throws SQLException {
		String sSQL = "UPDATE insumo SET fecha = ?  WHERE id = ? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setDate(1, (java.sql.Date) newFecha);
		pstm.setInt(2, id);
		pstm.executeUpdate();
	}
	//cambia el idEspacio por newIdEspacio
	public static void modificarInsumoIdEspacio(int id, int newIdEspacio) throws SQLException {
		String sSQL = "UPDATE insumo SET idEspacio = ?  WHERE id = ? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, newIdEspacio);
		pstm.setInt(2, id);
		pstm.executeUpdate();
	}
	//metodos de espacio
	//modifica el id del espacio
	public static void modificarEspacioId(int id, int newId) throws SQLException {
		String sSQL = "UPDATE espacio SET id = ?  WHERE id = ? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, newId);
		pstm.setInt(2, id);
		pstm.executeUpdate();
	}
	//modifica la capacidad del espacio
	public static void modificarEspacioCapacidad(int id, int newCapacidad) throws SQLException {
		String sSQL = "UPDATE espacio SET capacidad = ?  WHERE id = ? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, newCapacidad);
		pstm.setInt(2, id);
		pstm.executeUpdate();
	}
	//modifica el idEspacio del espacio
	public static void modificarEspacioIdEstante(int id, int newIdEstante) throws SQLException {
		String sSQL = "UPDATE espacio SET idEstante = ?  WHERE id = ? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, newIdEstante);
		pstm.setInt(2, id);
		pstm.executeUpdate();
	}
	//Elimina un insumo del espacio y la base de datos
	public static void eliminarInsumo(int id) throws SQLException {
		String sSQL = "DELETE FROM insumo WHERE id = ? LIMIT 1";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, id);
		pstm.executeUpdate();
	}
	//metodos Estante
	//Agrega un espacio al estante y a la base de datos, retorna true si se agrego y false si no 
	public static void agregarEspacio(Espacio es) throws SQLException {
		String sSQL = "INSERT INTO espacio (id, capacidad, idEstante) VALUES (?, ?, ?)";
		PreparedStatement pstm = (PreparedStatement) BaseDeDatos.conn.prepareStatement(sSQL);
		pstm.setInt(1, es.getId());
		pstm.setInt(2, es.getCapacidad());
		pstm.setInt(3, es.getIdEstante());
		pstm.executeUpdate();
	}
	//modifica el id del estante
	public static void modificarEstanteId(int id, int newId) throws SQLException {
		String sSQL = "UPDATE estante SET id = ?  WHERE id = ? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, newId);
		pstm.setInt(2, id);
		pstm.executeUpdate();
	}
	//modifica la capacidad del estante
	public static void modificarEstanteCapacidad(int id, int newCapacidad) throws SQLException {
		String sSQL = "UPDATE estante SET capacidad = ?  WHERE id = ? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, newCapacidad);
		pstm.setInt(2, id);
		pstm.executeUpdate();
	}
	//modifica la sala del estante
	public static void modificarEstanteSala(int id, int newSala) throws SQLException {
		String sSQL = "UPDATE estante SET sala = ?  WHERE id = ? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, newSala);
		pstm.setInt(2, id);
		pstm.executeUpdate();
	}
	//Busca un espacio por su id lo elimina y lo retorna, en caso de no existir retorna null
	public static void eliminarEspacio(int id) throws SQLException {
		String sSQL = "DELETE FROM espacio WHERE id = ? LIMIT 1";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, id);
		pstm.executeUpdate();
	}
	//Agrega un insumo al espacio y a la base de datos, retorna true si se agrego y false si no
	public static void agregarInsumoEspacio(Insumo in) throws SQLException {	
		String sSQL = "INSERT INTO insumo (id, valor, nombre, fecha, idEspacio) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstm = (PreparedStatement) BaseDeDatos.conn.prepareStatement(sSQL);
		pstm.setInt(1, in.getId());
		pstm.setInt(2, in.getValor());
		pstm.setString(3, in.getNombre());
		@SuppressWarnings("deprecation")
		java.sql.Date fecha1 = new java.sql.Date(in.getFecha().getYear(),  in.getFecha().getMonth(),  in.getFecha().getDate());
		pstm.setDate(4, fecha1);
		pstm.setInt(5, in.getIdEspacio());
		pstm.executeUpdate();
	}
	//metodos almacen
	//Agrega un estante al almacen y la base de datos, retorna true si se agrego y false si no 
	public static void agregarEstante(Estante es) throws SQLException {
		String sSQL = "INSERT INTO estante (id, capacidad, sala) VALUES (?, ?, ?)";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, es.getId());
		pstm.setInt(2, es.getCapacidad());
		pstm.setInt(3, es.getSala());
		pstm.executeUpdate();
	}
	//Busca un estante por su id lo elimina y lo retorna, en caso de no existir retorna null
	public static void eliminarEstante(int id) throws SQLException {
		String sSQL = "DELETE FROM estante WHERE id = ? LIMIT 1";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, id);
		pstm.executeUpdate();
	}
	//cambia el id del almacen por newSala
	public static void modificarAlmacenSala(int sala, int newSala) throws SQLException {
		String sSQL = "UPDATE almacen SET sala = ?  WHERE id = ? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, newSala);
		pstm.setInt(2, sala);
		pstm.executeUpdate();
	}
	//cambia la capacidad de almacen por newCapacidad
	public static void modificarAlmacenCapacidad(int sala, int newCapacidad) throws SQLException {
		String sSQL = "UPDATE almacen SET capacidad = ?  WHERE id = ? ";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, newCapacidad);
		pstm.setInt(2, sala);
		pstm.executeUpdate();
	}
	//metodos de historial
	//almacena el pago en la base de datos
	public static void almacenarPago(Pago pago) throws SQLException {
		String sSQL = "INSERT INTO pago (id, montoneto, fecha, idusuario) VALUES (?, ?, ?, ?)";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, pago.getId());
		pstm.setFloat(2, pago.getMontoNeto());
		pstm.setDate(3, (java.sql.Date) pago.getFecha());
		pstm.setString(4, pago.getIdUsuario());
		pstm.executeUpdate();
	}
	//almacena el servicio en la base de datos
	public static void almacenarServicio(Servicio serv) throws SQLException {
		String sSQL = "INSERT INTO servicio (id, nombre, manoDeObra, montoBruto) VALUES (?, ?, ?, ?)";
		PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sSQL);
		pstm.setInt(1, serv.getId());
		pstm.setString(2, serv.getNombre());
		pstm.setFloat(3, serv.getManoDeObra());
		pstm.setFloat(4, serv.getManoDeObra());
		pstm.executeUpdate();
	}
	
}
