package Guia05;

import java.util.ArrayList;
import Exceptions.*;

public class Usuario {
	private String nombre;
	private String email;
	private ArrayList<Contratable> listaContratados;
	
	public Usuario(String nombre, String email) {
		this.nombre = nombre;
		this.email=email;
		this.listaContratados = new ArrayList<>(1);
	}
	
	public void contratar(Contratable c) throws AlquilerNoEntregadoException {
		if (this.listaContratados.isEmpty()) {
			listaContratados.add(c);
			
		}
		
		else {
			if (c instanceof Servicio) {
				listaContratados.add(c);
			}
			else if (c instanceof Alquiler){
				
				int i=0;
				for (Contratable alq : this.listaContratados) {
					if (alq instanceof Alquiler && ((Alquiler) alq).enMora()) {
						i++;
					}
				}
				if (i>2) {
					throw new AlquilerNoEntregadoException();
				}
				
				else {
					listaContratados.add(c);
				}
			}
		}
	}
	
	public void devolver(Alquiler alq) {
		alq.marcarDevolucion();
		this.listaContratados.remove(alq);
		alq.costoAlquiler();
	}
	
	public ArrayList<Contratable> getLista(){
		return this.listaContratados;
	}
	
}
