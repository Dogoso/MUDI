package com.doglab.mvc.mudi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doglab.mvc.mudi.models.Pedido;
import com.doglab.mvc.mudi.models.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido status);

	@Query("SELECT p FROM Pedido p JOIN FETCH p.user u WHERE u.username = :username")
	List<Pedido> findAllByUser(String username);

}
