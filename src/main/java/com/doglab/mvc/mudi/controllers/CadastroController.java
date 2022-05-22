package com.doglab.mvc.mudi.controllers;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.doglab.mvc.mudi.dto.UserRequestDTO;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
	
	@Autowired
	private DataSource dataSource;
	
	@GetMapping
	public ModelAndView cadastroDeUsuario(ModelAndView mv) {
		mv.setViewName("cadastro/cadastro");
		return mv;
	}
	
	@PostMapping
	public ModelAndView cadastrar(
			@Valid UserRequestDTO userDto, 
			Errors errors, 
			ModelAndView mv
	) {
		if(errors.hasErrors()) {
			mv.setViewName("cadastro/cadastro");
			return mv;
		}
		
		UserDetailsManager manager = 
				new JdbcUserDetailsManager(dataSource);

		if(manager.userExists(userDto.getUsername()) 
				|| !userDto.getPassword().equals(userDto.getRepeatedPassword())) {
			mv.setViewName("cadastro/cadastro");
			return mv;
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		UserDetails user =
				 User.withUsername(userDto.getUsername())
					.password(encoder.encode(userDto.getPassword()))
					.roles("USER")
					.build();
		
		manager.createUser(user);
		
		SecurityContext context = SecurityContextHolder.createEmptyContext(); 
		Authentication authentication =
		    new UsernamePasswordAuthenticationToken(user, userDto.getPassword()); 
		context.setAuthentication(authentication);

		SecurityContextHolder.setContext(context);
		
		mv.setViewName("redirect:home");
		return mv;
	}
	
}
