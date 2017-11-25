package pe.unmsm.srdhdc.bd;

import java.util.List;

import pe.unmsm.srdhdc.domain.dto.Docente;
import pe.unmsm.srdhdc.domain.dto.Usuario;

public interface FirebaseService {
	public void actualizarUsuarios();
	
	public Usuario obtenerUsuarioPorCorreo(String correo);
	
	public void actualizarDocentes();
	
	public void guardarDocente(Docente docente);
	
	public void eliminarDocente(String dni);
	
	public void guardarUsuario(Usuario usuario);
	
	public void eliminarUsuario(String index);
	
	public List<Docente> listaDocentes();
	
	public void editarUsuario(Usuario usuario, String indice);
	
	public Usuario obtenerUsuarioPorDni(String dni);
}
