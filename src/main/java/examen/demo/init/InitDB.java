package examen.demo.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import examen.demo.model.entity.Usuario;
import examen.demo.model.repository.AuthorityRepository;
import examen.demo.model.repository.PedidoRepository;
import examen.demo.model.repository.UsuarioRepository;

@Service
public class InitDB implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
    private PedidoRepository pedidoRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		this.pedidoRepository.deleteAll();
		this.usuarioRepository.deleteAll();
		this.authorityRepository.deleteAll();
		
		
		Usuario invitado = new Usuario();
		invitado.setUsername("invitado");
		invitado.setPassword(passwordEncoder.encode("invitado"));
		invitado.setApellidos("Flores");
		invitado.setNombres("invitado");
		invitado.setEnable(true);
		

		
		Usuario admin = new Usuario();
		admin.setUsername("gerente");
		admin.setPassword(passwordEncoder.encode("gerente"));
		admin.setApellidos("SSSS");
		admin.setNombres("Gerente");
		admin.setEnable(true);
		
		
		 Usuario camarero = new Usuario();
	     camarero.setUsername("camarero");
	     camarero.setPassword(passwordEncoder.encode("camarero"));
	     camarero.setApellidos("camarero");
	     camarero.setNombres("camarero");
	     camarero.setEnable(true);

       
		invitado.addAuthority("ROLE_INVITADO");
        invitado.addAuthority("ACCESS_MEDICO_READ");
        admin.addAuthority("ROLE_GERENTE");
        admin.addAuthority("ACCESS_REST1");
        admin.addAuthority("ACCESS_REST2");
        camarero.addAuthority("ROLE_CAMARERO");
        camarero.addAuthority("ACCESS_REST1");

        
        List<Usuario> usuarios = Arrays.asList(invitado ,admin, camarero );        
        this.usuarioRepository.saveAll(usuarios);	
	}
}
