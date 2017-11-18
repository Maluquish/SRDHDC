package pe.unmsm.srdhdc.core.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pe.unmsm.srdhdc.domain.constantes.ConstantesApp;
import pe.unmsm.srdhdc.domain.constantes.MensajeErrores;
import pe.unmsm.srdhdc.domain.exception.ExcepcionGeneral;

@RestControllerAdvice(basePackages = { ConstantesApp.PAQUETE_DOMINIO_CONTROL_ADVICE })
public class ExceptionController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(ex, MensajeErrores.ERROR_GENERAL, headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	@ExceptionHandler(ExcepcionGeneral.class)
	@ResponseBody
	public ResponseEntity<Object> excepcionGeneral(ExcepcionGeneral ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return handleExceptionInternal(ex, ex.getMessage(), headers, HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
