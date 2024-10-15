package com.br.arraiapp.domain.repository;

import com.br.arraiapp.domain.entity.Stallholder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StallholdersRepository extends JpaRepository<Stallholder, Integer > {

    Optional<Stallholder> findByCpfAndPassword(String cpf, String password);

}
