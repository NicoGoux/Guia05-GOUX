package Guia05;

import java.time.LocalDate;
import java.time.LocalTime;

public class ServicioEstandar extends Servicio{
	private double costoFijo;
	
	public ServicioEstandar(Oficio oficio, String tipoServicio, LocalDate fechaInicio,LocalTime horaInicio, double costoFijo) {
		this.oficio = oficio;
		this.tipoServicio = tipoServicio;
		this.costoServicio = 0;
		this.prioridad = false;
		this.fechaInicio = fechaInicio;
		this.horaInicio = horaInicio;
		this.costoFijo = costoFijo;
	}

	public void costo(double costoTrabajador) {
		double costoFinal=this.costoFijo+costoTrabajador;
		if (this.prioridad==true) {
			costoFinal+=costoFinal*0.5;
		}
		this.costoServicio=costoFinal;
	}	
}
