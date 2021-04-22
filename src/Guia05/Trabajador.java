package Guia05;

import Exceptions.*;
import java.util.ArrayList;

public class Trabajador {
	private String nombre;
	private String email;
	private Oficio oficio;
	private double costoPorHora;
	private double porcentajeComision;
	private ArrayList<Trabajo> listaTrabajos;
	
	
	
	public Trabajador(String nombre, String email, Oficio oficio, double costoPorHora, double porcentajeComision) {
		this.nombre = nombre;
		this.email = email;
		this.oficio = oficio;
		this.costoPorHora = costoPorHora;
		this.porcentajeComision = porcentajeComision;
		this.listaTrabajos = new ArrayList<>(1);
	}


	public void agregarTarea(Servicio servicio) throws AgendaOcupadaException,OficioNoCoincideException, CostoNoPresupuestadoException {
		boolean verificarPresupuesto=true;
		if(servicio instanceof ServicioPersonalizado) {
			if (((ServicioPersonalizado) servicio).getPresupuestado()==false) {
				throw new CostoNoPresupuestadoException();
			}
		}
		
		if (servicio.getOficio() != this.oficio && verificarPresupuesto==true) {
			throw new OficioNoCoincideException();
		}
		
		else if(listaTrabajos.isEmpty()==false && verificarPresupuesto==true) {
			boolean ocupado=false;
			for (Trabajo unTrabajo : listaTrabajos) {
				if (unTrabajo.getFechaTrabajo().compareTo(servicio.fechaInicio)==0) {
					ocupado=true;
				}
			}
			if (ocupado==true) {
				throw new AgendaOcupadaException();
			}
			
			else {
				listaTrabajos.add(new Trabajo(servicio,servicio.getFecha(),this.costoPorHora));
			}
			
		}
		
		else if (verificarPresupuesto==true) {
			listaTrabajos.add(new Trabajo(servicio,servicio.getFecha(),this.costoPorHora));
		}
	}
	
	
	public void marcarTrabajoFinalizado(Servicio servicio) throws TrabajoNoPerteneceAlTrabajadorException {

		for (Trabajo unTrabajo : this.listaTrabajos) {
			if (unTrabajo.getServicio()==servicio) {
				unTrabajo.marcarFinalizacion();
				return;
			}
		}
		
		throw new TrabajoNoPerteneceAlTrabajadorException();
	}
	
	public void presupuestarServicio(ServicioPersonalizado servicio, double costoPresupuesto, double costoMateriales, double costoTransporte) {
		servicio.marcarPresupuestado(costoPresupuesto, costoMateriales, costoTransporte);
	}
	
	public ArrayList<Trabajo> getLista(){
		return this.listaTrabajos;
	}
}
