package com.br.arraiapp.service.implementation;

import com.br.arraiapp.domain.entity.Customer;
import com.br.arraiapp.domain.entity.dto.CustomerDTO;
import com.br.arraiapp.domain.entity.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    private CustomersRepository repository;

    public Customer save(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setCpf(customerDTO.getCpf());
        customer.setPassword(customerDTO.getPassword());

        repository.save(customer);
        return customer;
    }

    public Customer login(CustomerDTO customerDTO){
        return repository
                .findByCpfAndPassword(customerDTO.getCpf(), customerDTO.getPassword())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "CPF ou senha inválidos"));
    }
}
