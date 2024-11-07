package com.br.arraiapp.domain.repository;

import com.br.arraiapp.domain.entity.CustomerTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerTicketRepository extends JpaRepository<CustomerTicket, Integer > {

    Optional<CustomerTicket> findByCustomerIdAndTicketId(Long customerId, Long ticketId);

    List<CustomerTicket> findAllByCustomerCpf(String customerCpf);

}
