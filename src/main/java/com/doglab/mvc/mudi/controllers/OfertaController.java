package com.doglab.mvc.mudi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doglab.mvc.mudi.models.StatusPedido;
import com.doglab.mvc.mudi.repositories.PedidoRepository;

@Controller
@RequestMapping("/ofertas")
public class OfertaController {

	@Autowired
	private PedidoRepository pedidosRepository;
	
	@GetMapping("/nova")
	public ModelAndView novaOferta(ModelAndView mv) {
		Sort sort = Sort.by("id").ascending();
		PageRequest pageRequest = PageRequest.of(0, 10, sort);
		mv.addObject("pedidos", pedidosRepository.findByStatus(StatusPedido.AGUARDANDO, pageRequest));
		mv.setViewName("ofertas/home");
		return mv;
	}
	
}
