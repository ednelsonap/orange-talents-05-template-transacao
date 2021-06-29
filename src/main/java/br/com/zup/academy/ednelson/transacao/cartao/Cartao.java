package br.com.zup.academy.ednelson.transacao.cartao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cartao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String uuid;
	private String email;
	
	@Deprecated
	public Cartao() {
		
	}
	
	public Cartao(String uuid, String email) {
		this.uuid = uuid;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getUuid() {
		return uuid;
	}

	public String getEmail() {
		return email;
	}
	
}
