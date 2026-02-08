package org.br.mineradora.proposta.message;

import java.util.logging.Logger;

import org.br.mineradora.proposta.dto.ProposalDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaEvents {

	private final Logger LOGGER = Logger.getLogger(KafkaEvents.class.getName());
	
	@Channel("proposal-channel")
	Emitter<ProposalDTO> emitterProposalDTO;
	
	public void sendProposalDTO(ProposalDTO proposal) {
		emitterProposalDTO.send(proposal).toCompletableFuture().join();
		LOGGER.info("[sendProposalDTO] Enviado");
	}
}
