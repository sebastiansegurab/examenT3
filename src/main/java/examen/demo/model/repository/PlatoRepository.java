package examen.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import examen.demo.model.entity.Plato;

@Repository
public interface PlatoRepository 
	extends JpaRepository<Plato, Integer> {

}
