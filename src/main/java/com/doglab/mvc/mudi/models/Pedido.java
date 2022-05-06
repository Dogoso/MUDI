package com.doglab.mvc.mudi.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "pedidos")
@Getter @Setter @NoArgsConstructor
public class Pedido {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private BigDecimal price;
	private String description;

	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	@Column(name = "delivery_date")
	private LocalDate deliveryDate;
	
	@Column(name = "product_url")
	private String productUrl;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private User user;
	
	@JsonBackReference
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Oferta> ofertas;
	
}
