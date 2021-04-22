package Guia05;

import java.time.LocalDate;

import Exceptions.*;

public class Alquiler implements Contratable {
	private Herramienta herramienta;
	private double costoAlquiler;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private LocalDate fechaDevolucion;
	
	public Alquiler(Herramienta herramienta, LocalDate fechaInicio, LocalDate fechaFin) {
		this.herramienta = herramienta;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaDevolucion = null;
		this.costoAlquiler=0;
	}
	
	public void costoAlquiler() {
		int diaInicio = this.fechaInicio.getDayOfYear();
		int diaDevolucion = this.fechaDevolucion.getDayOfYear();
		
		double costoAlquiler = (diaDevolucion - diaInicio)*this.herramienta.getCostoDiario();
		
		this.costoAlquiler=costoAlquiler;
	}
	
	public boolean enMora() {
		if (this.fechaDevolucion == null) {
			if(this.fechaFin.compareTo(LocalDate.now())<0) {
				return true;
			}
			else {
				return false;
			}
		}
		
		else if (this.fechaFin.compareTo(fechaDevolucion)<0) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public boolean finalizado() {
		if (this.fechaDevolucion==null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void marcarDevolucion() {
		this.fechaDevolucion=LocalDate.now();
	}
	
	
}
