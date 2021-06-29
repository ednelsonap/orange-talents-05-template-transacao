package br.com.zup.academy.ednelson.transacao.nova;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zup.academy.ednelson.transacao.cartao.CartaoRepository;
import br.com.zup.academy.ednelson.transacao.cartao.CartaoResponse;
import br.com.zup.academy.ednelson.transacao.estabelecimento.EstabelecimentoRepository;
import br.com.zup.academy.ednelson.transacao.estabelecimento.EstabelecimentoResponse;

public class EventoTransacaoResponse {
	
	private String id;
	private BigDecimal valor;
	private EstabelecimentoResponse estabelecimento;
	private CartaoResponse cartao;
	private LocalDateTime efetivadaEm;
	
	@Deprecated
	public EventoTransacaoResponse() {
		
	}
	
	public EventoTransacaoResponse(String id, BigDecimal valor, EstabelecimentoResponse estabelecimento, CartaoResponse cartao,
			LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoResponse getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoResponse getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}

	@Override
	public String toString() {
		return "EventoTransacao [id=" + id + ", valor=" + valor + ", estabelecimento=" + estabelecimento + ", cartao="
				+ cartao + ", efetivadaEm=" + efetivadaEm + "]";
	}

	public Transacao toModel(EstabelecimentoRepository estabelecimentoRepository, CartaoRepository cartaoRepository) {
		return new Transacao(id, valor, estabelecimento.toModel(estabelecimentoRepository), cartao.toModel(cartaoRepository), efetivadaEm);
	}
	
}
