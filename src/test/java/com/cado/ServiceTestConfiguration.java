package com.cado;

import com.cado.service.GenerateHTML;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class ServiceTestConfiguration {

	@Bean
	@Primary
	GenerateHTML generateHTML() {
		return Mockito.mock(GenerateHTML.class);
	}
}
