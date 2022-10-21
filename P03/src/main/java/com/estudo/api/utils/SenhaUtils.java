package com.estudo.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {

    /**
     *  Gera um hash ultilizando o BCrypt
     *
     * @param senha
     * @return String
     */
    public static String gerarBCrypt(String senha){
        if (senha == null){
            return senha;
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(senha);
    }

    /**
     *  Verifica se a senha é valida
     *
     * @param senha
     * @param senhaEncode
     * @return boolean
     */
    public static boolean senhaValida(String senha, String senhaEncode){
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(senha, senhaEncode);
    }

}
