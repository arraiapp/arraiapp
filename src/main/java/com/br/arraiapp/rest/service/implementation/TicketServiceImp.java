package com.br.arraiapp.rest.service.implementation;

import com.br.arraiapp.domain.dto.ticket.TicketMapper;
import com.br.arraiapp.domain.entity.Ticket;
import com.br.arraiapp.domain.dto.ticket.TicketDTO;
import com.br.arraiapp.domain.exception.ResourceNotFoundException;
import com.br.arraiapp.domain.repository.TicketRepository;
import com.br.arraiapp.rest.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImp implements TicketService {

    @Autowired
    private TicketRepository repository;
    private final TicketMapper mapper = new TicketMapper();

    public TicketDTO save(TicketDTO ticketDTO) {
        Ticket ticket = mapper.toEntity(ticketDTO);
        return mapper.toDto(repository.save(ticket));
    }

    //Mudar e colocar o handler de excpetion depois.

    public void delete(Long id) {
        repository
                .findById(id)
                .map( p -> {
                    repository.delete(p);
                    return Void.TYPE;
                }).orElseThrow( () ->
                        new ResourceNotFoundException("No tickets found for this ID")
                );
    }

    public TicketDTO update(TicketDTO ticketDTO) {
        return repository
                .findById(ticketDTO.id())
                .map(ticket -> {
                    ticket.setDescription(ticketDTO.description());
                    ticket.setValue(ticketDTO.value());
                    return mapper.toDto(repository.save(ticket));
                }).orElseThrow(() ->
                        new ResourceNotFoundException("No tickets found for this ID")
                );
    }

    public List<TicketDTO> findAll() {
        List<Ticket> ticketList = repository.findAll();
        return mapper.toDto(ticketList);
    }

    public TicketDTO findById(Long id) {
        return mapper.toDto(repository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No tickets found for this ID")));
    }
}
