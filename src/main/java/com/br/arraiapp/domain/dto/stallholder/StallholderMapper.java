package com.br.arraiapp.domain.dto.stallholder;

import com.br.arraiapp.domain.dto.DTOMapper;
import com.br.arraiapp.domain.dto.customer.CustomerRequestDTO;
import com.br.arraiapp.domain.entity.Customer;
import com.br.arraiapp.domain.entity.Stallholder;

public class StallholderMapper implements DTOMapper<StallholderDTO ,Stallholder> {
    //Stallholder DTO
    @Override
    public Stallholder toEntity(StallholderDTO dto) {
        return new Stallholder(
                dto.id(),
                dto.name(),
                dto.email(),
                dto.password(),
                dto.cpf(),
                dto.phone(),
                dto.Admin()
        );
    }

    @Override
    public StallholderDTO toDto(Stallholder entity) {
        return new StallholderDTO(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getCpf(),
                entity.getPhone(),
                entity.getAdmin()
        );
    }

    //Stallholder Request Dto
    public Stallholder toEntity(StallholderRequestDTO dto) {
        return new Stallholder(
                dto.name(),
                dto.email(),
                dto.password(),
                dto.cpf(),
                dto.phone(),
                dto.Admin()
        );
    }

    public StallholderRequestDTO toDtoRequest(Stallholder entity) {
        return new StallholderRequestDTO(
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getCpf(),
                entity.getPhone(),
                entity.getAdmin()
        );
    }
}
