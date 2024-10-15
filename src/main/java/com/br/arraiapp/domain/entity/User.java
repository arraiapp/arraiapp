package com.br.arraiapp.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Data
@MappedSuperclass
public abstract class User implements Serializable {

    static final long serialVersionUID = 1L;
    /*
    Dados do Diagram ade classes para referência.
    -Id: Long
    -Nome: String
    -Email: String
    -Senha: String
    -CPF: String

    Feito - Usuario() <<constructor>>
    Pendente - Implementar - +login(cpf: str, senha: str) :void
    Pendente - +alterar_cadastro(usuario: usuario) :void
    */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name ="name", length=100)
    private String name;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "cpf", length = 11)
    private String cpf;


}
