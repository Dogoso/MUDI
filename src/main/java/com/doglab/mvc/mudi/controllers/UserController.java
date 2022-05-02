package com.doglab.mvc.mudi.controllers;

import java.security.Principal;
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
@RequestMapping("/user")
public class UserController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/pedido")
	public ModelAndView userHome(ModelAndView mv, Principal principal) {
		List<Pedido> pedidos = pedidoRepository.findAllByUser(principal.getName());
		mv.setViewName("user/home");
		mv.addObject("pedidos", pedidos);
		return mv;
	}
	
	@GetMapping("/pedido/{pedidoStatus}")
	public ModelAndView userStatus(@PathVariable("pedidoStatus") String status, ModelAndView mv, Principal principal) {
		List<Pedido> pedidos = 
				pedidoRepository.findByStatusAndUser(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
		mv.setViewName("user/home");
		mv.addObject("pedidos", pedidos);
		mv.addObject("status", status);
		return mv;
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String error()
	{
		return "redirect:/user/home";
	}
	
}
