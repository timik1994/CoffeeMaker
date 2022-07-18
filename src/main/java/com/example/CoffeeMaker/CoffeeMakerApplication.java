package com.example.CoffeeMaker;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition
public class CoffeeMakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeMakerApplication.class, args);
	}


	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI()
				.addServersItem(new Server().url("/"))
				.info(new Info().title("Сервис управления кофеваркой")
						.description("Описание того что делает сервис"));
	}

}