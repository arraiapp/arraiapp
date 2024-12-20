package com.br.arraiapp.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name="id",nullable=false)
    private Long id;

    @Column(name = "description",nullable=false)
    private String description;

    @Column( name = "value",nullable=false)
    private BigDecimal value;

    @OneToMany (mappedBy = "ticket")
    private Set<CustomerTicket> CustomerTicket;

    public Ticket(String description, BigDecimal value) {
        this.description = description;
        this.value = value;
    }

    public Ticket(Long id, String description, BigDecimal value) {
        this.id = id;
        this.description = description;
        this.value = value;
    }
}
