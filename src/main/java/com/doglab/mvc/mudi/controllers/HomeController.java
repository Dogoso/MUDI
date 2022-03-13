package com.doglab.mvc.mudi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doglab.mvc.mudi.models.Pedido;
import com.doglab.mvc.mudi.repositories.PedidoRepository;

@Controller
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/home")
	public ModelAndView home(ModelAndView mv) {
		List<Pedido> pedidos = pedidoRepository.findAll();
		mv.setViewName("home");
		mv.addObject("pedidos", pedidos);
		return mv;
	}

}
