package pe.unmsm.srdhdc.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unmsm.srdhdc.back.service.DocentesService;
import pe.unmsm.srdhdc.bd.FirebaseService;
import pe.unmsm.srdhdc.domain.dto.Docente;
import pe.unmsm.srdhdc.domain.dto.Usuario;
import pe.unmsm.srdhdc.domain.dto.request.DocenteDTORequest;

@Service
public class DocentesServiceImpl implements DocentesService {
	@Autowired
	private FirebaseService firebaseService;
	
	@Override
	public void actualizarDocentes() {
		firebaseService.actualizarDocentes();
	}

	@Override
	public List<Docente> obtenerDocentes(String nombres) {
		return firebaseService.listaDocentes(nombres);
	}
	
	@Override
	public Docente obtenerDocentePorDni(String dni) {
		List<Docente> listaDocentes = firebaseService.listaDocentes("");
		for (Docente docente : listaDocentes) {
			if (dni.equals(docente.getDni())) {
				return docente;
			}
		}
		return null;
	}
	
	@Override
	public void registrarDocente(DocenteDTORequest request) {
		Docente docente = new Docente();
		docente.setNombres(request.getNombres());
		docente.setApellidos(request.getApellidos());
		docente.setCategoria(request.getClase());
		docente.setClase(request.getCategoria());
		docente.setNum_horas(request.getNum_horas());
		docente.setDni("46983142");
		firebaseService.guardarDocente(docente);
		
		Usuario usuario = new Usuario();
		usuario.setDni(docente.getDni());
		usuario.setCorreo(request.getCorreo());
		firebaseService.guardarUsuario(usuario);
	}
}
