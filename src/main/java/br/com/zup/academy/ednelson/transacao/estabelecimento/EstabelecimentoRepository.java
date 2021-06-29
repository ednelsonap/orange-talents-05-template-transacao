package br.com.zup.academy.ednelson.transacao.estabelecimento;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long>{

	Optional<Estabelecimento> findByNome(String nome);

}
