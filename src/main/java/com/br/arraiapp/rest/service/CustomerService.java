package com.br.arraiapp.rest.service;

import com.br.arraiapp.domain.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO save(CustomerDTO customerDTO);

    CustomerDTO login(CustomerDTO customerDTO);
}
