package com.br.arraiapp.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customerTicket")
public class CustomerTicket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Column(name = "quantity")
    private Long quantity;

    public CustomerTicket(Customer customer, Ticket ticket, Long quantity) {
        this.customer = customer;
        this.ticket = ticket;
        this.quantity = quantity;
    }
}
