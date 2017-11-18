package pe.unmsm.srdhdc.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.unmsm.srdhdc.back.service.LoginService;
import pe.unmsm.srdhdc.domain.constantes.ConstantesApp;
import pe.unmsm.srdhdc.domain.dto.request.LoginDTORequest;
import pe.unmsm.srdhdc.domain.dto.response.LoginDTOResponse;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@RequestMapping("/inicio")
	public String inicio() {
		loginService.actualizarUsuarios();
		
		return "login.inicio";
	}

	@RequestMapping(value = "/validar", method = RequestMethod.POST)
	@ResponseBody
	public Object validar(@RequestBody LoginDTORequest requestBody, HttpSession session) throws Exception {
		
		LoginDTOResponse loginDTOResponse =  loginService.validarDatos(requestBody, session);
		
		session.setAttribute(ConstantesApp.USUARIO_SESSION, loginDTOResponse);
		
		return new ResponseEntity<>(loginDTOResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login/inicio";
	}
}