package com.br.arraiapp.domain.repository;

import com.br.arraiapp.domain.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Integer >{

    Optional<Customer> findByCpfAndPassword(String cpf, String password);
}
