package com.estudo.api;

import com.estudo.api.service.ExemploCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class EstudoSpringBootApplication {

	@Autowired
	ExemploCacheService exemploCacheService;

	public static void main(String[] args) {
		SpringApplication.run(EstudoSpringBootApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			System.out.println("Execultado serviço pela primeira vez");
			System.out.println(this.exemploCacheService.exemploCache());

			System.out.println("Execcultado pela segunda vez");
			System.out.println(this.exemploCacheService.exemploCache());
		};
	}

}
