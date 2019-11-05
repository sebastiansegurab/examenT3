package examen.demo.service;

import java.util.List;
import java.util.Optional;

import examen.demo.model.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long> {
	Optional<Usuario> findByUsername(String username) throws Exception;
	
	
	List<Usuario> listacamarero() throws Exception; 
	
	
}
