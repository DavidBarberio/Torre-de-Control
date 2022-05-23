package Aeropuerto.ui;

import javax.swing.*;

import Aeropuerto.persistencia.BaseDatos;

import java.awt.*;

public class Historial extends JPanel {
	JLabel titulo = new JLabel("Historial Solicitudes");
	
	public Historial() {
		super();
		setLayout(new BorderLayout());
		add(crearTitulo(), BorderLayout.NORTH);
		add(mostrarHistorial(), BorderLayout.CENTER);
	}
	
	public JPanel crearTitulo() {
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		panelTitulo.add(titulo);
		return panelTitulo;
	}
	
	public JPanel mostrarHistorial() {
		JPanel mostrarHistorial = new JPanel();
		mostrarHistorial.setLayout(new BoxLayout(mostrarHistorial, BoxLayout.Y_AXIS));

		if(BaseDatos.autorizadas.isEmpty()) {
			JLabel empty = new JLabel("No hay solicitudes autorizadas");
			empty.setForeground(Colores.ROJO_BG);
			mostrarHistorial.add(empty);

		} else {
				BaseDatos.autorizadas.forEach(x -> {
				JPanel solicitud = new JPanel();
				solicitud.setLayout(new FlowLayout());
				JLabel operacion = new JLabel("Operacion: " + x.tipo);
				JLabel hora = new JLabel("Hora: " + x.hora);
				JLabel codigo = new JLabel("Codigo Avion: " + x.codigo);
				solicitud.add(operacion);
				solicitud.add(hora);
				solicitud.add(codigo);
				mostrarHistorial.add(solicitud);
			});
		}
		return mostrarHistorial;
	}
}
