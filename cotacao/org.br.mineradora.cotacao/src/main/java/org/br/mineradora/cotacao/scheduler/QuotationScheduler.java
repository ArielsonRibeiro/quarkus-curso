package org.br.mineradora.cotacao.scheduler;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.br.mineradora.cotacao.service.QuotationService;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@ApplicationScoped
public class QuotationScheduler {

	@Inject
	private QuotationService service;
	
	private final Logger LOGGER = Logger.getLogger(QuotationScheduler.class.getName());
	
	@Transactional(value = TxType.REQUIRED)
	@Scheduled(every = "35s", identity = "update-price-job")
	public void scheduleQuotation() {
		LOGGER.log(Level.INFO, "[scheduleQuotation]");
		service.updatePrice();
		LOGGER.log(Level.INFO, "[scheduleQuotation] fim");
	}
}
