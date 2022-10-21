package com.estudo.api.security.security;

import com.estudo.api.security.entities.Usuario;
import com.estudo.api.security.enums.PerfilEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class JwtUserFactory {

    private  JwtUserFactory(){

    }

    /**
     *  Converte e gera JwtUser com base nos dados de um funcionario
     *
     * @param usuario
     * @return JwtUser
     */
    public static JwtUser create(Usuario usuario){
        return new JwtUser(usuario.getId(), usuario.getEmail(), usuario.getSenha(),
                mapToGrantedAuthorities(usuario.getPerfil()));
    }

    /**
     *  Converte o perfil do usuario para o formato ultilizado pelo String security
     *
     * @param perfilEnum
     * @return <GrantedAuthority>
     */
    private static List<GrantedAuthority> mapToGrantedAuthorities(PerfilEnum perfilEnum){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
        return authorities;
    }
}
