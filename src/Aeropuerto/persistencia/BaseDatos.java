package Aeropuerto.persistencia;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import Aeropuerto.modelo.Solicitud;

public class BaseDatos {
	public static List<Solicitud> pendientes = new ArrayList<>();
	public static List<Solicitud> autorizadas = new ArrayList<>();

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
	
	public static void anadirSolicitud(Solicitud solicitud) {
		int longitud = pendientes.size();
		if (longitud >= 2) {
			Solicitud solicitud1 = pendientes.get(longitud -2);
			Solicitud solicitud2 = pendientes.get(longitud -1);
			
			if(solicitud1.tipo == solicitud2.tipo && solicitud.tipo !=solicitud1.tipo) {
				pendientes.set(longitud -1, solicitud);
				pendientes.add(solicitud2);
			}else {
				pendientes.add(solicitud);			}
		}else {
			pendientes.add(solicitud);
		}
		Collections.sort(pendientes);
	}
}
