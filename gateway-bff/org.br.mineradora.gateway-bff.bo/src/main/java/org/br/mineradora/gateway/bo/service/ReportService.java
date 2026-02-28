package org.br.mineradora.gateway.bo.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.br.mineradora.gateway.bo.dto.OpportunityDTO;

public interface ReportService {

	List<OpportunityDTO>  generateOpportunitiesData();
	
	ByteArrayInputStream generateCSVInputStream();
}
