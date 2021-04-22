package Guia05;

public class Herramienta {
	private String nombre;
	private double costoDiario;
	
	public Herramienta(String nombre, double costoDiario) {
		this.nombre = nombre;
		this.costoDiario = costoDiario;
	}

	public double getCostoDiario() {
		return this.costoDiario;
	}
}
