package com.br.arraiapp.domain.dto.CustomerTicket;

import com.br.arraiapp.domain.dto.DTOMapper;
import com.br.arraiapp.domain.dto.customer.CustomerMapper;
import com.br.arraiapp.domain.dto.ticket.TicketMapper;
import com.br.arraiapp.domain.entity.CustomerTicket;

public class CustomerTicketMapper implements DTOMapper<CustomerTicketDTO, CustomerTicket> {
    private final CustomerMapper customerMapper = new CustomerMapper();
    private final TicketMapper ticketMapper = new TicketMapper();

    @Override
    public CustomerTicket toEntity(CustomerTicketDTO dto) {
        return new CustomerTicket(
                customerMapper.toEntity(dto.customer()),
                ticketMapper.toEntity(dto.ticket()),
                dto.quantity()
        );
    }

    @Override
    public CustomerTicketDTO toDto(CustomerTicket entity) {
        return new CustomerTicketDTO(
                customerMapper.toDto(entity.getCustomer()),
                ticketMapper.toDto(entity.getTicket()),
                entity.getQuantity()
        );
    }
}
