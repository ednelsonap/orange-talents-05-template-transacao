package br.com.zup.academy.ednelson.transacao.nova;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

import br.com.zup.academy.ednelson.transacao.cartao.CartaoRepository;
import br.com.zup.academy.ednelson.transacao.estabelecimento.EstabelecimentoRepository;

@Component
public class TransacaoConsumer {

	@Autowired
	private TransacaoRepository transacaoRepository;
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	@Autowired
	private CartaoRepository cartaoRepository;
	
	@KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.transactions}")
	@Transactional
	public void consome(EventoTransacaoResponse evento) {
		Transacao transacao = evento.toModel(estabelecimentoRepository, cartaoRepository);
		transacaoRepository.save(transacao);
	}
	
	@Bean
    JsonMessageConverter jsonMessageConverter(){
        return new JsonMessageConverter();
    }
}
