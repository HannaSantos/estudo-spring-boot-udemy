package com.estudo.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ActiveProfiles("test")
public class EstudoSpringBootApplicationTests {

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCarregarContextoDeTeste(){
		assertEquals(100, qtdPorPagina);
	}

}
