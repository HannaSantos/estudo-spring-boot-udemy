package com.estudo.api.security.services;

import com.estudo.api.security.entities.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UsuarioService  {

    /**
     *  Buscar e retorna um usuaria dado um email
     *
     * @param email
     * @return <Usuario></Usuario>
     */
    Optional<Usuario> buscarPorEmail(String email);
}
