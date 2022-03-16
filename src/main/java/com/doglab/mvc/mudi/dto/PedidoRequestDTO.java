package com.doglab.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.doglab.mvc.mudi.models.Pedido;
import com.doglab.mvc.mudi.models.StatusPedido;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PedidoRequestDTO {

	@NotBlank @Size(min = 5, max = 255)
	private String productName;
	
	@NotBlank @URL
	private String productUrl;
	
	@NotBlank @URL
	private String imageUrl;
	private String productDescription;
	
	public Pedido toPedido()
	{
		Pedido pedido = new Pedido();
		pedido.setName(productName);
		pedido.setImageUrl(imageUrl);
		pedido.setProductUrl(productUrl);
		pedido.setDescription(productDescription);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}
	
}
