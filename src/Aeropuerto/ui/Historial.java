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
		panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
		
		if(BaseDatos.autorizadas.isEmpty()) {
			JLabel empty = new JLabel("No hay solicitudes autorizadas");
			empty.setForeground(Colores.ROJO_BG);
			panelFormulario.add(empty);
		} else {
		
			BaseDatos.autorizadas.forEach(x -> {
				JPanel solicitud = new JPanel();
				solicitud.setLayout(new FlowLayout());
				JLabel operacion = new JLabel("Operación: " + x.tipo);
				JLabel hora = new JLabel("Hora: " + x.hora);
				JLabel codigo = new JLabel("Código Avión: " + x.codigo);
				solicitud.add(operacion);
				solicitud.add(hora);
				solicitud.add(codigo);
				panelFormulario.add(solicitud);
			});
		}
		return panelFormulario;
	}
}
