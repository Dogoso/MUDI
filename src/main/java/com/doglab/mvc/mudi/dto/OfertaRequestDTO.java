package com.doglab.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.doglab.mvc.mudi.models.Oferta;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OfertaRequestDTO {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Long pedidoId;
	@NotNull @Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
	private String deliveryDate;
	@NotNull @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	private String value;
	private String comentary;
	
	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setComentary(comentary);
		oferta.setValue(new BigDecimal(value));
		oferta.setDeliveryDate(LocalDate.parse(deliveryDate, formatter));
		
		return oferta;
	}
	
}
