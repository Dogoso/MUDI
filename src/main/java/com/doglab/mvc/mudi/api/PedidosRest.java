package com.doglab.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doglab.mvc.mudi.models.Pedido;
import com.doglab.mvc.mudi.models.StatusPedido;
import com.doglab.mvc.mudi.repositories.PedidoRepository;

@RestController
@RequestMapping("/api")
public class PedidosRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	//Endpoint para o VUEJS
	@GetMapping("/pedidos")
	public List<Pedido> getPedidos() {
		Sort sort = Sort.by("id").ascending();
		PageRequest pageRequest = PageRequest.of(0, 10, sort);
		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, pageRequest);
	}
	
}
