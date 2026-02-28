package org.br.mineradora.gateway.bo.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public class TokenOAuthDTO {

	@JsonbProperty("access_token")
	private String accessToken;
	
	@JsonbProperty("expires_in")
	private String expiresIn;
	
	@JsonbProperty("refresh_expires_in")
	private String refreshExpiresIn;
	
	@JsonbProperty("refresh_token")
	private String refreshToken;
	
	@JsonbProperty("token_type")
	private String tokenType;
	
	@JsonbProperty("scope")
	private String scope2;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getRefreshExpiresIn() {
		return refreshExpiresIn;
	}

	public void setRefreshExpiresIn(String refreshExpiresIn) {
		this.refreshExpiresIn = refreshExpiresIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getScope() {
		return scope2;
	}

	public void setScope(String scope) {
		this.scope2 = scope;
	}

	@Override
	public String toString() {
		return "TokenOAuth [accessToken=" + accessToken + ", expiresIn=" + expiresIn + ", refreshExpiresIn="
				+ refreshExpiresIn + ", refreshToken=" + refreshToken + ", tokenType=" + tokenType + ", scope=" + scope2
				+ "]";
	}
	
	
}
