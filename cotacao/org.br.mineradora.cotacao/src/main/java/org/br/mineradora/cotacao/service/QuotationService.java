package org.br.mineradora.cotacao.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.br.mineradora.cotacao.client.CurrencyPriceClient;
import org.br.mineradora.cotacao.dto.CurrencyPriceDTO;
import org.br.mineradora.cotacao.dto.QuotationDTO;
import org.br.mineradora.cotacao.entity.CotacaoEnitity;
import org.br.mineradora.cotacao.message.KafkaEvents;
import org.br.mineradora.cotacao.repository.QuotationRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;

@ApplicationScoped
public class QuotationService {

	@RestClient
	@Inject
	private CurrencyPriceClient proxy;

	@Inject
	private QuotationRepository repository;

	@Inject
	private KafkaEvents kafka;

	private static final String PAIR_USD_BRL = "USD-BRL";
	
	private static final BigDecimal DIFERENCA_SALVAR_EM_BANCO = new BigDecimal("0.05");
	
	private final Logger LOGGER = Logger.getLogger(QuotationService.class.getName());

	public void updatePrice() {
		
		try {
			CurrencyPriceDTO currentPriceInfo = proxy.getPriceByPair(PAIR_USD_BRL);
			if (updatePrice(currentPriceInfo)) {
				QuotationDTO quotation = QuotationDTO.builder()
						.currencyPrice(new BigDecimal(currentPriceInfo.getUsdbrl().getBid())).date(new Date()).build();
				kafka.sendQuotationEvent(quotation);
	
			}
		} catch(WebApplicationException e) {
			LOGGER.info("Erro: "+ e.getResponse().readEntity(String.class) );
			;
		}

		
	}

	private boolean updatePrice(CurrencyPriceDTO currentPriceInfo) {
		
		BigDecimal currencyValue = new BigDecimal(currentPriceInfo.getUsdbrl().getBid());
		boolean update = false;
		
		List<CotacaoEnitity> quotations = repository.findAll().list();
		if(quotations.isEmpty()) {
			saveQuotation(currentPriceInfo);
			update = true;
		} else {
			
			BigDecimal lastValue = quotations.get(quotations.size() - 1).getCurrencyPrice();
			BigDecimal dif = lastValue.subtract(currencyValue);
			
			// só atualiza se a cotação for maior
			//if(currencyValue.compareTo(lastValue) > 0) {
			
			if(dif.abs().compareTo(DIFERENCA_SALVAR_EM_BANCO) >= 0) {
				saveQuotation(currentPriceInfo);
				update = true;
			}
		}

		return update;
	}

	private void saveQuotation(CurrencyPriceDTO currentPriceInfo) {
		CotacaoEnitity quotation = new CotacaoEnitity();
		quotation.setCurrencyPrice(new BigDecimal(currentPriceInfo.getUsdbrl().getBid()));
		quotation.setDate(new Date());
		quotation.setPctChange(currentPriceInfo.getUsdbrl().getPctChange());
		quotation.setPair(PAIR_USD_BRL);
		repository.persist(quotation);
	}
}
