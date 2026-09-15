package org.br.mineradora.gateway.bo.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.br.mineradora.gateway.bo.utils.CSVHelper;
import org.br.mineradora.rsproxy.ReportClient;
import org.br.mineradora.rsproxy.report.to.OpportunityDTO;
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
