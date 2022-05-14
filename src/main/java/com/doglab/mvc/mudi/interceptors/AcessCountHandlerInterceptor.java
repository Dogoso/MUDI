package com.doglab.mvc.mudi.interceptors;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.Getter;
import lombok.Setter;

@Component
public class AcessCountHandlerInterceptor implements HandlerInterceptor {

	public static Stack<Acess> acesses = new Stack<Acess>();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//System.out.println("Acesso");
		Acess acess = new Acess();
		acess.setPath(request.getRequestURI());
		acess.setStartPoint(LocalDateTime.now());
		acess.setDuration(Duration.ZERO);
		acesses.add(acess);
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//System.out.println("Fim do acesso");
		Acess ultimoAcesso = acesses.peek();
		ultimoAcesso.setDuration(Duration.between(ultimoAcesso.getStartPoint(), LocalDateTime.now()));
	}
	
	@Getter @Setter
	public static class Acess {
		private String path;
		private LocalDateTime startPoint;
		private Duration duration;
	}
	
}
