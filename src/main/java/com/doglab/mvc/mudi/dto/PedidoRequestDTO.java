package com.doglab.mvc.mudi.dto;

import com.doglab.mvc.mudi.models.Pedido;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PedidoRequestDTO {

	@NotBlank
	private String productName;
	
	@NotBlank
	private String productUrl;
	
	@NotBlank
	private String imageUrl;
	private String productDescription;
	
	public Pedido toPedido()
	{
		Pedido pedido = new Pedido();
		pedido.setName(productName);
		pedido.setImageUrl(imageUrl);
		pedido.setProductUrl(productUrl);
		pedido.setDescription(productDescription);
		return pedido;
	}
	
}
