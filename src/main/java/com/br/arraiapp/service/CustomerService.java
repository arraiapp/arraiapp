package com.br.arraiapp.service;

import com.br.arraiapp.domain.entity.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO save(CustomerDTO customerDTO);

    CustomerDTO login(CustomerDTO customerDTO);
}
