package Aeropuerto.persistencia;

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
}
