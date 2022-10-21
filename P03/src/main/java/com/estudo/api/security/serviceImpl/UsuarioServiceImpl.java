package com.estudo.api.security.serviceImpl;

import com.estudo.api.security.entities.Usuario;
import com.estudo.api.security.repositories.UsuarioRepository;
import com.estudo.api.security.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> buscarPorEmail(String email){
        return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
    }
}
