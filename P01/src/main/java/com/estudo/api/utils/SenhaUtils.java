package com.estudo.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class SenhaUtils {

    /* *
     *  Gerar um hash ultilizando o BCrypt
     *
     * @param senha
     * @return String
     * */

//    primeiro criei um método statico para ter facilidade de acesso;
//    e em seguida vai receber no parametro a senha;
//    depois uma verificação para ver se a senha não vai vir nulo

//    depois gera o BCrypt pacote do Security
    public static String gerarBCrypt(String senha){
        if (senha == null) {
            return senha;
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(senha);
    }

    /* *
     *  Verificar se a senha é válida
     *
     * @param senha
     * @param senhaEncoded
     * @return boolean
     * */

    public static boolean senhaValida(String senha, String senhaEncoded){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(senha, senhaEncoded);
    }
}
