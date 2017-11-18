package pe.unmsm.srdhdc.bd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import pe.unmsm.srdhdc.bd.repository.DocentesBD;
import pe.unmsm.srdhdc.bd.repository.UsuariosBD;
import pe.unmsm.srdhdc.domain.dto.Docente;
import pe.unmsm.srdhdc.domain.dto.Usuario;

@Service
public class FirebaseServiceImpl implements FirebaseService {

	@Autowired
	@Qualifier("main")
	private DatabaseReference mainDatabaseReference;

	@Value("${firebase.path}")
	private String chatPath;

	@Override
	public void actualizarUsuarios() {
		DatabaseReference usuariosDR = mainDatabaseReference.child(UsuariosBD.NOMBRE);
		usuariosDR.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				UsuariosBD usuariosBD = dataSnapshot.getValue(UsuariosBD.class);
				UsuariosBD.listaUsuariosLocal = usuariosBD.getListaUsuarios();
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				System.out.println("The read failed: " + databaseError.getCode());
			}
		});
	}
	
	@Override
	public void actualizarDocentes() {
		DatabaseReference usuariosDR = mainDatabaseReference.child(DocentesBD.NOMBRE);
		usuariosDR.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				List<Docente> listaDocentes = new ArrayList<>();
				
				Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();
				
				for (DataSnapshot dataSnap : dataSnapshots) {
					Docente docente = dataSnap.getValue(Docente.class);
					docente.setDni(dataSnap.getKey().replace("d_", ""));
					listaDocentes.add(docente);
				}
				
				DocentesBD.listaDocentesLocal = listaDocentes;
			}

			@Override
			public void onCancelled(DatabaseError databaseError) {
				System.out.println("The read failed: " + databaseError.getCode());
			}
		});
	}
	
	@Override
	public List<Docente> listaDocentes(String nombres) {
		List<Docente> listaDocentes = DocentesBD.listaDocentesLocal;
		return listaDocentes;
	}
	
	@Override
	public void guardarDocente(Docente docente) {
		DatabaseReference docentesDR = mainDatabaseReference.child(DocentesBD.NOMBRE);
		docentesDR.child("d_" + docente.getDni()).setValue(docente);
	}

	@Override
	public Usuario obtenerUsuarioPorCorreo(String correo) {
		List<Usuario> listaUsuarios = UsuariosBD.listaUsuariosLocal;
		
		if (!CollectionUtils.isEmpty(listaUsuarios) && !StringUtils.isEmpty(correo)){
			for (Usuario usuario : listaUsuarios) {
				if (correo.equals(usuario.getCorreo())) {
					return usuario;
				}
			}
		}

		return null;
	}

	@Override
	public void guardarUsuario(Usuario usuario) {
		DatabaseReference usuariosDR = mainDatabaseReference.child(UsuariosBD.NOMBRE + "/listaUsuarios");
		usuariosDR.child("" + UsuariosBD.listaUsuariosLocal.size()).setValue(usuario);
	}
}
