package com.deliveryApp.Delivery.user.service;

import org.springframework.data.domain.Pageable;

import com.deliveryApp.Delivery.user.requestDto.UsuarioInfoRequestDto;

public interface UsuarioService {
	public String UpdateInfoUser(UsuarioInfoRequestDto userInfo);

}
