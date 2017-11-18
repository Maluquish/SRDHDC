package pe.unmsm.srdhdc.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/disponibildad")
public class DisponibilidadController {
	
	@RequestMapping("/inicio")
	public String inicio() {
		return "disponibilidad";
	}
}
