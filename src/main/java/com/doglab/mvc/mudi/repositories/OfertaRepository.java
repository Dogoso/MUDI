package com.doglab.mvc.mudi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doglab.mvc.mudi.models.Oferta;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long>{
	
	@Query("SELECT o "
			+ "FROM Oferta o "
			+ "JOIN FETCH o.pedido p "
			+ "JOIN FETCH p.user u "
			+ "WHERE u.username = :username")
	List<Oferta> findOfertaByUsername(String username);
	
}
