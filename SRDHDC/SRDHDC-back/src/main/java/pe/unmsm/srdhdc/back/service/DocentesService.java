package pe.unmsm.srdhdc.back.service;

import java.util.List;

import pe.unmsm.srdhdc.domain.dto.Docente;
import pe.unmsm.srdhdc.domain.dto.request.DocenteDTORequest;

public interface DocentesService {
	public void actualizarDocentes();
	
	public List<Docente> obtenerDocentes(String nombres);
	
	public Docente obtenerDocentePorDni(String dni);
	
	public void registrarDocente(DocenteDTORequest request);
}
