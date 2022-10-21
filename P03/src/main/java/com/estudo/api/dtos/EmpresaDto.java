package com.estudo.api.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class EmpresaDto {

    private Long id;

    @NotEmpty
    @Length(min = 5, max = 200, message = "O nome social deve conter entre 5 a 200 caracteres")
    private String nomeSocial;

    @NotEmpty(message = "CNPJ não pode ser vazio!")
    @CNPJ(message = "CNPJ invalido")
    private String cnpj;

    @Override
    public String toString() {
        return "EmpresaDto{" +
                "\nid: " + id +
                "\nnome social: " + nomeSocial +
                "\ncnpj: " + cnpj +
                "\n}";
    }
}
