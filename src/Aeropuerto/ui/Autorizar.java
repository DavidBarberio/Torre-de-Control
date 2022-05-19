package Aeropuerto.ui;

import javax.swing.*;

import Aeropuerto.modelo.Solicitud;
import Aeropuerto.modelo.TipoOperacion;
import Aeropuerto.persistencia.BaseDatos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Autorizar extends JPanel {
	JLabel titulo = new JLabel("Autorizar Solicitud");
	
	public Autorizar() {
		super();
		setLayout(new BorderLayout());
		add(crearTitulo(), BorderLayout.NORTH);
		add(crearPanelFormulario(), BorderLayout.CENTER);
	}
	
	public JPanel crearTitulo() {
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		panelTitulo.add(titulo);
		return panelTitulo;
	}
	
	public JPanel crearPanelFormulario() {
		JPanel panelFormulario = new JPanel();
		
		if(BaseDatos.pendientes.isEmpty()) {
			JLabel empty = new JLabel("No hay solicitudes pendientes");
			empty.setForeground(Colores.ROJO_BG);
			panelFormulario.add(empty);
		} else {
		
		BaseDatos.pendientes.forEach(x -> {
			JPanel solicitud = new JPanel();
			solicitud.setLayout(new FlowLayout());
			JLabel operacion = new JLabel("Operación: " + x.tipo);
			JLabel hora = new JLabel("Hora: " + x.hora);
			JLabel codigo = new JLabel("Código Avión: " + x.codigo);
			solicitud.add(operacion);
			solicitud.add(hora);
			solicitud.add(codigo);
			panelFormulario.add(solicitud);
			
			JButton autorizar = new JButton("Autorizar");
			autorizar.setBackground(Colores.VERDE_BG);
			autorizar.setForeground(Colores.VERDE_FG);
			
			autorizar.addActionListener(e -> {
					BaseDatos.autorizadas.add(x);
					BaseDatos.pendientes.remove(x);
					panelFormulario.remove(solicitud);
					panelFormulario.revalidate();
					panelFormulario.repaint();
					});
				solicitud.add(autorizar);
			});
		}
		return panelFormulario;
	}
}
