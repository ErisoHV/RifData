package exception;

public class ServicioNoDisponibleException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Servicio no disponible";
	}

	

}
