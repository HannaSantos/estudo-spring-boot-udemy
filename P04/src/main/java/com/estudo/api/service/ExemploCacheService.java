package com.estudo.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ExemploCacheService {
    private static final Logger log = LoggerFactory.getLogger(ExemploCacheService.class);

    @Cacheable("ExemploCache")
    public String exemploCache(){
        log.info("### Execultando o serviço... ");
        return "Teste de exemplo de cache";
    }
}
