package com.br.arraiapp.domain.entity;

// Implementar Adicionar produto
//Implementar adicionar ficha

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Getter
@Table( name = "customer")
public class Customer extends User{

    @OneToMany (mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<CustomerTicket> CustomerTicket;

    public Customer(Long id, String name, String email, String password, String cpf, String phone) {
        this.setId(id);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setCpf(cpf);
        this.setPhone(phone);
    }

    public Customer(String name, String email, String password, String cpf, String phone) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setCpf(cpf);
        this.setPhone(phone);
    }
}
