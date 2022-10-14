package com.estudo.api;

import com.estudo.api.models.Empresa;
import com.estudo.api.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EstudoSpringBootApplication {

	@Autowired
	private EmpresaRepository empresaRepository;

	public static void main(String[] args) {
		SpringApplication.run(EstudoSpringBootApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return args -> {
			Empresa empresa = new Empresa();
			empresa.setNomeSocial("Kazale II");
			empresa.setCnpj("598945944");

			this.empresaRepository.save(empresa);

			List<Empresa> empresas = empresaRepository.findAll();
			empresas.forEach(System.out::println);

			Empresa empresaDb = empresaRepository.findOne(1L);
			System.out.println("Empresa por ID: " + empresaDb);

			empresaDb.setNomeSocial("Nome maneiro");
			this.empresaRepository.save(empresaDb);

			Empresa empresaCnpj = empresaRepository.findByCnpj("598945944");
			System.out.println("Empresa Por CNPJ: " + empresaCnpj);

			this.empresaRepository.delete(1L);
			empresas = empresaRepository.findAll();
			System.out.println("Empresa " + empresas.size());
		};
	}

}
