package com.deliveryApp.Delivery.user.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deliveryApp.Delivery.exception.NotFoundException;
import com.deliveryApp.Delivery.user.model.user;
import com.deliveryApp.Delivery.user.repository.UsuarioRepository;
import com.deliveryApp.Delivery.user.requestDto.UsuarioInfoRequestDto;
import com.deliveryApp.Delivery.user.service.UsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public String UpdateInfoUser(UsuarioInfoRequestDto userInfo) {
		user usuario = usuarioRepository.findById(userInfo.getIdUser()).orElseThrow(()->new NotFoundException("No se encontro el suaurio"));
		usuario.setTelefono(userInfo.getTelefono());
		usuarioRepository.save(usuario);
		return "Usuario actualizado!";
	}

}
