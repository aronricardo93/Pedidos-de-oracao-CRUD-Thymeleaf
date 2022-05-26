package com.pedido.oracao.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedido.oracao.entity.PedidoOracao;

@Repository
public interface PedidoOracaoRepository extends JpaRepository<PedidoOracao, UUID>{

}
