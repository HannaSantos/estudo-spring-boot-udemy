package com.estudo.api.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtil {

    // definir tres chaves:
    static final String CLAIM_KEY_USERNAME = "sub"; // Aqui é o email do usuario
    static final String CLAIM_KEY_ROLE = "role"; // Aqui é definição do perfil do usuario
    static final String CLAIM_KEY_CREATED = "created"; // Definição de quando foi criado

    // importe dos valores da application.properties
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     *  Obtem o username (email) contido no token JWT.
     *
     * @param token
     * @return String
     */
    public String getUsernameFromToken(String token){
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e){
            username = null;
        }
        return username;
    }

    /**
     * Retorna a data de expiração de um token JWT
     *
     * @param token
     * @return Date
     */
    public Date getExpirationDateFromToken(String token){
        Date expiration;
        try {
            Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e){
            expiration = null;
        }
        return expiration;
    }

    /**
     *  Criar um novo token (refresh)
     *
     * @param token
     * @return String
     */
    public String refreshToken(String token){
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());  // ele adicona a data de expiração
            refreshedToken = gerarToken(claims);
        } catch (Exception e){
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     *  Verifica e retorna se o token JWT é valido
     *
     * @param token
     * @return boolean
     */
    public boolean tokenValido(String token){
        return !tokenExpirado(token);
    }

    /**
     *  Retorna um novo token JWT COM BASE NOS DADOS DO USUARIO
     *
     * @param userDetails
     * @return String
     */
    public String obterToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        userDetails.getAuthorities().forEach(authority -> claims.put(CLAIM_KEY_ROLE, authority.getAuthority()));
        claims.put(CLAIM_KEY_CREATED, new Date());

        return gerarToken(claims);
    }

    /**
     *  Realiza o parse do token JWT para extrairi as informações contida
     *  no corpo dele
     *
     * @param token
     * @return Claims
     */
    private Claims getClaimsFromToken(String token){
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody();
        }catch (Exception e){
            claims = null;
        }
        return claims;
    }

    /**
     * retorna a data de expiração com base na data atual
     *
     * @return Date
     */
    private Date gerarDataExpiracao(){
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     *  Verifica se um token JwT está expirado
     *
     * @param token
     * @return
     */
    private boolean tokenExpirado(String token){
        Date dataExpiracao = this.getExpirationDateFromToken(token);
        if (dataExpiracao == null){
            return false;
        }
        return dataExpiracao.before(new Date());
    }

    /**
     *  Gera um novo token JWT contendo dados claims fornecidos
     *
     * @param claims
     * @return String
     */
    private String gerarToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).setExpiration(gerarDataExpiracao())
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
}