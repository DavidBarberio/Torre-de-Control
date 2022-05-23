package Aeropuerto.ui;

import javax.swing.*;

import java.awt.*;
import java.io.File;

public class Inicio extends JPanel {
	JLabel titulo = new JLabel("Aeropuerto Plaiaundi");
	JPanel panelImage = new JPanel();
	Image portada = new ImageIcon("Images" + File.separator + "Portada.JPG").getImage();
	JLabel imgLabel = new JLabel();

	public Inicio() {
		super();
		setLayout(new BorderLayout());
		add(crearTitulo(), BorderLayout.NORTH);
		//Escala imagen
		Image newimg = portada.getScaledInstance(550, 350,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(newimg); 
		//Asigna a componenente JLabel
		imgLabel.setIcon(imageIcon);
		add(imgLabel, BorderLayout.CENTER);
	}
	
	public JPanel crearTitulo() {
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		panelTitulo.add(titulo);
		return panelTitulo;
	}
}
