package org.br.mineradora.report.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Data
@Builder
@AllArgsConstructor
public class QuotationDTO {
	
	private Date date;
	
	private BigDecimal currencyPrice;

}
