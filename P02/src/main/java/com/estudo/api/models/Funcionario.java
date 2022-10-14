package com.estudo.api.models;

import com.estudo.api.enums.PerfilEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
@NoArgsConstructor
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = true)
    private BigDecimal valorHora;

    @Column(nullable = true)
    private Float qtdHorasTrabalhoDia;

    @Column(nullable = true)
    private Float qtdHorasAlmoco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PerfilEnum perfil;

    @Column(nullable = false)
    private Date dataCriacao;

    @Column(nullable = false)
    private Date dataAtualizacao;

    @ManyToOne(fetch = FetchType.EAGER) // com o EAGER vou trazer a informação da empresa comigo
    private Empresa empresa;

    @OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Lancamento> lancamentos;

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
        return "Funcionario{" +
                "\nid: " + id +
                "\nnome: " + nome +
                "\nemail: " + email +
                "\nsenha: " + senha +
                "\ncpf: " + cpf +
                "\nvalor hora: " + valorHora +
                "\nqtdHorasTrabalhoDia: " + qtdHorasTrabalhoDia +
                "\nqtdHorasAlmoco: " + qtdHorasAlmoco +
                "\nperfil: " + perfil +
                "\ndataCriacao: " + dataCriacao +
                "\ndataAtualizacao: " + dataAtualizacao +
                "\nempresa: " + empresa +
                "\n}";
    }
}
