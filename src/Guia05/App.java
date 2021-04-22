package Guia05;

import java.time.*;

import Exceptions.*;


public class App {

	public static void main(String[] args) {
		/*Se crea el usuario*/
		Usuario user = new Usuario("Goux Nicolás", "nicolasgoux2000@gmail.com");
		
		/*Se crean los trabajadores*/
		Trabajador trabajador1 = new Trabajador("Juan Fernandez","juanFernandez@gmail.com",Oficio.CARPINTERIA,100,0.2);
		Trabajador trabajador2 = new Trabajador("Lucas Ramirez","lucasRamirez@gmail.com",Oficio.CERRAJERIA,150,0.2);
		
		/*Se crean los servicios*/
		Servicio servicio1 = new ServicioEstandar(Oficio.CARPINTERIA,"Reparacion", LocalDate.now(), LocalTime.parse("14:00:00"),1000);
		Servicio servicio2 = new ServicioEstandar(Oficio.CERRAJERIA,"Reparacion", LocalDate.now(), LocalTime.parse("14:00:00"),1500);
		Servicio servicio3 = new ServicioPersonalizado(Oficio.CARPINTERIA,"Reparacion", LocalDate.now(), LocalTime.parse("14:00:00"));
		Servicio servicio4 = new ServicioPersonalizado(Oficio.CERRAJERIA,"Reparacion", LocalDate.parse("2021-04-25"), LocalTime.parse("14:00:00"));
		
		/*Se crean las herramientas*/
		Herramienta herramienta1 = new Herramienta("Pack de destornilladores",100);
		Herramienta herramienta2 = new Herramienta("Taladro",100);
		Herramienta herramienta3 = new Herramienta("Martillo",50);
		Herramienta herramienta4 = new Herramienta("Pinza",50);
		Herramienta herramienta5 = new Herramienta("Llave inglesa",25);
		
		/*Se crean los alquileres */
		Alquiler alquiler1 = new Alquiler(herramienta1, LocalDate.parse("2021-04-10"),LocalDate.parse("2021-04-20"));
		Alquiler alquiler2 = new Alquiler(herramienta2, LocalDate.parse("2021-04-10"),LocalDate.parse("2021-04-20"));
		Alquiler alquiler3 = new Alquiler(herramienta3, LocalDate.parse("2021-04-10"),LocalDate.parse("2021-04-20"));
		Alquiler alquiler4 = new Alquiler(herramienta4, LocalDate.now(),LocalDate.parse("2021-04-27"));
		Alquiler alquiler5 = new Alquiler(herramienta5, LocalDate.now(),LocalDate.parse("2021-04-27"));
		
		/*El usuario contrata los servicios*/
		try { 
			user.contratar(servicio1);
			System.out.println("Servicio contratado!");
		}
		catch (AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try { 
			user.contratar(servicio2);
			System.out.println("Servicio contratado!");
		}
		catch (AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try { 
			user.contratar(servicio3);
			System.out.println("Servicio contratado!");
		}
		catch (AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try { 
			user.contratar(servicio4);
			System.out.println("Servicio contratado!");
		}
		catch (AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}

		
		//OficioNoCoincideException
		try {	
			trabajador2.agregarTarea(servicio1);
			System.out.println("Trabajo agregado al trabajador 2");
		}
		catch(AgendaOcupadaException | OficioNoCoincideException | CostoNoPresupuestadoException e) {
			e.printStackTrace();
		}
		
		try { //En este trabajador puede agregarse la tarea, por lo tanto, se almacena
			trabajador1.agregarTarea(servicio1);
			System.out.println("Trabajo agregado al trabajador 1");
		}
		catch(AgendaOcupadaException | OficioNoCoincideException | CostoNoPresupuestadoException e) {
			e.printStackTrace();
		}
		
		
		//CostoNoPresupuestadoException
		try {
			trabajador2.agregarTarea(servicio4);
			System.out.println("Trabajo agregado al trabajador 2");
		}
		catch(AgendaOcupadaException | OficioNoCoincideException | CostoNoPresupuestadoException e) {
			e.printStackTrace();
		}
		
		try { //En este caso puede almacenarse el servicio debido a que fue presupuestado anteriormente
			trabajador2.presupuestarServicio((ServicioPersonalizado)servicio4, 2500.00, 500.00, 500);
			trabajador2.agregarTarea(servicio4);
			System.out.println("Trabajo agregado al trabajador 2");
		}
		catch(AgendaOcupadaException | OficioNoCoincideException | CostoNoPresupuestadoException e) {
			e.printStackTrace();
		}

		
		//AgendaOcupadaException
		try {
			trabajador1.presupuestarServicio((ServicioPersonalizado)servicio3, 1, 1, 1);
			trabajador1.agregarTarea(servicio3);
			System.out.println("Trabajo agregado al trabajador 1");
		}
		catch(AgendaOcupadaException | OficioNoCoincideException | CostoNoPresupuestadoException e) {
			e.printStackTrace();
		}
		
		try {//En este caso el trabajador puede almacenar tanto el servicio 2 como el 4 porque no se superponen sus fechas
			trabajador2.agregarTarea(servicio2);
			System.out.println("Trabajo agregado al trabajador 2");
		}
		
		catch(AgendaOcupadaException | OficioNoCoincideException | CostoNoPresupuestadoException e) {
			e.printStackTrace();
		}
		
		//TrabajoNoPerteneceAlTrabajadorException
		try{
			trabajador1.marcarTrabajoFinalizado(servicio3);
			System.out.println("Se ha finalizado el trabajo y se ha calculado su costo final");
		}
		catch (TrabajoNoPerteneceAlTrabajadorException c) {
			c.printStackTrace();
		}
		
		
		try{//En este caso se marca como finalizado un servicio que pertenece al trabajador indicado
			trabajador1.marcarTrabajoFinalizado(servicio1);
			System.out.println("Se ha finalizado el trabajo del servicio 1 y se ha calculado su costo final");
		}
		catch (TrabajoNoPerteneceAlTrabajadorException c) {
			c.printStackTrace();
		}
		
		try{//En este caso se marca como finalizado un servicio que pertenece al trabajador indicado
			trabajador2.marcarTrabajoFinalizado(servicio2);
			trabajador2.marcarTrabajoFinalizado(servicio4);
			System.out.println("Se han finalizado los trabajos del servicio 2 y 4 se han calculado sus costos finales");
		}
		catch (TrabajoNoPerteneceAlTrabajadorException c) {
			c.printStackTrace();
		}
		
		/*
		 * 
		 * PARA LA REALIZACION DE LOS METODOS RELACIONADOS AL CALCULO DE COSTOS DE LOS SERVICIOS
		 * Y ALQUILERES CONSIDERE MAS PRACTICO QUE EL CALCULO SEA REALIZADO AUTOMATICAMENTE AL REALIZARSE
		 * LA FINALIZACION (CASO DE LOS SERVICIOS) O LA DEVOLUCION (CASO DE LOS ALQUILERES). LOS METODS
		 * SE ENCUENTRAN CREADOS EN SUS RESPECTIVAS CLASES PERO SON INVOCADOS AL LLAMAR A LOS METODOS
		 * "marcarTrabajoFinalizado(servicio)" y "devolver(alquiler)" 
		 * 
		*/
		
		System.out.println("\n");
		
		//Se alquilan 3 herramientas
		try {
			user.contratar(alquiler1);
			System.out.println("Herramienta 1 alquilada");
		}
		catch(AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try {
			user.contratar(alquiler2);
			System.out.println("Herramienta 2 alquilada");
		}
		catch(AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		try {
			user.contratar(alquiler3);
			System.out.println("Herramienta 3 alquilada");
		}
		catch(AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		
		
		//AlquierNoEntregadoException
		try {
			user.contratar(alquiler4);
			System.out.println("Herramienta 3 alquilada");
		}
		catch(AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
		
		
		try {//Se devuelve uno de los alquileres que se encuetran demorados
			user.devolver(alquiler1);
			System.out.println("La herramienta 1 fue devuelta con exito (con demora)");
			
			//Como solo existen dos alquileres demorados podran alquilarse nuevas herramientas sin problemas
			user.contratar(alquiler4);
			System.out.println("Herramienta 4 alquilada");
			
			user.contratar(alquiler5);
			System.out.println("Herramienta 5 alquilada");
		}
		catch(AlquilerNoEntregadoException e) {
			e.printStackTrace();
		}
	}
}
