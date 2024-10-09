package com.br.arraiapp.domain.entity.dto;

import java.math.BigDecimal;

public record TicketDTO(Long id, String description, BigDecimal value) {
}
