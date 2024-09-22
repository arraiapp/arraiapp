package com.br.arraiapp.service;

import com.br.arraiapp.domain.entity.dto.StallholderDTO;

public interface StallholderService {
    StallholderDTO save(StallholderDTO customerDTO);

    StallholderDTO login(StallholderDTO customerDTO);
}
