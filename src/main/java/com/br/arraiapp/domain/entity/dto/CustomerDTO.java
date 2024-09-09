package com.br.arraiapp.domain.entity.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    private String name;

    private String email;

    private String password;

    private String cpf;
}
