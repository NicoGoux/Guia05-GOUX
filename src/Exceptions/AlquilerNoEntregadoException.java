package Exceptions;

public class AlquilerNoEntregadoException extends Exception {
	public AlquilerNoEntregadoException() {
		super("La herramienta no ha sido devuelta");
	}
}
