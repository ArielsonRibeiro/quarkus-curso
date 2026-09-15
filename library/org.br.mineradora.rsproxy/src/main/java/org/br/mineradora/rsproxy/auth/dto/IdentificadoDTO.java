package org.br.mineradora.rsproxy.auth.dto;

import java.util.Date;

public class IdentificadoDTO {

	private long id;
	
	private String mensagem;
	
	private Date data;

	public long getId() {
		return id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public Date getData() {
		return data;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "IdentificadoDTO [id=" + id + ", mensagem=" + mensagem + ", data=" + data + "]";
	}
	
	
}
