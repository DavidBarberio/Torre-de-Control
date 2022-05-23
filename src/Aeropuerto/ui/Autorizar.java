package Aeropuerto.ui;

import javax.swing.*;

import Aeropuerto.persistencia.BaseDatos;

import java.awt.*;

public class Autorizar extends JPanel {
	JLabel titulo = new JLabel("Autorizar Solicitud");
	
	public Autorizar() {
		super();
		setLayout(new BorderLayout());
		add(crearTitulo(), BorderLayout.NORTH);
		add(crearListaSolicitudes(), BorderLayout.CENTER);
	}
	
	public JPanel crearTitulo() {
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		panelTitulo.add(titulo);
		return panelTitulo;
	}
	
	public JPanel crearListaSolicitudes() {
		JPanel listaSolicitudes = new JPanel();
		listaSolicitudes.setLayout(new BoxLayout(listaSolicitudes, BoxLayout.Y_AXIS));

		if(BaseDatos.pendientes.isEmpty()) {
			JLabel empty = new JLabel("No hay solicitudes pendientes");
			empty.setForeground(Colores.ROJO_BG);
			listaSolicitudes.add(empty);
		} else {
		
		BaseDatos.pendientes.forEach(x -> {
			JPanel solicitud = new JPanel();
			solicitud.setLayout(new FlowLayout());
			JLabel operacion = new JLabel("Operacion: " + x.tipo + " | ");
			JLabel hora = new JLabel("Hora: " + x.hora + " | ");
			JLabel codigo = new JLabel("Codigo Avion: " + x.codigo + " | ");
			JLabel urgente = new JLabel("Urgente: " + x.urgente);
			solicitud.add(operacion);
			solicitud.add(hora);
			solicitud.add(codigo);
			solicitud.add(urgente);
			listaSolicitudes.add(solicitud);
			
			JButton autorizar = new JButton("Autorizar");
			autorizar.setBackground(Colores.VERDE_BG);
			autorizar.setForeground(Colores.VERDE_FG);
			
			autorizar.addActionListener(e -> {
					BaseDatos.autorizadas.add(x);
					BaseDatos.generarFichero();
					BaseDatos.pendientes.remove(x);
					listaSolicitudes.remove(solicitud);
					listaSolicitudes.revalidate();
					listaSolicitudes.repaint();
					});
				solicitud.add(autorizar);
			});
		}
		return listaSolicitudes;
	}
}
