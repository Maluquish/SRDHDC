package pe.unmsm.srdhdc.back.service;

import javax.mail.MessagingException;

import pe.unmsm.srdhdc.domain.dto.request.CorreoDTORequest;

public interface EnviarCorreoService {
	void enviarCorreo(CorreoDTORequest request) throws MessagingException;
}
