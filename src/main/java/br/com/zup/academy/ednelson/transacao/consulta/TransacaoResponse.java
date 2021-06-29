package br.com.zup.academy.ednelson.transacao.consulta;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import org.springframework.data.domain.Page;

import br.com.zup.academy.ednelson.transacao.cartao.CartaoResponse;
import br.com.zup.academy.ednelson.transacao.estabelecimento.EstabelecimentoResponse;
import br.com.zup.academy.ednelson.transacao.nova.Transacao;

public class TransacaoResponse {

	private String uuid;
	private BigDecimal valor;
	private EstabelecimentoResponse estabelecimento;
	private CartaoResponse cartao;
	private String efetivadaEm;
	
	@Deprecated
	public TransacaoResponse() {
		
	}
	
	public TransacaoResponse(Transacao transacao) {
		this.uuid = transacao.getUuid();
		this.valor = transacao.getValor();
		this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
		this.cartao = new CartaoResponse(transacao.getCartao());
		this.efetivadaEm = transacao.getEfetivadaEm().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

	public String getUuid() {
		return uuid;
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

	public String getEfetivadaEm() {
		return efetivadaEm;
	}

	public static Page<TransacaoResponse> converter(Page<Transacao> transacoes) {
		return transacoes.map(TransacaoResponse::new) ;
	}
	
}
