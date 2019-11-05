package examen.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import examen.demo.model.entity.Pedido;

@Repository
public interface PedidoRepository 
	extends JpaRepository<Pedido, Integer> {

}
