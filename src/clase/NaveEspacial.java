package clase;

import java.util.Scanner;

public class NaveEspacial {
	Scanner teclado= new Scanner(System.in);
	
	private String nombre;
	private int anio_creacion;
	private int anio_lanzamiento;
	private int capacidadtotal_personas;
	private int tripulantes_necesarios;
	
	int anioActual= 2024;
	
	//CONSTRUCTORES
	public NaveEspacial(String nombre, int anio_creacion, int anio_lanzamiento, int capacidadtotal_personas,
			int tripulantes_necesarios) {
		
		this.nombre = nombre;
		this.anio_creacion = anio_creacion;
		this.anio_lanzamiento = anio_lanzamiento;
		this.capacidadtotal_personas = capacidadtotal_personas;
		this.tripulantes_necesarios = tripulantes_necesarios;
	}

	public NaveEspacial() {
		super();
	}
	//GETERS Y SETERS

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnio_creacion() {
		return anio_creacion;
	}

	public void setAnio_creacion(int anio_creacion) {
		this.anio_creacion = anio_creacion;
	}

	public int getAnio_lanzamiento() {
		return anio_lanzamiento;
	}

	public void setAnio_lanzamiento(int anio_lanzamiento) {
		this.anio_lanzamiento = anio_lanzamiento;
	}

	public int getCapacidadtotal_personas() {
		return capacidadtotal_personas;
	}

	public void setCapacidadtotal_personas(int capacidadtotal_personas) {
		this.capacidadtotal_personas = capacidadtotal_personas;
	}

	public int getTripulantes_necesarios() {
		return tripulantes_necesarios;
	}

	public void setTripulantes_necesarios(int tripulantes_necesarios) {
		this.tripulantes_necesarios = tripulantes_necesarios;
	}
	
	//METODOS
	
	@Override
	public String toString() {
		return "Nave Espacial: " + nombre + " Año de Creacion: " + anio_creacion + " Año de lanzamiento: "
				+ anio_lanzamiento + " Capacidad Total: " + capacidadtotal_personas
				+ " Tripulantes Necesarios: " + tripulantes_necesarios;
	}
	
	public int calcularAntiguedad(int anioActual) {
		
		return anioActual - anio_creacion;
		
	}
	
	public boolean admitePasajeros() {
		boolean lleno= false;
		
		if(capacidadtotal_personas == tripulantes_necesarios) {
			lleno= true;
		}
		
		return lleno;
		
	}
	
	public void setDatos() {
		
		System.out.println("Introduce el año de creacion");
		anio_creacion= teclado.nextInt();
		do {
			System.out.println("Introduce el año de lanzamiento");
			anio_lanzamiento= teclado.nextInt();
			if(anio_lanzamiento < anio_creacion) {
				System.out.println("Error: El año de lanzamiento no puede ser anterior al año de creación.");
			}
		}while(anio_lanzamiento < anio_creacion);
		
		System.out.println("Introduce la capacidad total de personas");
		capacidadtotal_personas= teclado.nextInt();
		System.out.println("Introduce el numero de tripulantes necesarios");
		tripulantes_necesarios= teclado.nextInt();
	}
	
	
	
	
	
	
	
	
	

}
