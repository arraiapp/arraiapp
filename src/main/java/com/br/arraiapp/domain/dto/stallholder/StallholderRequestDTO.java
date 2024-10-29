package com.br.arraiapp.domain.dto.stallholder;

public record StallholderRequestDTO(String name,
                                    String email,
                                    String password,
                                    String cpf,
                                    String phone,
                                    Boolean Admin) {
}
