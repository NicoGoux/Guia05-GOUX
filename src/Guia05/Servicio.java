package Guia05;
import java.time.*;

public abstract class Servicio implements Contratable{
	protected Oficio oficio;
	protected String tipoServicio;
	protected double costoServicio;
	protected boolean prioridad;
	protected LocalDate fechaInicio;
	protected LocalTime horaInicio;
	
	

	public Oficio getOficio() {
		return this.oficio;
	}
	
	public LocalDate getFecha() {
		return this.fechaInicio;
	}
	
	public LocalTime getHoraInicio() {
		return this.horaInicio;
	}
	
	public abstract void costo(double costoTrabajador);
	
	public double getCosto() {
		return this.costoServicio;
	}
}
