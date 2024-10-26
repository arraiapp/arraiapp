package com.br.arraiapp.rest.controller;

import com.br.arraiapp.rest.service.implementation.CheckoutServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutServiceImp service;

    @PostMapping(value = "/new-checkout")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createCheckout(){
        return service.createCheckout();
    }


}
