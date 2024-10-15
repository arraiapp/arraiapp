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

    public void update(TicketDTO ticketDTO){
        Ticket ticketParam = DTOToEntity(ticketDTO);
        repository
                .findById(ticketDTO.id())
                .map( ticket -> {
                    ticketParam.setId(ticket.getId());
                    repository.save(ticketParam);
                    return ticketParam;
                }).orElseThrow( () ->
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
