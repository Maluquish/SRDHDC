package pe.unmsm.srdhdc.bd.repository;

import java.util.List;

import pe.unmsm.srdhdc.domain.dto.Docente;

public class DocentesBD {
	public static final String NOMBRE = "docentes";
	private List<Docente> listaDocentes;
	public static List<Docente> listaDocentesLocal;

	public List<Docente> getListaDocentes() {
		return listaDocentes;
	}

	public void setListaDocentes(List<Docente> listaDocentes) {
		this.listaDocentes = listaDocentes;
	}
}
