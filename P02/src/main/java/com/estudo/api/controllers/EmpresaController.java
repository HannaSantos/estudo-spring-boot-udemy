package com.estudo.api.controllers;

import com.estudo.api.dtos.EmpresaDto;
import com.estudo.api.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @PostMapping
    public ResponseEntity<Response<EmpresaDto>> cadastrar(@Valid
                                                              @RequestBody EmpresaDto empresaDto,
                                                          BindingResult result){
        Response<EmpresaDto> response = new Response<EmpresaDto>();

        if (result.hasErrors()){ // valida se possui erros
            result.getAllErrors().forEach(erro -> response.getErrors().add(erro.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        empresaDto.setId(1L);
        response.setData(empresaDto);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
