package examen.demo.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import examen.demo.model.entity.Plato;
import examen.demo.model.entity.Tipo;
import examen.demo.model.entity.Usuario;
import examen.demo.model.repository.AuthorityRepository;
import examen.demo.model.repository.PedidoRepository;
import examen.demo.model.repository.PlatoRepository;
import examen.demo.model.repository.TipoRepository;
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
	
	@Autowired
    private TipoRepository tipoRepository;
	
	@Autowired
    private PlatoRepository platoRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		this.pedidoRepository.deleteAll();
		this.platoRepository.deleteAll();
		this.tipoRepository.deleteAll();
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
	     
	     Usuario cliente = new Usuario();
	     cliente.setUsername("cliente");
	     cliente.setPassword(passwordEncoder.encode("cliente"));
	     cliente.setApellidos("cliente");
	     cliente.setNombres("cliente");
	     cliente.setEnable(true);

       
		invitado.addAuthority("ROLE_INVITADO");
        invitado.addAuthority("ACCESS_MEDICO_READ");
        admin.addAuthority("ROLE_GERENTE");
        admin.addAuthority("ACCESS_REST1");
        admin.addAuthority("ACCESS_REST2");
        camarero.addAuthority("ROLE_CAMARERO");
        camarero.addAuthority("ACCESS_REST1");
        cliente.addAuthority("ROLE_CLIENTE");
        cliente.addAuthority("ACCESS_REST1");
        
        Tipo tipo1 = new Tipo();
        tipo1.setNom_tipo("tipo1");
        
        Tipo tipo2 = new Tipo();
        tipo2.setNom_tipo("tipo2");
        
        Plato plato1 = new Plato();
        plato1.setNom_pla("plato1");
        plato1.setPre_pla(10);
        plato1.setTipo(tipo1);
        
        Plato plato2 = new Plato();
        plato2.setNom_pla("plato2");
        plato2.setPre_pla(20);
        plato2.setTipo(tipo1);
        
        Plato plato3 = new Plato();
        plato3.setNom_pla("plato3");
        plato3.setPre_pla(30);
        plato3.setTipo(tipo2);
        
        List<Usuario> usuarios = Arrays.asList(invitado ,admin, camarero, cliente );        
        this.usuarioRepository.saveAll(usuarios);	
        
        List<Tipo> tipos = Arrays.asList(tipo1, tipo2);        
        this.tipoRepository.saveAll(tipos);	
        
        List<Plato> platos = Arrays.asList(plato1 ,plato2, plato3);        
        this.platoRepository.saveAll(platos);	
	}
}
