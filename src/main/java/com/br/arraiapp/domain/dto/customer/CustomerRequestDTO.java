package com.br.arraiapp.domain.dto.customer;

public record CustomerRequestDTO(String name,
                                 String email,
                                 String password,
                                 String cpf,
                                 String phone) {

}
