package Aeropuerto.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solicitud implements Comparable<Solicitud> {
	public String codigo;
	public String fecha;
	public String procedencia;
	public boolean urgente;
	public String hora;
	
	public TipoOperacion tipo;

	public Solicitud(String codigo, String fecha, String procedencia, boolean urgente, String hora,
			TipoOperacion tipo) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.procedencia = procedencia;
		this.urgente = urgente;
		this.hora = hora;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Codigo Avionn = " + codigo + ", Fecha = " + fecha + ", Procedencia = " + procedencia
				+ ", Urgente = " + urgente + ", Hora = " + hora + ", Tipo = " + tipo;
	}
	
	public String toFile() {
		return codigo + "\t" + tipo + "\t" + hora;
	}

	@Override
	public int compareTo(Solicitud o) {
		if(this.urgente && !o.urgente)
			return -1;
		if(!this.urgente && o.urgente)
				return 1;
		if(this.urgente && o.urgente) {
			try {
				Date date1 = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(this.fecha + " " + this.hora);
				Date date2 = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(o.fecha + " " + o.hora);
				
				if(date1.before(date2)) {
					return -1;
				}else {
					return 1;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
}
