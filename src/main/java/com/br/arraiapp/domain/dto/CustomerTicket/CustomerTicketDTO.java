package com.br.arraiapp.domain.dto.CustomerTicket;

import com.br.arraiapp.domain.dto.customer.CustomerRequestDTO;
import com.br.arraiapp.domain.dto.ticket.TicketQuantityDTO;

import java.util.List;

public record CustomerTicketDTO(CustomerRequestDTO customer,
                                List<TicketQuantityDTO> tickets
                                ) {
}
