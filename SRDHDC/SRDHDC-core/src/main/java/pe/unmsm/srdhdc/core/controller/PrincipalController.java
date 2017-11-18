package pe.unmsm.srdhdc.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.unmsm.srdhdc.domain.constantes.ConstantesApp;
import pe.unmsm.srdhdc.domain.dto.response.LoginDTOResponse;

@Controller
@RequestMapping("/principal")
public class PrincipalController {
	
	@RequestMapping("/inicio")
	public String inicio(Model model, HttpSession session) {
		LoginDTOResponse loginDTOResponse =  (LoginDTOResponse) session.getAttribute(ConstantesApp.USUARIO_SESSION);
		model.addAttribute(ConstantesApp.USUARIO_SESSION, loginDTOResponse);
		return "perfil.principal";
	}
}
