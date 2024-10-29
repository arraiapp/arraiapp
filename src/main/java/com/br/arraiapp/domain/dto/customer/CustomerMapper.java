package com.br.arraiapp.domain.dto.customer;

import com.br.arraiapp.domain.dto.DTOMapper;
import com.br.arraiapp.domain.entity.Customer;

public class CustomerMapper implements DTOMapper<CustomerDTO, Customer> {

    //CustomerDTO
    @Override
    public Customer toEntity(CustomerDTO dto) {
        return new Customer(
                dto.id(),
                dto.name(),
                dto.email(),
                dto.password(),
                dto.cpf(),
                dto.phone()
        );
    }

    @Override
    public CustomerDTO toDto(Customer entity) {
        return new CustomerDTO(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getEmail(),
                entity.getCpf(),
                entity.getPhone()
        );
    }

    //CustomerRequestDTO
    public Customer toEntity(CustomerRequestDTO dto) {
        return new Customer(
                dto.name(),
                dto.email(),
                dto.password(),
                dto.cpf(),
                dto.phone()
        );
    }

    public CustomerRequestDTO toDtoRequest(Customer entity) {
        return new CustomerRequestDTO(
                entity.getName(),
                entity.getEmail(),
                entity.getEmail(),
                entity.getCpf(),
                entity.getPhone()
        );
    }

}
