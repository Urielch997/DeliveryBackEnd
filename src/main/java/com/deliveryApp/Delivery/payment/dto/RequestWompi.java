package com.deliveryApp.Delivery.payment.dto;

public class RequestWompi {
	private TarjetaRequest tarjetaCreditoDebido;
	private Double monto;
	private String emailCliente;
	private  String nombreCliente;
	private  ConfigurationWompiDto configuracion;
	
	public TarjetaRequest getTarjetaCreditoDebido() {
		return tarjetaCreditoDebido;
	}
	public void setTarjetaCreditoDebido(TarjetaRequest tarjetaCreditoDebido) {
		this.tarjetaCreditoDebido = tarjetaCreditoDebido;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public ConfigurationWompiDto getConfiguracion() {
		return configuracion;
	}
	public void setConfiguracion(ConfigurationWompiDto configuracion) {
		this.configuracion = configuracion;
	}
	@Override
	public String toString() {
		return "RequestWompi [tarjetaCreditoDebido=" + tarjetaCreditoDebido + ", monto=" + monto + ", emailCliente="
				+ emailCliente + ", nombreCliente=" + nombreCliente + "]";
	}
	
	
	
	
}
