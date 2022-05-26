package com.pedido.oracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pedido.oracao.entity.PedidoOracao;

@Controller
public class PedidoOracaoController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/pedidos")
	public ModelAndView pedidoOracao() {
		
		ModelAndView mv = new ModelAndView("pedido/pedido.html");
		
		//mv.addObject("pedidoDeOracao", new PedidoOracao());
		
		return mv;
		
	}

}
