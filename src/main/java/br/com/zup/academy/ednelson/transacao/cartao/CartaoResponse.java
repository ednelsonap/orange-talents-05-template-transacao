package br.com.zup.academy.ednelson.transacao.cartao;

import java.util.Optional;

public class CartaoResponse {

	private String id;
	private String email;
	
	@Deprecated
	public CartaoResponse() {
		
	}
	
	public CartaoResponse(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public CartaoResponse(Cartao cartao) {
		this.id = cartao.getUuid();
		this.email = cartao.getEmail();
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "CartaoResponse [id=" + id + ", email=" + email + "]";
	}

	public Cartao toModel(CartaoRepository cartaoRepository) {
		Optional<Cartao> possivelCartao = cartaoRepository.findByUuid(id);
		if(possivelCartao.isPresent()) {
			return possivelCartao.get();
		}
		return new Cartao(id, email);
	}
	
}
