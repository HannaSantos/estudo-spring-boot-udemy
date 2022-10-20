package com.estudo.api.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpresaDto {

    private Long id;
    private String nomeSocial;
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
