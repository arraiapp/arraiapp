package com.br.arraiapp.rest.service.implementation;

import com.br.arraiapp.domain.dto.customer.CustomerMapper;
import com.br.arraiapp.domain.entity.Customer;
import com.br.arraiapp.domain.dto.customer.CustomerRequestDTO;
import com.br.arraiapp.domain.exception.RequiredObjectIsNullException;
import com.br.arraiapp.domain.repository.CustomersRepository;
import com.br.arraiapp.rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomersRepository repository;
    private final CustomerMapper mapper = new CustomerMapper();

    public CustomerRequestDTO save (CustomerRequestDTO dto) {

        if (dto == null ) throw new RequiredObjectIsNullException();

        Customer customer = mapper.toEntity(dto);

        return mapper.toDtoRequest(repository.save(customer));
    }

    public CustomerRequestDTO login(CustomerRequestDTO customerRequestDTO){
        return mapper.toDtoRequest(repository
                .findByCpfAndPassword(customerRequestDTO.cpf(), customerRequestDTO.password())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "CPF ou senha inválidos")));
    }

}
