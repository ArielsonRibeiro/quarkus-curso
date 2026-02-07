package org.br.mineradora.cotacao.message;

import java.util.logging.Logger;

import org.br.mineradora.cotacao.dto.QuotationDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaEvents {

	private final Logger LOGGER = Logger.getLogger(KafkaEvents.class.getName());
	
	
	@Channel("quotation-channel")
	private Emitter<QuotationDTO> quotationRequestEmitter;
	
	public void sendQuotationEvent(QuotationDTO quotation) {
		quotationRequestEmitter.send(quotation).toCompletableFuture().join();
		LOGGER.info("[sendQuotationEvent] Enviado");
	}
}
