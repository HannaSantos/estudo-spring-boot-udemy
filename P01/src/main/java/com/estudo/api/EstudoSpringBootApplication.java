package com.estudo.api;

import com.estudo.api.utils.SenhaUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EstudoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudoSpringBootApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			String senhaEncoded = SenhaUtils.gerarBCrypt("123456"); // gerando a senha e armazenando no senhaEncoded
			System.out.println("Senha Encoded: " + senhaEncoded);       // printando na tela

			senhaEncoded = SenhaUtils.gerarBCrypt("123456");   // gerando novamente um rest
			System.out.println("Senha encoded novamente: " + senhaEncoded);

			System.out.println("Senha invalida: " + SenhaUtils.senhaValida("123456", senhaEncoded)); // passando com a senha correta e a ultima senha gerada
		};
	}

}
