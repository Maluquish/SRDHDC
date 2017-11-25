package pe.unmsm.srdhdc.domain.dto.request;

import java.util.List;

public class CorreoDTORequest {
	private List<String> listaTO;
	private List<String> listaCC;
	private List<String> listaBCC;
	private String asunto;
	private String mensaje;

	public List<String> getListaTO() {
		return listaTO;
	}

	public void setListaTO(List<String> listaTO) {
		this.listaTO = listaTO;
	}

	public List<String> getListaCC() {
		return listaCC;
	}

	public void setListaCC(List<String> listaCC) {
		this.listaCC = listaCC;
	}

	public List<String> getListaBCC() {
		return listaBCC;
	}

	public void setListaBCC(List<String> listaBCC) {
		this.listaBCC = listaBCC;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
