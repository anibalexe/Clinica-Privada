package excepciones;

public class ImposibleAgregarInsumosException extends Exception{

	private static final long serialVersionUID = 2L;
	
	public ImposibleAgregarInsumosException(String cantidad) {
		super("No se pudieron agregar "+cantidad+" insumos");
	}

}
