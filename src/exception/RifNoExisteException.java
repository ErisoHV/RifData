package exception;

public class RifNoExisteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "El RIF proporcionado no existe";
	}

}
