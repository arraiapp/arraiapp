package com.br.arraiapp.service;

import com.br.arraiapp.domain.entity.dto.TicketDTO;

import java.util.List;

public interface TicketService {


    public TicketDTO save(TicketDTO ticketDTO);

    void delete(Long id);

    void update(Long id, TicketDTO ticketDTO);

    public List<TicketDTO> findAll();


    //Public List<TicketDTO> findAll();
}
