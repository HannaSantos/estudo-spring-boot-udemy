package com.estudo.api.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@NoArgsConstructor
public class Empresa implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nomeSocial;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private Date dataCriacao;

    @Column(nullable = false)
    private Date dataAtualizacao;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

    @PreUpdate // quando estou fazendo uma atualização
    public void preUpdate(){
        dataAtualizacao = new Date();
    }

    @PrePersist // quando estou insirindo, ou criando pela primeira vez um elemento
    public void prePersist(){
        final Date atual = new Date();
        dataCriacao = atual;
        dataAtualizacao = atual;
    }

    @Override
    public String toString() {
        return "Empresa {" +
                "\nid: " + id +
                "\nnome social: " + nomeSocial +
                "\ncnpj: " + cnpj +
                "\ndata criacao: " + dataCriacao +
                "\ndata atualizacao: " + dataAtualizacao +
                "\n}";
    }
}
