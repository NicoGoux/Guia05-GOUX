package Exceptions;

public class OficioNoCoincideException extends Exception {

	public OficioNoCoincideException() {
		super("El trabajador no realiza el oficio indicado");
	}
}
