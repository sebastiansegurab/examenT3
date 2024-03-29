package examen.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import examen.demo.model.entity.Usuario;
import examen.demo.model.repository.UsuarioRepository;
import examen.demo.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Usuario> findAll() throws Exception {
		return usuarioRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Usuario> findById(Long id) throws Exception {
		return usuarioRepository.findById(id);
	}
	@Transactional
	@Override
	public Usuario save(Usuario entity) throws Exception {
		return usuarioRepository.save(entity);
	}
	@Transactional
	@Override
	public Usuario update(Usuario entity) throws Exception {
		return usuarioRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Long id) throws Exception {
		usuarioRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		usuarioRepository.deleteAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Usuario> findByUsername(String username) throws Exception {
		return usuarioRepository.findByUsername(username);
	}
	@Override
	public List<Usuario> listacamarero() throws Exception {
		return usuarioRepository.listacamarero();
	}

}
