package com.br.arraiapp.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column( name = "value")
    private BigDecimal value;

    @OneToMany (mappedBy = "ticket")
    private Set<CustomerTicket> CustomerTicket;

    public Ticket(String description, BigDecimal value) {
        this.description = description;
        this.value = value;
    }
}
