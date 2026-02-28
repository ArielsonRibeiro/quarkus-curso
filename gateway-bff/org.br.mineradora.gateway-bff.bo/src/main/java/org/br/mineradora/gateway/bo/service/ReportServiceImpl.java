package org.br.mineradora.gateway.bo.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.br.mineradora.gateway.bo.client.ReportClient;
import org.br.mineradora.gateway.bo.dto.OpportunityDTO;
import org.br.mineradora.gateway.bo.utils.CSVHelper;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ReportServiceImpl implements ReportService {
	
	@Inject
	@RestClient
	private ReportClient reportClient;

	@Override
	public List<OpportunityDTO> generateOpportunitiesData() {
		return reportClient.generateOpportunitiesData();
	}

	@Override
	public ByteArrayInputStream generateCSVInputStream() {
		return CSVHelper.OpportunitiesToCSV(reportClient.generateOpportunitiesData());
	}

}
