package com.doglab.mvc.mudi.api;

import java.util.Stack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doglab.mvc.mudi.interceptors.AcessCountHandlerInterceptor;
import com.doglab.mvc.mudi.interceptors.AcessCountHandlerInterceptor.Acess;

@RestController
@RequestMapping("/api")
public class AcessCountRest {

	@GetMapping("/acess_count")
	public Stack<Acess> getAllAcesses() {
		return AcessCountHandlerInterceptor.acesses;
	}
	
}
