package com.doglab.mvc.mudi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ofertas")
public class OfertaController {

	@GetMapping("/nova")
	public ModelAndView novaOferta(ModelAndView mv) {
		mv.setViewName("ofertas/home");
		return mv;
	}
	
}
