package com.br.arraiapp.rest.service;

import com.br.arraiapp.domain.dto.CustomerTicket.CustomerTicketDTO;
import com.br.arraiapp.domain.dto.ticket.TicketQuantityDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface CustomerTicketService {
    public void getPaymentData(String json) throws JsonProcessingException;


    public void consumeTicket(CustomerTicketDTO dto) throws BadRequestException;


    public void addTicket(String customerCPF, List<TicketQuantityDTO> ticketDTOList);

    public List<TicketQuantityDTO> listCustomerTickets(String customerCpf);


}
