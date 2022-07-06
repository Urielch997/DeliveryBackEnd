package com.deliveryApp.Delivery.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Component
@Primary
public class ComponentObjectMapper  extends ObjectMapper {

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public ComponentObjectMapper() {
	        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); 
			setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    }
	
}
