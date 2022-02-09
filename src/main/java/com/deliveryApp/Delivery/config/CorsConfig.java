package com.deliveryApp.Delivery.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	
	@Value("${cors.origins}")
	private String allowedOrigins;
	
	@Value("${cors.headers}")
	private String allowedHeaders;
	
	@Value("${cors.methods}")
	private String allowedMethods;
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(allowedOrigins).allowedHeaders(allowedHeaders).allowedMethods(allowedMethods);
			}
	    };
	}
}
