package com.estudo.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VersionamentoApiController {

    // ********** VERSIONAMENTO DA API VERSÃO 1 E 2 **********
    // com duas forma, pelo Header e pela URL

    /**
     * Versionamento da API pelo URL, definindo a v1
     *
     * @param nome
     * @return ResponseEntity<String>
     */
    @GetMapping(value = "/v1/ola/{nome}")
    public ResponseEntity<String> olaNomeUrlV1(@PathVariable("nome") String nome){
        return ResponseEntity.status(HttpStatus.OK).body(String.format("API URL v1: olá %s", nome));
    }

    /**
     * Versionamento da API pelo URL, definindo a v1
     *
     * @param nome
     * @return ResponseEntity<String>
     */
    @GetMapping(value = "/v2/ola/{nome}")
    public ResponseEntity<String> olaNomeUrlV2(@PathVariable("nome") String nome){
        return ResponseEntity.status(HttpStatus.OK).body(String.format("API URL v2: olá %s", nome));
    }

    /**
     * Versionamento da API pelo Header, definindo a v1
     *
     * @param nome
     * @return ResponseEntity<String>
     */
    @GetMapping(value = "/ola/{nome}", headers = "X-API-Version=v1")
    public ResponseEntity<String> olanomeHeardV1(@PathVariable("nome") String nome){
        return ResponseEntity.status(HttpStatus.OK).body(String.format("API Heard v1: olá %s", nome));
    }

    /**
     *  Versionamento da API pelo Header, definindo a v2
     *
     * @param nome
     * @return ResponseEntity<String>
     */
    @GetMapping(value = "/ola/{nome}", headers = "X-API-Version=v2")
    public ResponseEntity<String> olanomeHeardV2(@PathVariable("nome") String nome){
        return ResponseEntity.status(HttpStatus.OK).body(String.format("API Heard v2: olá %s", nome));
    }

}
