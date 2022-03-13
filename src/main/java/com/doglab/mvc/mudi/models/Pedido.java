package com.doglab.mvc.mudi.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Column(name = "delivery_date")
	private LocalDate deliveryDate;
	@Column(name = "product_url")
	private String productUrl;
	@Column(name = "image_url")
	private String imageUrl;
	private String description;
	
}
