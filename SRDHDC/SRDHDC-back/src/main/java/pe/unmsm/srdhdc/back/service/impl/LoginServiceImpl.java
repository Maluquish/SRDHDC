package pe.unmsm.srdhdc.back.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.unmsm.srdhdc.back.service.DocentesService;
import pe.unmsm.srdhdc.back.service.LoginService;
import pe.unmsm.srdhdc.bd.FirebaseService;
import pe.unmsm.srdhdc.domain.dto.Docente;
import pe.unmsm.srdhdc.domain.dto.Usuario;
import pe.unmsm.srdhdc.domain.dto.request.LoginDTORequest;
import pe.unmsm.srdhdc.domain.dto.response.LoginDTOResponse;
import pe.unmsm.srdhdc.domain.exception.ExcepcionGeneral;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private FirebaseService firebaseService;
	
	@Autowired
	private DocentesService docentesService;

	@Override
	public void actualizarUsuarios() {
		firebaseService.actualizarUsuarios();
		
		//Adicionalmente actualizamos la lista de docentes
		firebaseService.actualizarDocentes();
	}

	@Override
	public LoginDTOResponse validarDatos(LoginDTORequest loginDTORequest, HttpSession session) throws Exception {
		LoginDTOResponse loginDTOResponse = new LoginDTOResponse();

		Usuario usuario = firebaseService.obtenerUsuarioPorCorreo(loginDTORequest.getUsuario());

		if (usuario != null) {
			if ("alxff.24@gmail.com".equals(usuario.getCorreo())) {
				Docente docente = docentesService.obtenerDocentePorDni(usuario.getDni());
				
				loginDTOResponse.setNombres(docente.getNombres());
				loginDTOResponse.setApellidos(docente.getApellidos());
			} else {
				throw new ExcepcionGeneral("Usted no es un usuario administrador");
			}
		} else {
			throw new ExcepcionGeneral("No se encontro al usuario en la base de datos");
		}

		return loginDTOResponse;
	}
}
