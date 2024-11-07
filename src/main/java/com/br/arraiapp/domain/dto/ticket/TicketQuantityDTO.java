package com.br.arraiapp.domain.dto.ticket;

import java.math.BigDecimal;

public record TicketQuantityDTO(Long id, String description, BigDecimal value, Long quantity) {
}
