package com.doglab.mvc.mudi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doglab.mvc.mudi.models.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	/*
	@PersistenceContext
	private EntityManager em;
	
	public List<Pedido> findAll()
	{
		String JPQL = "SELECT p FROM Pedido AS p";
		return em.createNamedQuery(JPQL, Pedido.class)
				.getResultList();
	}
	*/
}
