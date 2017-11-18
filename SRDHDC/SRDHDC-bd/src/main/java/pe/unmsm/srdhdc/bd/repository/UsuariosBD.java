package pe.unmsm.srdhdc.bd.repository;

import java.util.List;

import pe.unmsm.srdhdc.domain.dto.Usuario;

public class UsuariosBD {
	
	public static final String NOMBRE = "usuarios";
	private List<Usuario> listaUsuarios;
	public static List<Usuario> listaUsuariosLocal;
	
	public UsuariosBD() {
		super();
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
}
