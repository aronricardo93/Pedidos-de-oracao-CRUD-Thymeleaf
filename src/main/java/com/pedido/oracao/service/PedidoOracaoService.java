package com.pedido.oracao.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.pedido.oracao.entity.PedidoOracao;
import com.pedido.oracao.repository.PedidoOracaoRepository;

@Service
public class PedidoOracaoService {

	
	private PedidoOracaoRepository pedidoOracaoRepository;
	
	public PedidoOracaoService(PedidoOracaoRepository pedidoOracaoRepository) {
		this.pedidoOracaoRepository = pedidoOracaoRepository;
	}
	
	public List<PedidoOracao> listarPedidos(){
		return pedidoOracaoRepository.findAll();
	}
	
	public PedidoOracao buscarPedido(UUID id) {
		Optional<PedidoOracao> optional = pedidoOracaoRepository.findById(id);
		
		return optional.orElseThrow();
	}
	
	@Transactional
	public PedidoOracao salvarPedido(PedidoOracao pedidoOracao) {
		return pedidoOracaoRepository.save(pedidoOracao);
	}
	
	public PedidoOracao atualizarPedido(UUID id, PedidoOracao pedidoOracao) {
		PedidoOracao pedidoOriginal = this.buscarPedido(id);
		pedidoOracao.setId(pedidoOriginal.getId());
		return pedidoOracaoRepository.save(pedidoOracao);
	}

	@Transactional
	public void excluirPedido(UUID id) {
		PedidoOracao pedidoOracao = this.buscarPedido(id);
		pedidoOracaoRepository.delete(pedidoOracao);
	}
}
