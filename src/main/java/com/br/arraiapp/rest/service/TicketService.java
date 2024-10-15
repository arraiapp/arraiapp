package com.br.arraiapp.rest.service;

import com.br.arraiapp.domain.dto.TicketDTO;

import java.util.List;

public interface TicketService {


    public TicketDTO save(TicketDTO ticketDTO);

    void delete(Long id);

    void update(TicketDTO ticketDTO);

    public List<TicketDTO> findAll();


    //Public List<TicketDTO> findAll();
}
