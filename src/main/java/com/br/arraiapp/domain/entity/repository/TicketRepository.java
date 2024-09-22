package com.br.arraiapp.domain.entity.repository;

import com.br.arraiapp.domain.entity.Stallholder;
import com.br.arraiapp.domain.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
