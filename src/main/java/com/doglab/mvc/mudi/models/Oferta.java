package com.doglab.mvc.mudi.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ofertas")
@Getter @Setter
public class Oferta {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal value;
	private String comentary;
	
	@Column(name = "delivery_date")
	private LocalDate deliveryDate;
	
	@ManyToOne @JsonManagedReference
	private Pedido pedido;
	
}
