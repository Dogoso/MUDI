package com.doglab.mvc.mudi.controllers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.doglab.mvc.mudi.models.Pedido;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model)
	{
		Pedido pedido = new Pedido();
		pedido.setName("Tapete Gigante Térmico Tatame Infantil Educativo Para Bebê");
		pedido.setPrice(new BigDecimal("118.71"));
		pedido.setImageUrl("https://http2.mlstatic.com/D_NQ_NP_2X_845019-MLB44761737886_012021-F.webp");
		pedido.setProductUrl("https://produto.mercadolivre.com.br/MLB-1782880475-tapete-gigante-termico-tatame-infantil-educativo-para-beb-_JM#position=9&search_layout=grid&type=item&tracking_id=1d1d3380-f390-4d6d-9ad9-0f26d95c9f10");
		pedido.setDescription("Tapete Infantil Para Atividades Super Confortável DUPLA FACE TAMANHO 1,20cm x 1,80cm ***ACOMPANHA BOLSA NA COR VERDE");
		pedido.setDeliveryDate(LocalDate.now());
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
	
}
