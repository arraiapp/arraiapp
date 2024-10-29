package com.br.arraiapp.domain.dto.stallholder;

public record StallholderDTO(Long id,
                             String name,
                             String email,
                             String password,
                             String cpf,
                             String phone,
                             Boolean Admin) {
}
