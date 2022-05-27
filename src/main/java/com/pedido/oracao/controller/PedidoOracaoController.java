package com.pedido.oracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pedido.oracao.entity.PedidoOracao;
import com.pedido.oracao.service.PedidoOracaoService;

@Controller
public class PedidoOracaoController {
	
	private PedidoOracaoService pedidoOracaoService;
	
	public PedidoOracaoController(PedidoOracaoService pedidoOracaoService) {
		this.pedidoOracaoService = pedidoOracaoService;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/pedidos")
	public ModelAndView pedidoOracao() {
		
		ModelAndView mv = new ModelAndView("pedido/pedido.html");
		
		mv.addObject("pedido", new PedidoOracao());
		
		return mv;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ModelAndView listarPedidos() {
		
		ModelAndView mv = new ModelAndView("lista/lista.html");
		
		mv.addObject("listaPedidos", pedidoOracaoService.listarPedidos());
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/pedidos")
	public ModelAndView salvarPedido(PedidoOracao pedidoOracao) {
		
		ModelAndView mv = new ModelAndView("redirect:/pedidos");
		
		pedidoOracaoService.salvarPedido(pedidoOracao);
		
		return mv;
	}

}
