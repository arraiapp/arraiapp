package com.br.arraiapp.rest.controller;

import com.br.arraiapp.domain.entity.dto.TicketDTO;
import com.br.arraiapp.service.implementation.TicketServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:5000/")
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

    /* Precisamos de um metodo pra retornar tudo, vou deixar por último
    @GetMapping(value = "/getAll",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<TicketDTO> getAll() {
        return service.getAll();
    }
    */

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
        service.update(id, ticketDTO);
    }

}
