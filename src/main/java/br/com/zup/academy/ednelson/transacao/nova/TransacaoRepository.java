package br.com.zup.academy.ednelson.transacao.nova;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.academy.ednelson.transacao.cartao.Cartao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

	Page<Transacao> findByCartao(Cartao cartao, Pageable paginacao);
 
}
