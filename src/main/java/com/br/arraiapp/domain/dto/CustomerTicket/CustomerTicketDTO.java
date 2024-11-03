package com.br.arraiapp.domain.dto.CustomerTicket;

import com.br.arraiapp.domain.dto.customer.CustomerDTO;
import com.br.arraiapp.domain.dto.ticket.TicketDTO;

public record CustomerTicketDTO(CustomerDTO customer,
                                TicketDTO ticket,
                                Long quantity) {
}
