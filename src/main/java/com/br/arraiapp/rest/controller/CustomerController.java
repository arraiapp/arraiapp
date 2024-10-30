package com.br.arraiapp.rest.controller;

import com.br.arraiapp.domain.dto.customer.CustomerRequestDTO;
import com.br.arraiapp.rest.service.implementation.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


//Cross origin temporário, depois temos que acertar isso lá nas permissões, com a URL de verdade.
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
    public CustomerRequestDTO save(@RequestBody CustomerRequestDTO customerRequestDTO) {
        return customerServiceImp.save(customerRequestDTO);
    }

    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CustomerRequestDTO login(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerServiceImp.login(customerRequestDTO);
    }

}
