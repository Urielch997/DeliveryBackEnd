package com.deliveryApp.Delivery.payment.dto;

public class ConfigurationWompiDto {
	private boolean notificarTransaccionCliente;

	public boolean getNotificarTransaccionCliente() {
		return notificarTransaccionCliente;
	}

	public void setNotificarTransaccionCliente(boolean notificarTransaccionCliente) {
		this.notificarTransaccionCliente = notificarTransaccionCliente;
	}

	@Override
	public String toString() {
		return "ConfigurationWompiDto [notificarTransaccionCliente=" + notificarTransaccionCliente + "]";
	}
	
	
}
