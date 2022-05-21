package com.doglab.mvc.mudi.api;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doglab.mvc.mudi.dto.OfertaRequestDTO;
import com.doglab.mvc.mudi.models.Oferta;
import com.doglab.mvc.mudi.models.Pedido;
import com.doglab.mvc.mudi.repositories.OfertaRepository;
import com.doglab.mvc.mudi.repositories.PedidoRepository;

@RestController
@RequestMapping("api/ofertas")
public class OfertasRest {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private OfertaRepository ofertaRepository;
	
	@GetMapping("/recebidas")
	public List<Oferta> ofertasRecebidas(Principal principal) {
		return ofertaRepository.findOfertaByUsername(principal.getName());
	}
	
	@PostMapping
	public Oferta novaOferta(@Valid @RequestBody OfertaRequestDTO ofertaDTO) {
		
		Optional<Pedido> findedPedido = pedidoRepository.findById(ofertaDTO.getPedidoId());
		if(!findedPedido.isPresent()) {
			return null;
		}
		Pedido pedido = findedPedido.get();
		Oferta oferta = ofertaDTO.toOferta();
		
		oferta.setPedido(pedido);
		pedido.getOfertas().add(oferta);
		
		pedidoRepository.save(pedido);
		
		return oferta;
	}
	
}
