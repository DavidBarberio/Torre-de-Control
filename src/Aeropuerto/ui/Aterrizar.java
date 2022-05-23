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

public class Aterrizar extends JPanel {
	private JButton solicitar = new JButton("Solicitar");
	private JCheckBox especial = new JCheckBox("Urgente", false);
	JLabel codeLabel = new JLabel("Codigo Avion: ");
	JTextField codeField = new JTextField(25);
	JLabel fechaLabel = new JLabel("Fecha Operacion: ");
	JTextField fechaFieldDay = new JTextField(2);
	JTextField fechaFieldMonth = new JTextField(2);
	JTextField fechaFieldYear = new JTextField(4);
	JLabel procedenciaLabel = new JLabel("Procedencia: ");
	JTextField procedenciaField = new JTextField(25);
	JLabel titulo = new JLabel("Solicitud Aterrizaje");
	
	public Aterrizar() {
		super();
		setLayout(new BorderLayout());
		add(crearTitulo(), BorderLayout.NORTH);
		add(crearPanelBotones(), BorderLayout.SOUTH);
		add(crearPanelFormulario(), BorderLayout.CENTER);
	}
	public void reset() {
		codeField.setText(null);
		fechaFieldDay.setText(null);
		fechaFieldMonth.setText(null);
		fechaFieldYear.setText(null);
		procedenciaField.setText(null);
		especial.setSelected(false);
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
		JPanel panelCode = new JPanel();
		panelCode.add(codeLabel);
		panelCode.add(codeField);
		panelFormulario.add(panelCode);
		
		JPanel panelFecha = new JPanel();
		panelFecha.add(fechaLabel);
		panelFecha.add(fechaFieldDay);
		panelFecha.add(new JLabel("/"));
		panelFecha.add(fechaFieldMonth);
		panelFecha.add(new JLabel("/"));
		panelFecha.add(fechaFieldYear);
		panelFormulario.add(panelFecha);
		
		JPanel panelProcedencia = new JPanel();
		panelProcedencia.add(procedenciaLabel);
		panelProcedencia.add(procedenciaField);
		panelFormulario.add(panelProcedencia);
		
		JPanel panelEspecial = new JPanel();
		panelEspecial.add(especial);
		panelFormulario.add(panelEspecial);
		
		return panelFormulario;
	}
	
	public JPanel crearPanelBotones() {
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new FlowLayout());
		panelBotones.add(solicitar);
		
		
		solicitar.setBackground(Colores.VERDE_BG);
		solicitar.setForeground(Colores.VERDE_FG);
		solicitar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
				String fechaFormateada = fechaFieldDay.getText() + "/" + fechaFieldMonth.getText() + "/" + fechaFieldYear.getText();

				Solicitud solicitud = new Solicitud(
						codeField.getText(),
						fechaFormateada,
						procedenciaField.getText(),
						especial.isSelected(),
						dtf.format(LocalDateTime.now()),
						TipoOperacion.ATERRIZAJE
						);
				BaseDatos.anadirSolicitud(solicitud);
				reset();
			}
		});
		return panelBotones;
	}
}
