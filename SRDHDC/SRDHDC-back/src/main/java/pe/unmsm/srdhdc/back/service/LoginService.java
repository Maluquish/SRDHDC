package pe.unmsm.srdhdc.back.service;

import javax.servlet.http.HttpSession;

import pe.unmsm.srdhdc.domain.dto.request.LoginDTORequest;
import pe.unmsm.srdhdc.domain.dto.response.LoginDTOResponse;

public interface LoginService {
	public void actualizarUsuarios();
	public LoginDTOResponse validarDatos(LoginDTORequest request, HttpSession session) throws Exception;
}
