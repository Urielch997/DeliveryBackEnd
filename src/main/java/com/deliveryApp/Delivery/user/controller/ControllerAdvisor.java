package com.deliveryApp.Delivery.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.deliveryApp.Delivery.exception.CustomException;
import com.deliveryApp.Delivery.exception.NotFoundException;
import com.deliveryApp.Delivery.utils.ServiceResponse;

@ControllerAdvice
public class ControllerAdvisor{


	    @ExceptionHandler(NotFoundException.class)
	    public ResponseEntity<ServiceResponse> handleNotFoundException(
	    		NotFoundException ex) {
	        return new ResponseEntity<>(new ServiceResponse(ServiceResponse.ERROR_STATUS_CODE,ex.getMessage()), HttpStatus.NOT_FOUND);
	    }
	    
	    
	    @ExceptionHandler(CustomException.class)
	    public ResponseEntity<ServiceResponse> handlerCustomException(
	    		CustomException ex) {
	    	 return new ResponseEntity<>(new ServiceResponse(ServiceResponse.ERROR_STATUS_CODE,ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
