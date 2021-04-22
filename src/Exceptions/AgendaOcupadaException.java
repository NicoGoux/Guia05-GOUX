package Exceptions;

public class AgendaOcupadaException extends Exception {
	public AgendaOcupadaException() {
		super("El trabajador tiene un trabajo agendado el dia del servicio");
	}
}
