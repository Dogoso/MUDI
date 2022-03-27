package com.doglab.mvc.mudi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doglab.mvc.mudi.dto.PedidoRequestDTO;
import com.doglab.mvc.mudi.models.Pedido;
import com.doglab.mvc.mudi.models.User;
import com.doglab.mvc.mudi.repositories.PedidoRepository;
import com.doglab.mvc.mudi.repositories.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("formulario")
	public ModelAndView form(ModelAndView mv, PedidoRequestDTO pedidoDTO) {
		mv.setViewName("pedido/formulario");
		return mv;
	}

	@PostMapping("novo")
	public String submit(@Valid PedidoRequestDTO pedidoDTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
		{
			return "pedido/formulario";
		}
		
		String username = SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getName();
		
		User user = userRepository.findByUsername(username);
		
		Pedido pedido = pedidoDTO.toPedido();
		pedido.setUser(user);
		pedidoRepository.save(pedido);
		return "redirect:/home";
	}
	
}
