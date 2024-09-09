package com.br.arraiapp.rest.controller;

import com.br.arraiapp.domain.entity.Customer;
import com.br.arraiapp.domain.entity.dto.CustomerDTO;
import com.br.arraiapp.domain.entity.repository.CustomersRepository;
import com.br.arraiapp.service.implementation.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImp customerServiceImp;

    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody CustomerDTO customerDTO) {
        return customerServiceImp.save(customerDTO);
    }

    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer login(@RequestBody CustomerDTO customerDTO){
        Customer customer  = customerServiceImp.login(customerDTO);
        return customer;
    }

}
