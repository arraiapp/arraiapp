package com.br.arraiapp.rest.controller;

import com.br.arraiapp.domain.dto.CustomerTicket.CustomerTicketDTO;
import com.br.arraiapp.domain.dto.ticket.TicketQuantityDTO;
import com.br.arraiapp.rest.service.implementation.CustomerTicketServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/customer-ticket")
public class CustomerTicketController {

    @Autowired
    private CustomerTicketServiceImp service;

    @PostMapping("/get-payment-data")
    @ResponseStatus(HttpStatus.OK)
    public void getPaymentData(@RequestBody String json) throws JsonProcessingException {
        service.getPaymentData(json);
    }

    @PutMapping("/consume-ticket")
    @ResponseStatus(HttpStatus.OK)
    public void consumeTicket(@RequestBody CustomerTicketDTO dto) throws BadRequestException {
        service.consumeTicket(dto);
    }

    @PostMapping("/list-customer-tickets")
    @ResponseStatus(HttpStatus.OK)
    public List<TicketQuantityDTO> listCustomerTickets(@RequestBody String customerCpf){
        return service.listCustomerTickets(customerCpf);
    }




}
