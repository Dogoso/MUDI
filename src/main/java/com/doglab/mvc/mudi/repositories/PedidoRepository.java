package com.doglab.mvc.mudi.repositories;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doglab.mvc.mudi.models.Pedido;
import com.doglab.mvc.mudi.models.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Cacheable("todosProdutosEntregues")
	List<Pedido> findByStatus(StatusPedido status, Pageable pageable);
	
	@Cacheable("produtosEntregues")
	@Query("SELECT p FROM Pedido p JOIN FETCH p.user u WHERE u.username != :user AND p.status = :status")
	List<Pedido> findByStatusAndUsers(String user, StatusPedido status, Pageable pageable);
	
	List<Pedido> findByStatus(StatusPedido status);

	@Query("SELECT p FROM Pedido p JOIN FETCH p.user u WHERE u.username = :username")
	List<Pedido> findAllByUser(String username);
	
	@Query("SELECT p FROM Pedido p "
			+ "JOIN FETCH p.user u "
			+ "WHERE u.username = :username "
			+ "AND  p.status = :status")
	List<Pedido> findByStatusAndUser(StatusPedido status, String username);

}
