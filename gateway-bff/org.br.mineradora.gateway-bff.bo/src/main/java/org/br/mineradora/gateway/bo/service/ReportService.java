package org.br.mineradora.gateway.bo.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.br.mineradora.gateway.client.report.to.OpportunityDTO;


public interface ReportService {

	List<OpportunityDTO>  generateOpportunitiesData();
	
	ByteArrayInputStream generateCSVInputStream();
}
