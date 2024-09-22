package com.br.arraiapp.service;

import com.br.arraiapp.domain.entity.dto.StallholderDTO;

public interface StallholderService {

    StallholderDTO login(StallholderDTO customerDTO);

    StallholderDTO save(StallholderDTO customerDTO);
}
