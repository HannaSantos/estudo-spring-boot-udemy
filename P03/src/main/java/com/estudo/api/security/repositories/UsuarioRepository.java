package com.estudo.api.security.repositories;


import com.estudo.api.security.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail (String email);
}
