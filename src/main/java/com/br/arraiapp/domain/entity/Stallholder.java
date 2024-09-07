package com.br.arraiapp.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.br.arraiapp.domain.entity.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stallholder")
public class Stallholder extends User {

    @Column
    private Boolean Admin;

}
