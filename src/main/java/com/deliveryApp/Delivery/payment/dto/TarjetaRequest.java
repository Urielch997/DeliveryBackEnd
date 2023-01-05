package com.deliveryApp.Delivery.payment.dto;

public class TarjetaRequest {
	private String numeroTarjeta;
    private  String cvv;
    private String mesVencimiento;
    private String anioVencimiento;
    
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getMesVencimiento() {
		return mesVencimiento;
	}
	public void setMesVencimiento(String mesVencimiento) {
		this.mesVencimiento = mesVencimiento;
	}
	public String getAnioVencimiento() {
		return anioVencimiento;
	}
	public void setAnioVencimiento(String anioVencimiento) {
		this.anioVencimiento = anioVencimiento;
	}
	@Override
	public String toString() {
		return "TarjetaRequest [numeroTarjeta=" + numeroTarjeta + ", cvv=" + cvv + ", mesVencimiento=" + mesVencimiento
				+ ", anioVencimiento=" + anioVencimiento + "]";
	}
	
	
    
    
}
