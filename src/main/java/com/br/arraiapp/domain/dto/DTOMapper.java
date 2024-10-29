package com.br.arraiapp.domain.dto;

import java.util.List;

public interface DTOMapper <D, E>{
    E toEntity(D dto);

    D toDto(E entity);

}
