package pe.unmsm.srdhdc.domain.dto;

import java.util.List;
import java.util.Map;

public class Docente {
	private String dni;
	private String apellidos;
	private String categoria;
	private String clase;
	private Map<String, List<String>> disponibilidad;
	private String nombres;
	private int num_horas;
	
	public Docente() {
		super();
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Map<String, List<String>> getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Map<String, List<String>> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public int getNum_horas() {
		return num_horas;
	}

	public void setNum_horas(int num_horas) {
		this.num_horas = num_horas;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
}
