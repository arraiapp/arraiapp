package com.br.arraiapp.service.implementation;

import com.br.arraiapp.domain.entity.Customer;
import com.br.arraiapp.domain.entity.dto.CustomerDTO;

public interface CustomerService {
    Customer save(CustomerDTO customerDTO);

    Customer login(CustomerDTO customerDTO);
}
