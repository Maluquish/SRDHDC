package pe.unmsm.srdhdc.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notificacion")
public class NotificacionController {

	@RequestMapping("/inicio")
	public String inicio() {
		return "notificar";
	}
}
