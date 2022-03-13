package com.doglab.mvc.mudi.dto;

import com.doglab.mvc.mudi.models.Pedido;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PedidoRequestDTO {

	private String productName;
	private String productUrl;
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
