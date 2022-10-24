package com.estudo.api.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class JwtAuthenticationDto {

    @NotEmpty(message = "Email não pode ser vazio")
    @Email(message = "Email invalido")
    private String email;

    @NotEmpty(message = "Senha não pode ser vazia")
    private String senha;
}
