package com.br.arraiapp.rest.service;

import com.br.arraiapp.domain.dto.StallholderDTO;

public interface StallholderService {

    StallholderDTO login(StallholderDTO customerDTO);

    StallholderDTO save(StallholderDTO customerDTO);
}
