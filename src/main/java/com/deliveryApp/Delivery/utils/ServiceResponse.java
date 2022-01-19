package com.deliveryApp.Delivery.utils;


import lombok.Data;

@Data
public class ServiceResponse {

	public static final String OK_STATUS_CODE = "00";
	public static final String OK_STATUS_MESSAGE = "Operación realizada con éxito";
	public static final String ERROR_STATUS_CODE = "99";
	public static final String ERROR_STATUS_MESSAGE = "Error al realizar la Operación";

	public String code;
	public String message;
	public Object result;

	public ServiceResponse() {
		super();
	}

	public ServiceResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ServiceResponse(String code, String message, Object result) {
		super();
		this.code = code;
		this.message = message;
		this.result = result;
	}

	public ServiceResponse(Object result) {
		super();
		this.result = result;
	}

}

