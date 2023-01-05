package com.deliveryApp.Delivery.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tokenpayment",schema = "payment")
public class tokenPayment {
	@Id
	@Column(name = "idtoken")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idToken;
	
	@Column(name = "access_token")
	private String accessToken;
	
	private  int expires;

	public Long getIdToken() {
		return idToken;
	}

	public void setIdToken(Long idToken) {
		this.idToken = idToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public int getExpires() {
		return expires;
	}

	public void setExpires(int expires) {
		this.expires = expires;
	}
	
}
