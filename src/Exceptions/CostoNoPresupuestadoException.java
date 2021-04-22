package Exceptions;

public class CostoNoPresupuestadoException extends Exception {
	
	public CostoNoPresupuestadoException() {
		super("El servicio no ha sido presupuestado");
	}

}
