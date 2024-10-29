package com.br.arraiapp.domain.dto.customer;

public record CustomerDTO(Long id,
                          String name,
                          String email,
                          String password,
                          String cpf,
                          String phone) {

}
