package pe.unmsm.srdhdc.back.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import pe.unmsm.srdhdc.back.service.DocentesService;
import pe.unmsm.srdhdc.back.service.EnviarCorreoService;
import pe.unmsm.srdhdc.bd.FirebaseService;
import pe.unmsm.srdhdc.bd.repository.UsuariosBD;
import pe.unmsm.srdhdc.domain.dto.Docente;
import pe.unmsm.srdhdc.domain.dto.Usuario;
import pe.unmsm.srdhdc.domain.dto.request.CorreoDTORequest;
import pe.unmsm.srdhdc.domain.dto.request.DocenteDTORequest;

@Service
public class DocentesServiceImpl implements DocentesService {
	@Autowired
	private FirebaseService firebaseService;
	
	@Autowired
	private EnviarCorreoService enviarCorreo;
	
	@Override
	public void actualizarDocentes() {
		firebaseService.actualizarDocentes();
	}

	/**
	 * Metodo para obtener la lista de docentes filtrada por nombres y apellidos
	 */
	@Override
	public List<Docente> obtenerDocentes(String nombres) {
		List<Docente> listaDocentes = firebaseService.listaDocentes();
		List<Docente> listaDocentesFiltrado = new ArrayList<>();
		for (Docente docente : listaDocentes) {
			if (docente.getNombres().toLowerCase().contains(nombres.toLowerCase()) || docente.getApellidos().toLowerCase().contains(nombres.toLowerCase())) {
				Usuario usuario = firebaseService.obtenerUsuarioPorDni(docente.getDni());
				if (usuario != null) {
					docente.setCorreo(usuario.getCorreo());
				}
				listaDocentesFiltrado.add(docente);
			}
		}
		return listaDocentesFiltrado;
	}
	
	/**
	 * Metodo para obtener un docente por el numero de dni
	 */
	@Override
	public Docente obtenerDocentePorDni(String dni) {
		List<Docente> listaDocentes = firebaseService.listaDocentes();
		for (Docente docente : listaDocentes) {
			if (dni.equals(docente.getDni())) {
				// si existe el docente lo retornamos
				return docente;
			}
		}
		return null;
	}
	
	/**
	 * Metodo para registrar un docente
	 */
	@Override
	public void registrarDocente(DocenteDTORequest request) {
		// registramos al docente ingresado en la base de datos, sirve para edicion tambien
		Docente docente = new Docente();
		docente.setNombres(request.getNombres());
		docente.setApellidos(request.getApellidos());
		docente.setCategoria(request.getClase());
		docente.setClase(request.getCategoria());
		docente.setNum_horas(request.getNum_horas());
		docente.setDni(request.getDni());
		firebaseService.guardarDocente(docente);
		
		Usuario usuario = new Usuario();
		usuario.setDni(docente.getDni());
		usuario.setCorreo(request.getCorreo());
		if (!request.isEsEdicion()) {
			// despues creamos un usuario para el docente registrado
			firebaseService.guardarUsuario(usuario);
		} else {
			// si es edicion buscamos al usuario en el array y lo seteamos
			for (int i = 0; i < UsuariosBD.listaUsuariosLocal.size(); i++) {
				Usuario usuarioBD = UsuariosBD.listaUsuariosLocal.get(i);
				if (usuarioBD != null && request.getDni().equals(usuarioBD.getDni())) {
					firebaseService.editarUsuario(usuario, "" + i);
				}
			}
		}
	}
	
	@Override
	public void eliminarDocente(String dni) {
		// eliminamos al docente
		firebaseService.eliminarDocente(dni);
		
		// luego buscamos al usuario y lo eliminamos
		for(int i = 0; i < UsuariosBD.listaUsuariosLocal.size(); i++) {
			if (UsuariosBD.listaUsuariosLocal.get(i) != null && dni.equals(UsuariosBD.listaUsuariosLocal.get(i).getDni())) {
				firebaseService.eliminarUsuario("" + i);
			}
		}
	}
	
	/**
	 * Metodo para obtener la lista de docentes que aun no han registrado su disponibilidad horaria, filtrada por nombres y apellidos
	 */
	@Override
	public List<Docente> obtenerDocentesSinDisponibilidad(String nombres) {
		List<Docente> listaDocentes = firebaseService.listaDocentes();
		List<Docente> listaDocentesFiltrado = new ArrayList<>();
		for (Docente docente : listaDocentes) {
			if (docente.getNombres().toLowerCase().contains(nombres.toLowerCase()) || docente.getApellidos().toLowerCase().contains(nombres.toLowerCase())) {
				if (CollectionUtils.isEmpty(docente.getDisponibilidad())) {
					listaDocentesFiltrado.add(docente);
				}
			}
		}
		return listaDocentesFiltrado;
	}
	
	public void enviarNotificacionCorreoDocente(String dni) throws MessagingException {
		CorreoDTORequest request = new CorreoDTORequest();
		List<String> listaCorreos = new ArrayList<>();
		if (!CollectionUtils.isEmpty(UsuariosBD.listaUsuariosLocal)) {
			if (StringUtils.isEmpty(dni)) {
				// si esta vacio o null el dni, le enviamos notificacion a todos
				for (Usuario usuario : UsuariosBD.listaUsuariosLocal) {
					listaCorreos.add(usuario.getCorreo());
				}
			} else {
				// si dni no es null o vacio busamos el correo al cual enviar
				Usuario usuario = firebaseService.obtenerUsuarioPorDni(dni);
				listaCorreos.add(usuario.getCorreo());
			}
		}
		request.setListaTO(listaCorreos);
		request.setAsunto("Unidad: Departamento Academico de Ciencias de la Computacion");
		request.setMensaje("Estimado docente, usted aun no ha registrado su disponibilidad horaria en el sistema SRDHDC");
		enviarCorreo.enviarCorreo(request);
	}
}
