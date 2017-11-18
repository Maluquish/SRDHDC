package pe.unmsm.srdhdc.bd;

import java.util.List;

import pe.unmsm.srdhdc.domain.dto.Docente;
import pe.unmsm.srdhdc.domain.dto.Usuario;

public interface FirebaseService {
	public void actualizarUsuarios();
	
	public Usuario obtenerUsuarioPorCorreo(String correo);
	
	public void actualizarDocentes();
	
	public void guardarDocente(Docente docente);
	
	public void guardarUsuario(Usuario usuario);
	
	public List<Docente> listaDocentes(String nombres);
}
