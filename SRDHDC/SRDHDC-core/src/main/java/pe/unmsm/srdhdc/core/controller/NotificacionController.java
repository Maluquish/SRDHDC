package pe.unmsm.srdhdc.core.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.unmsm.srdhdc.back.service.DocentesService;
import pe.unmsm.srdhdc.domain.dto.Docente;
import pe.unmsm.srdhdc.domain.dto.request.DocenteDTORequest;

@Controller
@RequestMapping("/notificacion")
public class NotificacionController {
	
	@Autowired
	private DocentesService docentesService;

	@RequestMapping("/inicio")
	public String inicio() {
		return "notificar";
	}
	
	@RequestMapping(value = "/lista-docentes-sin-disponibilidad", method = RequestMethod.POST)
	@ResponseBody
	public Object listaDocentes(@RequestBody DocenteDTORequest requestBody) {
		List<Docente> listaDocentes = docentesService.obtenerDocentesSinDisponibilidad(requestBody.getNombres());
		return new ResponseEntity<>(listaDocentes, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/notificar/{dni}", method = RequestMethod.GET)
	@ResponseBody
	public Object notificarDocente(@PathVariable("dni") String dni) throws MessagingException {
		docentesService.enviarNotificacionCorreoDocente(dni);
		List<Docente> listaDocentes = docentesService.obtenerDocentesSinDisponibilidad("");
		return new ResponseEntity<>(listaDocentes, HttpStatus.OK);
	}
}
