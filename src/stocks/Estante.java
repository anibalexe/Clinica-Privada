package stocks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import conexiones.BaseDeDatos;
import interfaces.Reportable;

public class Estante implements Reportable{
	private ArrayList<Espacio> espacios;
	private int id;
	private int capacidad;
	private int sala;
	
	public Estante(int id, int capacidad, int sala) {
		espacios = new ArrayList<Espacio>();
		this.capacidad = capacidad;
		this.id = id;
		this.sala = sala;
	}
	//Setters y Getters	
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
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}
	//Agrega un espacio nuevo. Retorna true si agrego correctamente, y false si no.
	public boolean agregarEspacioArray(Espacio es) throws SQLException {
		if(espacios.size()<capacidad) {
			espacios.add(es);
			return true;
		}
		return false;
	}
	//Agrega un espacio nuevo. Retorna true si agrego correctamente, y false si no.
	public boolean agregarEspacio(Espacio es) throws SQLException {
		if(espacios.size()<capacidad) {
			BaseDeDatos.agregarEspacio(es);
			espacios.add(es);
			return true;
		}
		return false;
	}
	//retorna el espacio en la posicion
	public Espacio mostrarEspacioPosicion(int posicion) {
		return espacios.get(posicion);
	}
	//Busca un espacio por su id y lo retorna 
	public Espacio mostrarEspacio(int id) {
		for(int i=0;i<espacios.size();i++) {
			if(espacios.get(i).getId()==id)
				return espacios.get(i);
		}
		return null;
	}
	//modifica el id del estante
	public void modificarId(int newId) throws SQLException {
			BaseDeDatos.modificarEstanteId(getId(), newId);
			setId(newId);
	}
	//modifica la capacidad del estante
	public void modificarCapacidad(int newCapacidad) throws SQLException {
			BaseDeDatos.modificarEstanteCapacidad(getId(), newCapacidad);
			setCapacidad(newCapacidad);
	}
	//modifica la sala del estante
	public void modificarSala(int newSala) throws SQLException {
		    BaseDeDatos.modificarEstanteSala(getId(), newSala);
			setSala(newSala);
	}
	//Busca un espacio por su id lo elimina y lo retorna, en caso de no existir retorna null
	public boolean eliminarEspacio(int id) throws SQLException {
		for(int i=0;i<espacios.size();i++) {
			if(espacios.get(i).getId()==id) {
				BaseDeDatos.eliminarEspacio(id);
				espacios.remove(i);
				return true;
			}
		}
		return false;
	}
	//Agrega una cantidad de insumos a los estantes
	public int agregarInsumosEstante(Insumo in, int cantidad) throws SQLException {
		int cantidadnueva;
		for(int i=0;i<espacios.size();i++) {
			Espacio es = espacios.get(i);
			cantidadnueva = es.agregarInsumosEspacio(in, cantidad, espacios.get(i).getId());
			cantidad = cantidadnueva;
			if(cantidadnueva==0)
				return 0;
		}
		return cantidad;	
	}
	//Busca un insumo en el estante y elimina 
	public boolean eliminarInsumosEstante(int id, int cantidad) throws SQLException {		
		for(int i=0;i<espacios.size();i++) {
			while(cantidad>0) {
				Espacio es = espacios.get(i);
				if(!es.eliminarInsumo(id))break;
				if(cantidad==1)return true;
				cantidad--;	
			}
		}
		return false;	
	}
	//Cuenta la cantidad de un insumo que se encuentra en el estante
	public int contarInsumosEstante(int id) {
		int cantidad=0;
		for(int i=0;i<espacios.size();i++) {
			Espacio es = espacios.get(i);
			cantidad = cantidad + es.contarInsumos(id);
		}
		return cantidad;
	}
	//cuenta los espacios que hay en el estante
	public int contarEspacios() {
		return espacios.size();
	}
	//Se pasa la lista de todos los espacios con insumos que caducaron y los agrega a la lista que se retorna
	public ArrayList<Insumo> verificarFechasInsumosEstante() {
		ArrayList<Insumo> insumoFechasEspacios = new ArrayList<Insumo>();
		ArrayList<Insumo> insumoFechasEspacio = new ArrayList<Insumo>();
		for(int i=0;i<espacios.size();i++) {
			Espacio es=espacios.get(i);
	        insumoFechasEspacio = es.verificarFechasInsumosEspacio();	     
			for(int j=0;j<insumoFechasEspacio.size();j++) {
	    	     Insumo insumo=insumoFechasEspacio.get(j);
	    	     insumoFechasEspacios.add(insumo);
			}
		    insumoFechasEspacio.clear();	   
		}	
		return insumoFechasEspacios;
	}
	//Busca todos los insumos en los estantes y retorna un arraylist con ellos
	public ArrayList<Insumo> agruparInsumosEstante() {
		ArrayList<Insumo> lista = new ArrayList<Insumo>();
		ArrayList<Insumo> listaAux = new ArrayList<Insumo>();
		for(int i=0;i<espacios.size();i++) {
			listaAux = espacios.get(i).agruparInsumos();
			for(int j=0;j<listaAux.size();j++) {
				lista.add(listaAux.get(j));
			}
		}
		return lista;
	}
	//
	public void generarReporte() throws IOException {
		
		String tituloDocumento = "Reporte Espacios en Estante";
		String contenidoParrafo = "Id | Capacidad | IdEstante ";
		
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
		while(i < espacios.size()){
			contenidoParrafo = Integer.toString(espacios.get(i).getId()) + " | " + 
					Integer.toString(espacios.get(i).getCapacidad()) + " | " +
					Integer.toString(espacios.get(i).getIdEstante());
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
	
	

