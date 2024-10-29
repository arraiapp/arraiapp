package com.br.arraiapp.rest.service;

import com.br.arraiapp.domain.dto.customer.CustomerRequestDTO;

public interface CustomerService {
    CustomerRequestDTO save(CustomerRequestDTO customerRequestDTO);

    CustomerRequestDTO login(CustomerRequestDTO customerRequestDTO);
}
