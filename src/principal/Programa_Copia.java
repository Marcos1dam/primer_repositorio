package principal;

import java.util.Scanner;

import clase.NaveEspacial;

public class Programa {

	public static void main(String[] args) {
		Scanner teclado= new Scanner(System.in);
		
		NaveEspacial[] naves= new NaveEspacial[50];
		int opc=0, cont=0;
		
		do {
			opc=Menu(cont, teclado);
			
			if(cont == 0 &&(cont > 1 && cont < 7)) {
				System.out.println("No hay naves espaciales registradas");
			}else {
				switch (opc) {
				case 1:
					cont=aniadir_Naves(naves, cont, teclado);
					break;
				case 2:
					mostrarpor_Antiguedad(naves, cont, teclado);
					break;
				case 3:
					ordenarpor_Lanzamiento(naves, cont, teclado);
					break;
				case 4:
					modificar_Capacidad(naves, cont, teclado);
					break;
				case 5:
					mostrar_Naves(naves, cont);
					break;
				case 6:
					cont=eliminar_Nave(naves, cont, teclado);
					break;
				default:
					if(opc < 1 && opc > 7) {
						System.out.println("Elige una opcion valida");
					}
					if(opc == 7) {
						System.out.println("Hasta luego.");
					}
				}
			}
		}while(opc != 7);

	}

	private static void modificar_Capacidad(NaveEspacial[] naves, int cont, Scanner teclado) {
		System.out.println("Introduce");
		System.out.println("porbar git con cambios");
		System.out.println("porbar git con cambios");
		System.out.println("porbar git con cambios");
		
	}

	private static void mostrar_Naves(NaveEspacial[] naves, int cont) {
		for(int i=0; i < cont;i++) {
			System.out.println(naves[i].toString());
		}
		
	}

	private static int eliminar_Nave(NaveEspacial[] naves, int cont, Scanner teclado) {
		String nombreaux;
		String resp;
		int libroaeliminar=0;
		System.out.println("Introduzca el ISBN del libro que desea elimenar");
		nombreaux= teclado.next();
		System.out.println("¿Desae eliminar la nave con nombre: "+ nombreaux+"? si/no");
		resp=teclado.next();
		
		if(resp.equalsIgnoreCase("si")) {
			for(int i=0; i < cont; i++) {
				if(nombreaux.equalsIgnoreCase(naves[i].getNombre())) {
					libroaeliminar= i;
				}
			}
			for(int j= libroaeliminar; j < cont-1; j++) {
				naves[j]= naves[j+1];
			}
			cont -= cont;
			
		}
		return cont;
		
	}

	private static void ordenarpor_Lanzamiento(NaveEspacial[] naves, int cont, Scanner teclado) {
	NaveEspacial aux;
			
			for(int i=0; i < cont;i++) {
				for(int j= i+1; j < cont; j++) {
					if(naves[j].getAnio_lanzamiento() > naves[i].getAnio_lanzamiento()) {
						aux= naves[i];
						naves[i]= naves[j];
						naves[j]= aux;
						
					}
				}
				System.out.println(naves[i].toString());
			}
		
	}

	private static void mostrarpor_Antiguedad(NaveEspacial[] naves, int cont, Scanner teclado) {
		int antiguedadaux;
		boolean encontrado= false;
		System.out.println("Introduce antiguedad minima");
		antiguedadaux= teclado.nextInt();
		for(int i=0; i < cont;i ++) {
			if(naves[i].calcularAntiguedad(i) > antiguedadaux) {
				System.out.println(naves[i].toString());
				encontrado= true;
			}
		}
		if(encontrado= false) {
			System.out.println("No se encontraron naves con antiguedad superior a "+antiguedadaux);
		}
		
	}

	private static int aniadir_Naves(NaveEspacial[] naves, int cont, Scanner teclado) {
		String sal = "si", nombre;
		boolean exiteNombre;
		NaveEspacial nave;

		for (; cont < naves.length && sal.equalsIgnoreCase("si");) {
			
			exiteNombre = false;
			System.out.println("Introduce el nombre: ");
			nombre = teclado.next();
			exiteNombre = buscarNombre(naves, nombre, cont);

			if (exiteNombre == true) {
				System.out.println("Ya existe una nave con ese nombre");
			} else {
				nave= new NaveEspacial();
				nave.setNombre(nombre);
				nave.setDatos();
				naves[cont++] = nave;
				System.out.println("Nave añadida exitosamente");
			}
			System.out.println("¿Quieres Seguir introduciendo naves?");
			sal = teclado.next();
		}
		if (cont >= naves.length) {
			System.out.println("Has Alcanzado El Limite De naves");

		}
		return cont;
	}

	private static boolean buscarNombre(NaveEspacial[] naves, String nombre, int cont) {
		boolean existe = false;

		for (int i = 0; i < cont && existe == false; i++) {
			existe = nombre.equalsIgnoreCase(naves[i].getNombre());
		}

		return existe;
	}		

	private static int Menu(int opc, Scanner teclado) {
		System.out.println("*****MENU*****");
		System.out.println("1. Añadir naves espaciales");
		System.out.println("2. Mostrar naves cuya antiguedad sea superior a una dada");
		System.out.println("3. Ordenar naves por año de lanzamiento");
		System.out.println("4. Modificar capacidad total de las naves que admiten pasajeros");
		System.out.println("5. Mostrar todas las naves espaciales registradas");
		System.out.println("6. Eliminar una nave espacial");
		System.out.println("7. Salir del programa");
		opc=teclado.nextInt();
		return opc;
		
		
	}

}
