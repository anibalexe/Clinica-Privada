package excepciones;

public class ImposibleEliminarInsumosException extends Exception{

	private static final long serialVersionUID = 3L;
	
	public ImposibleEliminarInsumosException(String cantidad){
		super("Cantidad de insumos en almacen insuficiente, no se pudieron eliminar "+cantidad+" insumos");
	}
}
