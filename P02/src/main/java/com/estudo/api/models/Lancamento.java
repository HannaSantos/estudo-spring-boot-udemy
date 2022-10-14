package com.estudo.api.models;

import com.estudo.api.enums.TipoEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "lancamento")
@Getter
@Setter
@NoArgsConstructor
public class Lancamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP) // grava a data e hora do banco de dados
    @Column(nullable = false)
    private Date data;

    @Column(nullable = true)
    private String descricao;

    @Column(nullable = true)
    private String Localizacao;

    @Column(nullable = false)
    private Date dataCriacao;

    @Column(nullable = false)
    private Date dataAtualizacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoEnum tipo;

    @ManyToOne(fetch = FetchType.EAGER)
    private Funcionario funcionario;

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
        return "Lancamento{" +
                "\nid: " + id +
                "\ndata: " + data +
                "\ndescricao: " + descricao +
                "\nLocalizacao: " + Localizacao +
                "\ndataCriacao: " + dataCriacao +
                "\ndataAtualizacao: " + dataAtualizacao +
                "\ntipo: " + tipo +
                "\nfuncionario: " + funcionario +
                "\n}";
    }
}
