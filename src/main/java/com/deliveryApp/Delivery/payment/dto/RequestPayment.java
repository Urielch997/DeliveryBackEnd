package com.deliveryApp.Delivery.payment.dto;



public class RequestPayment {
	private String numeroTarjeta;
    private  String cvv;
    private String mesVencimiento;
    private String anioVencimiento;
    private Double monto;
    private Long idUsuario;
    
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
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	@Override
	public String toString() {
		return "RequestPayment [numeroTarjeta=" + numeroTarjeta + ", cvv=" + cvv + ", mesVencimiento=" + mesVencimiento
				+ ", anioVencimiento=" + anioVencimiento + ", monto=" + monto + "]";
	}
	
	
    
    
}
