package com.deliveryApp.Delivery.user.model.pKCom;

import java.io.Serializable;


public class PKFav implements  Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long idItem;
	private Long idUser;
	
	public Long getIdItem() {
		return idItem;
	}
	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	
	
	
	
	
}
