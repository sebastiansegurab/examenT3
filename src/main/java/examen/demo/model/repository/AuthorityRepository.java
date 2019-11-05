package examen.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import examen.demo.model.entity.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
