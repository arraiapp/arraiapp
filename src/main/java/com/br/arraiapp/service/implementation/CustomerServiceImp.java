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

    public CustomerDTO save (CustomerDTO customerDTO) {
        Customer customer = DTOToEntity(customerDTO);
        repository.save(customer);
        return customerDTO;
    }

    public CustomerDTO login(CustomerDTO customerDTO){
        return EntityToDTO(repository
                .findByCpfAndPassword(customerDTO.cpf(), customerDTO.password())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "CPF ou senha inválidos")));
    }

    public Customer DTOToEntity (CustomerDTO customerDTO) {
        return new Customer(
                customerDTO.name(),
                customerDTO.email(),
                customerDTO.password(),
                customerDTO.cpf()
        );
    }

    public CustomerDTO EntityToDTO (Customer customer) {
        return new CustomerDTO(
                customer.getName(),
                customer.getEmail(),
                customer.getEmail(),
                customer.getCpf()
        );
    }
}
