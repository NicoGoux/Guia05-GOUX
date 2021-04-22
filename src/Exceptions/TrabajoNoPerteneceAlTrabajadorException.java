package Exceptions;

public class TrabajoNoPerteneceAlTrabajadorException extends Exception {
	public TrabajoNoPerteneceAlTrabajadorException() {
		super("El trabajo indicado no pertenece al trabajador");
	}
}
