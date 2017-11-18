package pe.unmsm.srdhdc.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mantenimiento")
public class MantenimientoController {
	
	@RequestMapping("/cuentas-usuario")
	public String cuentasUsuario() {
		return "mantenimiento.cuentas.usuario";
	}
	
	@RequestMapping("/periodo-academico")
	public String periodoAcademico() {
		return "mantenimiento.periodo.academico";
	}
}
