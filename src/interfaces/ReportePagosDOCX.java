package interfaces;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import transacciones.Pago;

public class ReportePagosDOCX implements ReportablePagos{

	//genera una reporte de todos los pagos con el ingreso total
	public void generarReporte(ArrayList<Pago> pagos) throws IOException {
		String tituloDocumento = "Reporte de Ingresos";
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
		        
		int i = 0;
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		
		while(i < pagos.size()){
			String fecha1 = dateformat.format(pagos.get(i).getFecha());  
			contenidoParrafo = Integer.toString(pagos.get(i).getId()) + " | " + Float.toString(pagos.get(i).getMontoNeto()) + " | " + fecha1 + " | " + pagos.get(i).getIdUsuario();
			r2 = parrafo.createRun();
			r2.setText(contenidoParrafo);
			r2.setFontSize(12);
			r2.addCarriageReturn();
			i++;
		}
		contenidoParrafo = "Monto Total : " + calcularTotal(pagos);
		r2 = parrafo.createRun();
		r2.setText(contenidoParrafo);
		r2.setFontSize(12);
		r2.addCarriageReturn();
		
		FileOutputStream word = new FileOutputStream(tituloDocumento+".docx");
		documento.write(word);
		word.close();
		documento.close();	
	}
	
	public float calcularTotal(ArrayList<Pago> pagos) {
		float total = 0;
		for(int i=0; i<pagos.size(); i++) {
			total += pagos.get(i).getMontoNeto();
		}
		return total;
	}
}
