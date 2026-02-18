package org.br.mineradoria.gateway.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.br.mineradoria.gateway.dto.OpportunityDTO;

public interface ReportService {

	List<OpportunityDTO>  generateOpportunitiesData();
	
	ByteArrayInputStream generateCSVInputStream();
}
