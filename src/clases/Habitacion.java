package clases;

public class Habitacion {
	private int id;
	private String numHab, descripcion;
	private char piso, estado;
	
	public Habitacion(String numHab, String descripcion, char piso, char estado) {
		this.numHab = numHab;
		this.descripcion = descripcion;
		this.piso = piso;
		this.estado = estado;
	}
	
	public Habitacion(String numHab, char piso, char estado) {
		this.numHab = numHab;
		this.piso = piso;
		this.estado = estado;
		this.descripcion = "";
	}
	
	public Habitacion(String numHab, char piso) {
		this.numHab = numHab;
		this.piso = piso;
		this.estado = 'F';
		this.descripcion = "";
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNumHab() {
		return numHab;
	}
	
	public void setNumHab(String numHab) {
		this.numHab = numHab;
	}
	
	public char getPiso() {
		return piso;
	}
	
	public void setPiso(char piso) {
		this.piso = piso;
	}
	
	public char getEstado() {
		return estado;
	}
	
	public void setEstado(char estado) {
		this.estado = estado;
	}
}
