package com.br.arraiapp.rest.controller;

import com.br.arraiapp.domain.dto.CustomerTicket.CustomerTicketDTO;
import com.br.arraiapp.rest.service.implementation.CheckoutServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;

@CrossOrigin
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutServiceImp service;

    @PostMapping(value = "/new-checkout")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createCheckout(@RequestBody CustomerTicketDTO checkoutData) {
        return service.createCheckout(checkoutData);
    }

}
