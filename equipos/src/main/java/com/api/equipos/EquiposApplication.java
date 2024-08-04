package com.api.equipos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class EquiposApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquiposApplication.class, args);
	}

	@Bean		//Para persnalizar la documentacion en swagger, .../doc/swagger-ui.html
	public OpenAPI customOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("API Equipos")
						.description("API para la gestion de equipos.")
						.contact(new Contact()));
	}
}
