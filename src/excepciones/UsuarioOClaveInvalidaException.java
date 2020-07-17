package excepciones;

public class UsuarioOClaveInvalidaException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UsuarioOClaveInvalidaException() {
		super("Error usuario y/o clave invalida");
	}

}
