package Aeropuerto.ui;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
	private JButton opcion1;
	private JButton opcion2;
	private JButton opcion3;
	private JButton opcion4;
	
	private Container container;
	
	private JPanel panel1 = new Aterrizar();
	private JPanel panel2 = new Despegar();
	
	private JPanel panelActivo = new JPanel();
	
	public Menu() throws HeadlessException {
		super("Torre de Control");
		setSize(750, 400);
		container = this.getContentPane();
		container.setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1));
		
		generarMenu(panel);
		
		container.add(panel, BorderLayout.WEST);
		container.add(panelActivo, BorderLayout.CENTER);
		resetPaneles();
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void generarMenu(JPanel panel) {
		opcion1 = new JButton("1.- Solicitar permiso para aterrizar");
		opcion1.addActionListener(e -> seleccionarAterrizaje());
		
		opcion2 = new JButton("2.- Solicitar permiso para despegue");
		opcion2.addActionListener(e -> seleccionarDespegue());
		
		opcion3 = new JButton("3.- Autorizar Operación");
		opcion3.addActionListener(e -> seleccionarAutorizar());
		
		opcion4 = new JButton("4.- Historial Operaciones");
		opcion4.addActionListener(e -> seleccionarHistorial());
		
		panel.add(opcion1);
		panel.add(opcion2);
		panel.add(opcion3);
		panel.add(opcion4);
	}
	
	public void seleccionarAterrizaje() {
		resetPaneles();
		container.add(panel1, BorderLayout.CENTER);
		panelActivo = panel1;
		panel1.setVisible(true);
	}
	
	public void seleccionarDespegue() {
		resetPaneles();
		container.add(panel2, BorderLayout.CENTER);
		panelActivo = panel2;
		panel2.setVisible(true);
	}
	
	private void seleccionarAutorizar() {
		resetPaneles();
		JPanel panel3 = new Autorizar();
		container.add(panel3, BorderLayout.CENTER);
		panelActivo = panel3;
		panel3.setVisible(true);
	}
	
	private void seleccionarHistorial() {
		resetPaneles();
		JPanel panel4 = new Historial();
		container.add(panel4, BorderLayout.CENTER);
		panelActivo = panel4;
		panel4.setVisible(true);
	}
	
	public void resetPaneles() {
		panel1.setVisible(false);
		panel2.setVisible(false);
		panelActivo.setVisible(false);
		container.remove(panelActivo);
	}
}
