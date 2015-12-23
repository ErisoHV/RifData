package exception;

public class URLIncorrectaException extends Exception{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "La URL del Seniat esta icorrecta";
	}

}
