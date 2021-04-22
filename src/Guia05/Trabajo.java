package Guia05;

import java.time.*;
import Exceptions.*;

public class Trabajo {
	private Servicio servicio;
	private LocalDate fechaTrabajo;
	private LocalDate fechaFinalizacion;
	private LocalTime horaFinalizacion;
	private double costoPorHora;
	private boolean finalizado;
	
	
	public Trabajo(Servicio servicio, LocalDate fechaTrabajo,double costoPorHora) {
		this.servicio=servicio;
		this.fechaTrabajo=fechaTrabajo;
		this.fechaFinalizacion=null;
		this.costoPorHora=costoPorHora;
		this.finalizado=false;
	}
	
	public LocalDate getFechaTrabajo() {
		return this.fechaTrabajo;
	}
	
	/*
	 * Este metodo indica la finalizacion del trabajo marcandolo como finalizado
	 * y realiza el calculo del precio final del servicio considerando las horas 
	 * que tardo en realizarse
	 */
	
	public void marcarFinalizacion() {
		this.finalizado=true;
		this.horaFinalizacion=LocalTime.now();
		this.fechaFinalizacion=LocalDate.now();
		
		int horaInicioSeg=servicio.getHoraInicio().toSecondOfDay();
		int horaFinSeg=this.horaFinalizacion.toSecondOfDay();
		
		double horasTrabajadas = (double)(horaFinSeg-horaInicioSeg)/(3600.00);

		double costoTrabajador=horasTrabajadas*this.costoPorHora;
		this.servicio.costo(costoTrabajador);
	}
	
	public Servicio getServicio() {
		return this.servicio;
	}
	
	public boolean finalizado() {
		if(this.fechaFinalizacion==null) {
			return false;
		}
		else {
			return true;
		}
	}
	
}
