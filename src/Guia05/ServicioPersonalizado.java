package Guia05;

import java.time.LocalDate;
import java.time.LocalTime;

public class ServicioPersonalizado extends Servicio{
	private double costoPresupuestado;
	private double costoMateriales;
	private double costoTransporte;
	private boolean presupuestado;
	
	public ServicioPersonalizado(Oficio oficio, String tipoServicio, LocalDate fechaInicio,LocalTime horaInicio) {
		this.oficio = oficio;
		this.tipoServicio = tipoServicio;
		this.prioridad = false;
		this.costoServicio=0;
		this.fechaInicio = fechaInicio;
		this.horaInicio = horaInicio;
		this.presupuestado=false;
	}

	public void costo(double costoTrabajador) {
		
		double costoServicio=this.costoMateriales+this.costoPresupuestado+this.costoTransporte;
		if (this.prioridad==true) {
			costoServicio+=costoServicio*0.5;
		}
		
		this.costoServicio=costoServicio;
		
	}
	
	public boolean getPresupuestado() {
		return this.presupuestado;
	}
	
	public void marcarPresupuestado(double costoPresupuestado, double costoMateriales, double costoTransporte) {
		this.presupuestado=true;
		this.costoPresupuestado=costoPresupuestado;
		this.costoMateriales=costoMateriales;
		this.costoTransporte=costoTransporte;
	}
}
