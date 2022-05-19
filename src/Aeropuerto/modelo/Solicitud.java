package Aeropuerto.modelo;

public class Solicitud {
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
		return "Solicitud --> Codigo Avión = " + codigo + ", Fecha = " + fecha + ", Procedencia = " + procedencia
				+ ", Urgente = " + urgente + ", Hora = " + hora + ", Tipo = " + tipo;
	}
	
	
}
