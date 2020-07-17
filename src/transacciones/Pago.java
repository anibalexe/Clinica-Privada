package transacciones;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import interfaces.Reportable;

public class Pago extends Cotizacion implements Reportable{
	private int id;
	private Date fecha;
	private String idUsuario;
	
	public Pago(int id, float montoNeto, String idUsuario) {
		super(montoNeto);
		this.id = id;
		this.idUsuario = idUsuario;
		fecha = new Date();
		
	}
	public Pago(int id, float montoNeto, Date fecha, String idUsuario) {
		super(montoNeto);
		this.id = id;
		this.idUsuario = idUsuario;
		this.fecha = fecha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public void generarReporte() throws IOException {
		String tituloDocumento = "Boleta";
		String contenidoParrafo = "Id | montoNeto | Fecha | idUsuario ";
		
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
		   
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		
			String fecha1 = dateformat.format(fecha);  
			contenidoParrafo = Integer.toString(id) + " | " + Float.toString(getMontoNeto()) + " | " + fecha1 + " | " + idUsuario;
			r2 = parrafo.createRun();
			r2.setText(contenidoParrafo);
			r2.setFontSize(12);
			r2.addCarriageReturn();
		
		FileOutputStream word = new FileOutputStream(tituloDocumento+".docx");
		documento.write(word);
		word.close();
		documento.close();	
	}
}
