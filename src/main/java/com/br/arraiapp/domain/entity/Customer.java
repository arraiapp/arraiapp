package com.br.arraiapp.domain.entity;

// Implementar Adicionar produto
//Implementar adicionar ficha

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table( name = "customer")
public class Customer extends User{

    @OneToMany (mappedBy = "customer", fetch = FetchType.LAZY)
    // Conferir o cascade em outra hora cascade = CascadeType.ALL)
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
