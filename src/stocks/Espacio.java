package stocks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import conexiones.BaseDeDatos;
import interfaces.Reportable;

public class Espacio implements Reportable{
	private ArrayList<Insumo> insumos;
	private int id;
	private int capacidad;
	private int idEstante;
	
	public Espacio(int id, int capacidad, int idEstante) {
		insumos = new ArrayList<Insumo>();
		this.capacidad = capacidad;
		this.id = id;
		this.idEstante = idEstante;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getIdEstante() {
		return idEstante;
	}
	public void setIdEstante(int idEstante) {
		this.idEstante = idEstante;
	}
	
	//agrega un insumo al espacio
	public boolean agregarInsumoArray(Insumo in) throws SQLException {
		if(insumos.size()<capacidad) {
			BaseDeDatos.agregarInsumoEspacio(in);
			insumos.add(in);
			return true;
		}
		return false;
	}
	//agrega un insumo al espacio
	public boolean agregarInsumo(Insumo in) throws SQLException {
		if(insumos.size()<capacidad) {
			BaseDeDatos.agregarInsumoEspacio(in);
			insumos.add(in);
			return true;
		}
		return false;
	}
	//Agrega una cierta cantidad de insumos al espacio y retorna la cantidad de insumos que no se pudieron agregar
	public int agregarInsumosEspacio(Insumo in,int cantidad,int esp) throws SQLException {
		if(insumos.size() == capacidad)
			return cantidad;
		for(int i=0;i<capacidad;i++) {
			in.setIdEspacio(esp);
			agregarInsumo(in);
			insumos.add(in);
			cantidad--;
			if(insumos.size() == capacidad) {
				return cantidad;
			}
			if(cantidad == 0)
				return 0;
		} 
		return cantidad;
	}
	//retorna el insumo en la posicion
	public Insumo mostrarInsumoPosicion(int posicion) {
		return insumos.get(posicion);
	}
	//Busca un insumo por su id y lo retorna
	public Insumo mostrarInsumo(int id) {
		for(int i=0;i<insumos.size();i++) {
			if(insumos.get(i).getId()==id)return insumos.get(i);
		}
		return null;
	}
	//modifica el id del espacio
	public void modificarId(int newId) throws SQLException {
			BaseDeDatos.modificarEspacioId(getId(), newId);
			setId(newId);
	}
	//modifica la capacidad del espacio
	public void modificarCapacidad(int newCapacidad) throws SQLException {
			BaseDeDatos.modificarEspacioCapacidad(getId(), newCapacidad);
			setCapacidad(newCapacidad);
	}
	//modifica el idEspacio del espacio
	public void modificarIdEstante(int newIdEstante) throws SQLException {
			BaseDeDatos.modificarEspacioIdEstante(getId(), newIdEstante);
			setIdEstante(newIdEstante);
	}
	//Busca un insumo, lo elimina de la lista y retorna
	public boolean eliminarInsumo(int id) throws SQLException {
		for(int i=0;i<insumos.size();i++) {
			if(insumos.get(i).getId()==id) {
				BaseDeDatos.eliminarInsumo(id);
				insumos.remove(i);
				return true;
			}
		}
		return false;
	}
	//Cuenta la cantidad de veces que se repite un insumo en el espacio y la retorna
	public int contarInsumos(int id) {
		int contador=0;
		for(int i=0;i<insumos.size();i++) {
			if(insumos.get(i).getId()==id) {
				contador++;
			}
		}
		return contador;
	}
	// Verifica que el insumo este por caducar
	@SuppressWarnings("deprecation")
	public int verificarFechaInsumo(Insumo in) {
			int diferenciaAños,diferenciaMeses,diferenciaDias;
			Date fecha = in.getFecha();
			Date fecha2 = new Date();
			diferenciaAños= (fecha.getYear()+1900)-(fecha2.getYear()+1900);
			diferenciaMeses= fecha.getMonth() - fecha2.getMonth();
			diferenciaDias= fecha.getDate()-fecha2.getDate();
			if( diferenciaAños==0 && diferenciaMeses==0 &&  diferenciaDias>0) {
				return  diferenciaDias;	
			 }
		return -1;
	}
	//Se guardan todos los insumos del espacio que esten por caducar y retorna una lista de estos
	public ArrayList<Insumo> verificarFechasInsumosEspacio() {
		ArrayList<Insumo> InsumosFecha= new ArrayList<Insumo>();
		for(int i=0;i<insumos.size();i++) {
			int  cantidadDiasCaducar;
			Insumo in=insumos.get(i);
		    cantidadDiasCaducar=verificarFechaInsumo(in);
		    if(cantidadDiasCaducar>=0) {
		    in.setDiasParaCaducar(cantidadDiasCaducar);
		    InsumosFecha.add(in);
		    	}  
		}
		return InsumosFecha;
	}
	//Cuenta todos los insumos en el espacio
	public int contarInsumos() {
		return insumos.size();
	}
	//Busca todos los insumos en los espacios y retorna un arraylist con ellos
	public ArrayList<Insumo> agruparInsumos() {
		ArrayList<Insumo> lista = new ArrayList<Insumo>();
		for(int i=0;i<insumos.size();i++) {
			lista.add(insumos.get(i));
		}
		return lista;
	}
	public void generarReporte() throws IOException {
		
		String tituloDocumento = "Reporte Insumos en Espacio";
		String contenidoParrafo = "Id | Valor | Nombre | FechaVencimiento | IdEspacio ";
		
		XWPFDocument documento = new XWPFDocument();
        
		//Declaramos el titulo y le asignamos algunas propiedades
		XWPFParagraph titulo_doc = documento.createParagraph();
		titulo_doc.setAlignment(ParagraphAlignment.CENTER);
		//titulo_doc.setVerticalAlignment(TextAlignment.TOP);
		        
		//Declaramos el parrafo y le asignamos algunas propiedades
		XWPFParagraph parrafo = documento.createParagraph();
		parrafo.setAlignment(ParagraphAlignment.BOTH);

		//Para el titulo
		XWPFRun r1 = titulo_doc.createRun();
		r1.setBold(true);
		r1.setText(tituloDocumento);
		r1.setFontFamily("Arial");
		r1.setFontSize(14);
		r1.setTextPosition(10);
		r1.setUnderline(UnderlinePatterns.SINGLE);
		
		XWPFRun r2 = parrafo.createRun();
		r2.setText(contenidoParrafo);
		r2.setFontSize(12);
		r2.addCarriageReturn();
		        
		int i = 0;
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		
		while(i < insumos.size()){
			String fecha1 = dateformat.format(insumos.get(i).getFecha());  
			contenidoParrafo = Integer.toString(insumos.get(i).getId()) + " | " + 
					Integer.toString(insumos.get(i).getValor()) + " | " +
					insumos.get(i).getNombre() + " | " + fecha1 + " | " +
							Integer.toString(insumos.get(i).getIdEspacio());
			r2 = parrafo.createRun();
			r2.setText(contenidoParrafo);
			r2.setFontSize(12);
			r2.addCarriageReturn();
			i++;
		}
		
		FileOutputStream word = new FileOutputStream(tituloDocumento+".docx");
		documento.write(word);
		word.close();
		documento.close();
	}
}
