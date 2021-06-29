package br.com.zup.academy.ednelson.transacao.nova;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zup.academy.ednelson.transacao.cartao.Cartao;
import br.com.zup.academy.ednelson.transacao.estabelecimento.Estabelecimento;

@Entity
public class Transacao {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uuid;
	private BigDecimal valor;
	@ManyToOne(cascade = CascadeType.ALL)
	private Estabelecimento estabelecimento;
	@ManyToOne(cascade = CascadeType.ALL)
	private Cartao cartao;
	private LocalDateTime efetivadaEm;
	
	@Deprecated
	public Transacao() {
		
	}
	
	public Transacao(String uuid, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
			LocalDateTime efetivadaEm) {
		this.uuid = uuid;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public Long getId() {
		return id;
	}

	public String getUuid() {
		return uuid;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
	
}
