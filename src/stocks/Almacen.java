package stocks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import conexiones.BaseDeDatos;
import excepciones.ImposibleAgregarInsumosException;
import excepciones.ImposibleEliminarInsumosException;
import interfaces.Reportable;

public class Almacen implements Reportable{
	private ArrayList<Estante> estantes;
	private int sala, capacidad;
	
	public Almacen(){
		estantes = new ArrayList<Estante>();
		this.sala = 0;
		this.capacidad = 0;
	}
	
	public Almacen(int sala,int capacidad){
		estantes = new ArrayList<Estante>();
		this.sala = sala;
		this.capacidad = capacidad;
	}
	
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	//Agrega un estante al almacen, retorna true si se agrego y false si no 
	public boolean agregarEstanteArray(Estante es) throws SQLException {
		if(estantes.size()<capacidad) {
			estantes.add(es);
			return true;
		}
		return false;
	}
	//Agrega un estante al almacen, retorna true si se agrego y false si no 
	public boolean agregarEstante(Estante es) throws SQLException {
		if(estantes.size()<capacidad) {
			BaseDeDatos.agregarEstante(es);
			estantes.add(es);
			return true;
		}
		return false;
	}
	//retorna el estante que esta en pa posicion "espacio"
	public Estante mostrarEstantePosicion(int posicion) {
		return estantes.get(posicion);
	}
	//Busca un estante por su id y lo retorna
	public Estante mostrarEstante(int id) {
		for(int i=0;i<estantes.size();i++) {
			if(estantes.get(i).getId()==id)
				return estantes.get(i);
		}
		return null;
	}
	//cambia el id del almacen por newSala
	public void modificarSala(int sala, int newSala) throws SQLException {
		BaseDeDatos.modificarAlmacenSala(getSala(), newSala);
		setSala(newSala);
	}
	//cambia la capacidad de almacen por newCapacidad
	public void modificarCapacidad(int id, int newCapacidad) throws SQLException {
		BaseDeDatos.modificarAlmacenCapacidad(getSala(), newCapacidad);
		setCapacidad(newCapacidad);
	}
	//Busca un estante por su id lo elimina y lo retorna, en caso de no existir retorna null
	public Estante eliminarEstante(int id) throws SQLException {
		for(int i=0;i<estantes.size();i++) {
			Estante es = estantes.get(i);
			if(es.getId()==id) {
				BaseDeDatos.eliminarEstante(id);
				estantes.remove(i);
				return es;
			}
		}
		return mostrarEstante(id);
	}
	//Agrega una cantidad de insumos al almacen
	public boolean agregarInsumosAlmacen(Insumo in, int cantidad) throws SQLException, ImposibleAgregarInsumosException {
		int cantidadnueva;
		for(int i=0;i<estantes.size();i++) {
			Estante est=estantes.get(i);
			cantidadnueva = est.agregarInsumosEstante(in, cantidad);
			cantidad = cantidadnueva;
			if(cantidadnueva==0)
				return true;
		}
		throw new ImposibleAgregarInsumosException(Integer.toString(cantidad));
	}
	//Elimina insumos del almacen ,si ya no queda mas que eliminar retorna que ya no quedan ?
	public boolean eliminarInsumosAlmacen(int id, int cantidad) throws SQLException, ImposibleEliminarInsumosException {
		verificarCantidadInsumoAcabando(id,cantidad);
		int cantidadFaltante = 0;
		for(int i=0;i<estantes.size();i++) {
			Estante es = estantes.get(i);
			cantidadFaltante = cantidad-es.contarInsumosEstante(id);
			//si es negativo significa que se pudieron eliminar los insumos correctamente
			if(es.eliminarInsumosEstante(id, cantidad))
				return true;
			else
				cantidad = cantidadFaltante;
		}
		throw new ImposibleEliminarInsumosException(Integer.toString(cantidad));
	}
	//Verifica si la cantidad de ese insumo se esta acabando
	public void verificarCantidadInsumoAcabando(int id, int cant) {
		int numero = contarInsumosAlmacen(id)-cant;
		if(numero>0 && numero<20){
			System.out.println("Alerta, quedan "+numero+" unidades del insumo");
		}
	}
	//Cuenta el numero de insumos de un mismo tipo en el almacen
	public int contarInsumosAlmacen(int id) {
		int cantidad=0;
		for(int i=0;i<estantes.size();i++) {
			Estante est = estantes.get(i);
			cantidad = cantidad + est.contarInsumosEstante(id);
		}
		return cantidad;
	}
	//Cuenta el numero de estantes en el almacen
	public int contarEstantes() {
		return estantes.size();
	}
	// Se pasa la lista de todos los estantes con insumos que caducaron y los agrega a la listaque se retorna
	public ArrayList<Insumo> verificarFechasInsumosAlmacen() {
		ArrayList<Insumo> insumoFechasEstantes= new ArrayList<Insumo>();
		ArrayList<Insumo> insumoFechasEstante = new ArrayList<Insumo>();
		for(int i=0;i<estantes.size();i++) { 
			Estante est=estantes.get(i);
		     insumoFechasEstante = est.verificarFechasInsumosEstante();
		     for(int j=0;j<insumoFechasEstante.size();j++) {
		    	 Insumo insumo=insumoFechasEstante.get(j);
		    	 insumoFechasEstantes.add(insumo);
		     }
		   insumoFechasEstante.clear();
		  }
		return insumoFechasEstantes;
	}
	//Busca todos los insumos en los estantes y retorna un arraylist con ellos
	public ArrayList<Insumo> agruparInsumosAlmacen() {
		ArrayList<Insumo> lista = new ArrayList<Insumo>();
		ArrayList<Insumo> listaAux = new ArrayList<Insumo>();
		for(int i=0;i<estantes.size();i++) {
			listaAux = estantes.get(i).agruparInsumosEstante();
			for(int j=0;j<listaAux.size();j++) {
				lista.add(listaAux.get(j));
			}
		}
		return lista;
	}
	//resive un arraylist de insumos para descontar del almacen, retorna true si se logro
	public void descontarInsumos(ArrayList<Insumo> insumosOcupados) throws SQLException, ImposibleEliminarInsumosException {
		for(int i=0;i<insumosOcupados.size();i++) {
			eliminarInsumosAlmacen(insumosOcupados.get(i).getId(), 1);
		}
	}
	public void generarReporte() throws IOException {
		
		String tituloDocumento = "Reporte Estantes en Almacen";
		String contenidoParrafo = "ID | Capacidad | IdSala ";
		
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
		while(i < estantes.size()){
			contenidoParrafo = Integer.toString(estantes.get(i).getId()) + " | " + 
					Integer.toString(estantes.get(i).getCapacidad()) + " | " +
					Integer.toString(estantes.get(i).getSala());
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
	//Genera un reporte de los insumos en el almacen
	public void generarReporteInsumos() throws IOException {
		
		String tituloDocumento = "Reporte Insumos en Almacen";
		String contenidoParrafo = "Id | Precio | Nombre | FechaVencimiento | IdEspacio";
		ArrayList<Insumo> listado = agruparInsumosAlmacen();
		
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
		while(i < listado.size()){
			String fecha1 = dateformat.format(listado.get(i).getFecha()); 
			contenidoParrafo = Integer.toString(listado.get(i).getId()) + " | " + 
					Integer.toString(listado.get(i).getValor()) + " | " +
					listado.get(i).getNombre() + " | " + fecha1 +" | "+
					Integer.toString(listado.get(i).getIdEspacio());
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

