package com.br.arraiapp.rest.service.implementation;

import com.br.arraiapp.domain.entity.Ticket;
import com.br.arraiapp.domain.dto.TicketDTO;
import com.br.arraiapp.domain.exception.ResourceNotFoundException;
import com.br.arraiapp.domain.repository.TicketRepository;
import com.br.arraiapp.rest.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImp implements TicketService {

    @Autowired
    private TicketRepository repository;

    public TicketDTO save(TicketDTO ticketDTO) {
        Ticket ticket = DTOToEntity(ticketDTO);
        return EntityToDTO(
                repository.save(ticket)
        );
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
                    return EntityToDTO(
                            repository.save(ticket)
                    );
                }).orElseThrow(() ->
                        new ResourceNotFoundException("No tickets found for this ID")
                );
    }

    public List<TicketDTO> findAll() {
        List<Ticket> ticketList = repository.findAll();
        List<TicketDTO> ticketDTOList = new ArrayList<>();

        for (Ticket ticket : ticketList) {
            ticketDTOList.add(EntityToDTO(ticket));
        }

        return ticketDTOList;
    }

    public TicketDTO findById(Long id) {
        return EntityToDTO(repository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No tickets found for this ID")));
    }

    public Ticket DTOToEntity (TicketDTO ticketDTO) {
        return new Ticket(
                ticketDTO.description(),
                ticketDTO.value()
        );
    }

    public TicketDTO EntityToDTO (Ticket ticket) {
        return new TicketDTO(
                ticket.getId(),
                ticket.getDescription(),
                ticket.getValue()
        );
    }



}
