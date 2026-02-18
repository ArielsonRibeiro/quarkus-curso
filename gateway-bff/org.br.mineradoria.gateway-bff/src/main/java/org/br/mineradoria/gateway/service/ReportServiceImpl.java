package org.br.mineradoria.gateway.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.br.mineradoria.gateway.client.ReportClient;
import org.br.mineradoria.gateway.dto.OpportunityDTO;
import org.br.mineradoria.gateway.utils.CSVHelper;
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
