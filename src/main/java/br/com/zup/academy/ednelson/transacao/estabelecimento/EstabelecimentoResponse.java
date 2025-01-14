package br.com.zup.academy.ednelson.transacao.estabelecimento;

import java.util.Optional;

public class EstabelecimentoResponse {

	private String nome;
	private String cidade;
	private String endereco;

	@Deprecated
	public EstabelecimentoResponse() {
	
	}
	
	public EstabelecimentoResponse(String nome, String cidade, String endereco) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public EstabelecimentoResponse(Estabelecimento estabelecimento) {
		this.nome = estabelecimento.getNome();
		this.cidade = estabelecimento.getCidade();
		this.endereco = estabelecimento.getEndereco();
	}

	public String getNome() {
		return nome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	@Override
	public String toString() {
		return "EstabelecimentoResponse [nome=" + nome + ", cidade=" + cidade + ", endereco=" + endereco + "]";
	}

	public Estabelecimento toModel(EstabelecimentoRepository estabelecimentoRepository) {
		Optional<Estabelecimento> possivelEstabelecimento = estabelecimentoRepository.findByNome(nome);
		if(possivelEstabelecimento.isPresent()) {
			return possivelEstabelecimento.get();
		}
		return new Estabelecimento(nome, cidade, endereco);
	}
	
}
