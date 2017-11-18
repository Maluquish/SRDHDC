package pe.unmsm.srdhdc.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.unmsm.srdhdc.back.service.DocentesService;
import pe.unmsm.srdhdc.domain.dto.Docente;
import pe.unmsm.srdhdc.domain.dto.request.DocenteDTORequest;

@Controller
@RequestMapping("/gestion-docentes")
public class GestionDocentesController {
	
	@Autowired
	private DocentesService docentesService;
	
	@RequestMapping("/registro")
	public String registro() {
		docentesService.actualizarDocentes();
		
		return "gestion.docentes.registro";
	}
	
	@RequestMapping(value = "/lista", method = RequestMethod.POST)
	@ResponseBody
	public Object listaDocentes(@RequestBody DocenteDTORequest requestBody) {
		List<Docente> listaDocentes = docentesService.obtenerDocentes(requestBody.getNombres());
		return new ResponseEntity<>(listaDocentes, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/registrar-docente", method = RequestMethod.POST)
	@ResponseBody
	public Object registrarDocente(@RequestBody DocenteDTORequest requestBody) {
		docentesService.registrarDocente(requestBody);
		return new ResponseEntity<>(requestBody, HttpStatus.OK);
	}
	
	@RequestMapping("/historial")
	public String historial() {
		return "gestion.docentes.historial";
	}
}
