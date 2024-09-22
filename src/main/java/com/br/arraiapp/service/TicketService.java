package com.br.arraiapp.service;

import com.br.arraiapp.domain.entity.dto.TicketDTO;

public interface TicketService {


    TicketDTO save(TicketDTO ticketDTO);

    void delete(Long id);

    void update(Long id, TicketDTO ticketDTO);

    //Public List<TicketDTO> findAll();
}
