package com.doglab.mvc.mudi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doglab.mvc.mudi.models.Pedido;
import com.doglab.mvc.mudi.models.StatusPedido;
import com.doglab.mvc.mudi.repositories.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public ModelAndView home(ModelAndView mv) {
		List<Pedido> pedidos = pedidoRepository.findAll();
		mv.setViewName("home");
		mv.addObject("pedidos", pedidos);
		return mv;
	}
	
	@GetMapping("/{pedidoStatus}")
	public ModelAndView homeStatus(@PathVariable("pedidoStatus") String status, ModelAndView mv) {
		List<Pedido> pedidos = 
				pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		mv.setViewName("home");
		mv.addObject("pedidos", pedidos);
		mv.addObject("status", status);
		return mv;
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String error()
	{
		return "redirect:/home";
	}

}
