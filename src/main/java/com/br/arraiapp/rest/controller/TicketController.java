package com.br.arraiapp.rest.controller;

import com.br.arraiapp.domain.dto.ticket.TicketDTO;
import com.br.arraiapp.rest.service.implementation.TicketServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketServiceImp service;

    @PostMapping(value = "/register",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public TicketDTO save(@RequestBody TicketDTO ticketDTO) {
        return service.save(ticketDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public TicketDTO update(@RequestBody TicketDTO ticketDTO) {
        return service.update(ticketDTO);
    }

    @GetMapping(value = "/getAll",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<TicketDTO> findAll (){
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA");return service.findAll();
    }

    @GetMapping("{id}")
    public TicketDTO findById (@PathVariable Long id) { return service.findById(id);}


}
