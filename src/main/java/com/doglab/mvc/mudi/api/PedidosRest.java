package com.doglab.mvc.mudi.api;

import java.security.Principal;
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
@RequestMapping("/api/pedidos")
public class PedidosRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	//Endpoints
	@GetMapping("/aguardando")
	public List<Pedido> getPedidosAguardando(Principal principal) {
		Sort sort = Sort.by("id").ascending();
		PageRequest pageRequest = PageRequest.of(0, 10, sort);
		System.out.println(principal.getName());
		return pedidoRepository.findByStatusAndUsers(principal.getName(), StatusPedido.AGUARDANDO, pageRequest);
	}
	
	//Endpoints
	@GetMapping("/todos/aguardando")
	public List<Pedido> getAllPedidosAguardando() {
		Sort sort = Sort.by("id").ascending();
		PageRequest pageRequest = PageRequest.of(0, 10, sort);
		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, pageRequest);
	}
	
	@GetMapping("/todos/aprovado")
	public List<Pedido> getAllPedidosAprovados() {
		Sort sort = Sort.by("id").ascending();
		PageRequest pageRequest = PageRequest.of(0, 10, sort);
		return pedidoRepository.findByStatus(StatusPedido.APROVADO, pageRequest);
	}
	
	@GetMapping("/todos/entregue")
	public List<Pedido> getAllPedidosEntregues() {
		Sort sort = Sort.by("id").ascending();
		PageRequest pageRequest = PageRequest.of(0, 10, sort);
		return pedidoRepository.findByStatus(StatusPedido.ENTREGUE, pageRequest);
	}
	
}
