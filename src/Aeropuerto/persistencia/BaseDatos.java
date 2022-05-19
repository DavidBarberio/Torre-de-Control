package Aeropuerto.persistencia;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Aeropuerto.modelo.Solicitud;

public class BaseDatos {
	public static List<Solicitud> pendientes = new ArrayList<>();
	public static List<Solicitud> autorizadas = new ArrayList<>();
	
	public static void imprimirPendientes() {
		System.out.println("Solicitudes Pendientes");
		pendientes.forEach(x -> System.out.println(x));
	}

	public static void generarFichero(){
		PrintWriter salida = null;
		try {
			salida = new PrintWriter("Historial.txt");
			for (Solicitud s : autorizadas) {
				salida.println(s.toFile());
			}
			salida.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			salida.close();
		}
	}
}
