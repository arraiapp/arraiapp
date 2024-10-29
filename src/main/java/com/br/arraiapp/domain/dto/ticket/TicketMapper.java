package com.br.arraiapp.domain.dto.ticket;

import com.br.arraiapp.domain.dto.DTOMapper;
import com.br.arraiapp.domain.entity.Ticket;
import lombok.NoArgsConstructor;

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

}
