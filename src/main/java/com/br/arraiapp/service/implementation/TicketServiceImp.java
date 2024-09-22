package com.br.arraiapp.service.implementation;

import com.br.arraiapp.domain.entity.Customer;
import com.br.arraiapp.domain.entity.Ticket;
import com.br.arraiapp.domain.entity.dto.CustomerDTO;
import com.br.arraiapp.domain.entity.dto.TicketDTO;
import com.br.arraiapp.domain.entity.repository.TicketRepository;
import com.br.arraiapp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImp implements TicketService {

    @Autowired
    private TicketRepository repository;

    @Override
    public TicketDTO save(TicketDTO ticketDTO) {
        Ticket ticket = DTOToEntity(ticketDTO);
        return EntityToDTO(
                repository.save(ticket)
        );
    }

    public Ticket DTOToEntity (TicketDTO ticketDTO) {
        return new Ticket(
                ticketDTO.description(),
                ticketDTO.value()
        );
    }

    public TicketDTO EntityToDTO (Ticket ticket) {
        return new TicketDTO(
                ticket.getDescription(),
                ticket.getValue()
        );
    }

}
