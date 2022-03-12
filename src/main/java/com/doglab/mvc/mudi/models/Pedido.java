package com.doglab.mvc.mudi.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Pedido {

	private String name;
	private BigDecimal price;
	private LocalDate deliveryDate;
	private String productUrl;
	private String imageUrl;
	private String description;
	
}
