package com.br.arraiapp.rest.service;

import com.br.arraiapp.domain.dto.stallholder.StallholderRequestDTO;

public interface StallholderService {

    StallholderRequestDTO login(StallholderRequestDTO customerDTO);

    StallholderRequestDTO save(StallholderRequestDTO customerDTO);
}
