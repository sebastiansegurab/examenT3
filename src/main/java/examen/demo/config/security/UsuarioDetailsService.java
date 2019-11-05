package examen.demo.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import examen.demo.model.entity.Usuario;
import examen.demo.model.repository.UsuarioRepository;


@Service
public class UsuarioDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Retornando el usuario 
		Optional<Usuario> buscado = this.usuarioRepository.findByUsername(username);
		
		if(buscado.isPresent()) {
			UsuarioDetails usuarioDetails = new UsuarioDetails(buscado.get());
			return usuarioDetails;
		}
		throw new UsernameNotFoundException("Invalid User");
	}
}
