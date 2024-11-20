package com.br.arraiapp.domain.dto.ticket;

import com.br.arraiapp.domain.dto.DTOMapper;
import com.br.arraiapp.domain.entity.Ticket;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
public class TicketMapper implements DTOMapper<TicketDTO, Ticket> {

    @Override
    public Ticket toEntity(TicketDTO dto){
        return new Ticket(
                dto.description(),
                dto.value()
        );
    }

    @Override
    public TicketDTO toDto(Ticket entity){
        return new TicketDTO(
                entity.getId(),
                entity.getDescription(),
                entity.getValue()
        );
    }

    public List<TicketDTO> toDto(List<Ticket> entityList) {
        List<TicketDTO> dtoList = new ArrayList<>();

        for (Ticket ticket : entityList) {
            dtoList.add(toDto(ticket));
        }

        return dtoList;
    }

    public List<TicketQuantityDTO> toDto (JsonNode json) {
        List<TicketQuantityDTO> dtoList = new ArrayList<>();
        System.out.println(json);
        for (JsonNode ticket :json){
            dtoList.add(new TicketQuantityDTO(
                    ticket.get("reference_id").asLong(),
                    ticket.get("name").asText(),
                    new BigDecimal(ticket.get("unit_amount").asInt()).divide(new BigDecimal(10)),
                    ticket.get("quantity").asLong()
            ));
        }

        return dtoList;
    }

    public Ticket toEntity(TicketQuantityDTO dto){
        return new Ticket(dto.id(),
                dto.description(),
                dto.value());
    }

    public TicketQuantityDTO toDto(Ticket ticket, Long quantity){
        return new TicketQuantityDTO(
                ticket.getId(),
                ticket.getDescription(),
                ticket.getValue(),
                quantity
        );
    }



}
