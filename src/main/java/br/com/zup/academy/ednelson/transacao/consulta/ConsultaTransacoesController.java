package br.com.zup.academy.ednelson.transacao.consulta;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.ednelson.transacao.cartao.Cartao;
import br.com.zup.academy.ednelson.transacao.cartao.CartaoRepository;
import br.com.zup.academy.ednelson.transacao.nova.Transacao;
import br.com.zup.academy.ednelson.transacao.nova.TransacaoRepository;

@RestController
public class ConsultaTransacoesController {

	@Autowired
	private CartaoRepository cartaoRepository;
	@Autowired
	private TransacaoRepository transacaoRepository;

	@GetMapping("/api/transacoes/cartao/{id}")
	public ResponseEntity<Page<TransacaoResponse>> consultarTransacoes(@PathVariable(required = true, value = "id") String uuidCartao,
			@PageableDefault(sort = "efetivadaEm", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
		Optional<Cartao> possivelCartao = cartaoRepository.findByUuid(uuidCartao);
		
		if(possivelCartao.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		Cartao cartao = possivelCartao.get();
		Page<Transacao> transacoes = transacaoRepository.findByCartao(cartao, paginacao);
		
		return ResponseEntity.ok(TransacaoResponse.converter(transacoes));
	}
}
