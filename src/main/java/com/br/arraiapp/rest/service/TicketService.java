package com.br.arraiapp.rest.service;

import com.br.arraiapp.domain.dto.ticket.TicketDTO;

import java.util.List;

public interface TicketService {


    public TicketDTO save(TicketDTO ticketDTO);

    void delete(Long id);

    TicketDTO update(TicketDTO ticketDTO);

    public List<TicketDTO> findAll();

    public TicketDTO findById(Long id);

    //Public List<TicketDTO> findAll();
}
