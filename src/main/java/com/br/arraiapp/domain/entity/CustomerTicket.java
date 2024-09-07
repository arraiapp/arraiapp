package com.br.arraiapp.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customerTicket")
public class CustomerTicket {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Boolean active;

}
