package examen.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import examen.demo.model.entity.Tipo;

@Repository
public interface TipoRepository 
	extends JpaRepository<Tipo, Integer> {

}
