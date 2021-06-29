package br.com.zup.academy.ednelson.transacao.cartao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long>{

	Optional<Cartao> findByUuid(String id);

}
