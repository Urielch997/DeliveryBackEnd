package com.deliveryApp.Delivery.payment.dto;

public class RequestTokenWompi {

	private String gran_type;

	private String client_id;
	

	private String client_secret;

	private String audience;

	public String getGran_type() {
		return gran_type;
	}

	public void setGran_type(String gran_type) {
		this.gran_type = gran_type;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public String getClient_secret() {
		return client_secret;
	}

	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}

	public String getAudience() {
		return audience;
	}

	public void setAudience(String audience) {
		this.audience = audience;
	}

	@Override
	public String toString() {
		return "RequestTokenWompi [gran_type=" + gran_type + ", client_id=" + client_id + ", client_secret="
				+ client_secret + ", audience=" + audience + "]";
	}

	

	
	
	
	
	
}
