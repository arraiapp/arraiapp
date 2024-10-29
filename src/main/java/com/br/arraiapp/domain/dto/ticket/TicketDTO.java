package com.br.arraiapp.domain.dto.ticket;

import java.math.BigDecimal;

public record TicketDTO(Long id, String description, BigDecimal value) {
}
