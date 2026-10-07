package com.example.user_management_system.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
