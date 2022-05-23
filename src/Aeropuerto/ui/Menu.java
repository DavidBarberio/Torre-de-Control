package Aeropuerto.ui;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
	private JButton opcion0;
	private JButton opcion1;
	private JButton opcion2;
	private JButton opcion3;
	private JButton opcion4;
	
	private Container container;
	
	private JPanel panelCentral = new JPanel();
	
	public Menu() throws HeadlessException {
		super("Torre de Control");
		setSize(800, 400);
		container = this.getContentPane();
		container.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		
		generarMenu(panel);
		
		container.add(panel, BorderLayout.WEST);
		container.add(panelCentral, BorderLayout.CENTER);
		resetPaneles();
		
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		seleccionarInicio();
	}

	private void generarMenu(JPanel panel) {
		opcion0 = new JButton("Inicio");
		opcion0.addActionListener(e -> seleccionarInicio());

		opcion1 = new JButton("1.- Solicitar permiso para aterrizar");
		opcion1.addActionListener(e -> seleccionarAterrizaje());
		
		opcion2 = new JButton("2.- Solicitar permiso para despegue");
		opcion2.addActionListener(e -> seleccionarDespegue());
		
		opcion3 = new JButton("3.- Autorizar Operacion");
		opcion3.addActionListener(e -> seleccionarAutorizar());
		
		opcion4 = new JButton("4.- Historial Operaciones");
		opcion4.addActionListener(e -> seleccionarHistorial());
		
		panel.add(opcion0);
		panel.add(opcion1);
		panel.add(opcion2);
		panel.add(opcion3);
		panel.add(opcion4);
	}

	public void seleccionarInicio(){
		resetPaneles();
		panelCentral.add(new Inicio());
		repintar();
	}
	
	public void seleccionarAterrizaje() {
		resetPaneles();
		panelCentral.add(new Aterrizar());
		repintar();
	}
	
	public void seleccionarDespegue() {
		resetPaneles();
		panelCentral.add(new Despegar());
		repintar();
	}
	
	private void seleccionarAutorizar() {
		resetPaneles();
		panelCentral.add(new Autorizar());
		repintar();
	}
	
	private void seleccionarHistorial() {
		resetPaneles();
		panelCentral.add(new Historial());
		repintar();
	}
	
	public void resetPaneles() {
		panelCentral.removeAll();
	}

	public void repintar(){
		panelCentral.revalidate();
		panelCentral.repaint();
	}
}
