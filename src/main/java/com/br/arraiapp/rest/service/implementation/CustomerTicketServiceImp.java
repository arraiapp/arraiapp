package com.br.arraiapp.rest.service.implementation;

import com.br.arraiapp.domain.dto.CustomerTicket.CustomerTicketDTO;
import com.br.arraiapp.domain.dto.ticket.TicketMapper;
import com.br.arraiapp.domain.dto.ticket.TicketQuantityDTO;
import com.br.arraiapp.domain.entity.Customer;
import com.br.arraiapp.domain.entity.CustomerTicket;
import com.br.arraiapp.domain.entity.Ticket;
import com.br.arraiapp.domain.exception.CheckoutNotPaidException;
import com.br.arraiapp.domain.exception.ResourceNotFoundException;
import com.br.arraiapp.domain.repository.CustomerTicketRepository;
import com.br.arraiapp.domain.repository.CustomersRepository;
import com.br.arraiapp.rest.service.CustomerTicketService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerTicketServiceImp implements CustomerTicketService {

    private final TicketMapper ticketMapper = new TicketMapper();

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private CustomerTicketRepository customerTicketRepository;


    @Override
    public void getPaymentData(String json) throws JsonProcessingException {
        ObjectMapper objMapper = new ObjectMapper();
        JsonNode jsonNode = objMapper.readTree(json);

        System.out.println("json :" + jsonNode);
        System.out.println("json status :" + jsonNode.get("charges").get("status").asText());

        if (jsonNode.get("charges").get("status").asText().equals("PAID")) {
            List<TicketQuantityDTO> ticketDTOList = ticketMapper.toDto(jsonNode.get("items"));
            addTicket(jsonNode.get("tax_id").asText(), ticketDTOList);
        }
        else {
            throw new CheckoutNotPaidException("Checkout not paid");
        }
    }

    @Override
    public void addTicket(String customerCPF, List<TicketQuantityDTO> ticketDTOList){
        Customer customer = customersRepository.findByCpf(customerCPF)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));


        for(TicketQuantityDTO ticketDTO : ticketDTOList){
                Ticket ticket = ticketMapper.toEntity(ticketDTO);
                if(customerTicketRepository.findByCustomerIdAndTicketId(customer.getId(), ticket.getId()).isEmpty()){
                    customerTicketRepository.save(new CustomerTicket(
                            customer,
                            ticket,
                            ticketDTO.quantity()));
                }
                else {
                    CustomerTicket customerTicket = customerTicketRepository
                            .findByCustomerIdAndTicketId(customer.getId(), ticket.getId())
                            .orElseThrow(() -> new ResourceNotFoundException("Customer-ticket not found"));

                    customerTicket.setQuantity(customerTicket.getQuantity() + ticketDTO.quantity());
                    customerTicketRepository.save(customerTicket);
                }
        }
    }

    @Override
    public void consumeTicket(CustomerTicketDTO dto) throws BadRequestException {
        Customer customer = customersRepository.findByCpf(dto.customer().cpf())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        for(TicketQuantityDTO ticketDTO : dto.tickets()){
            Ticket ticket = ticketMapper.toEntity(ticketDTO);

            Optional<CustomerTicket> customerTicket = customerTicketRepository
                    .findByCustomerIdAndTicketId(customer.getId(), ticketDTO.id());

            if(customerTicket.isEmpty()){
                customerTicketRepository.save(new CustomerTicket(
                        customer,
                        ticket,
                        ticketDTO.quantity()));
            }
            else{
                if(customerTicket.get().getQuantity() < ticketDTO.quantity()){
                    throw new BadRequestException("Ticket quantity not available for this customer");
                }

                customerTicket.get().setQuantity(customerTicket.get().getQuantity() - ticketDTO.quantity());
                customerTicketRepository.save(customerTicket.get());
            }
        }
    }


    public List<TicketQuantityDTO> listCustomerTickets(String customerCpf) {
        List<CustomerTicket> customerTickets = customerTicketRepository.findAllByCustomerCpf(customerCpf);

        List<TicketQuantityDTO> dtoList = new ArrayList<>();

        for(CustomerTicket customerTicket : customerTickets){
            dtoList.add(ticketMapper.toDto(
                    customerTicket.getTicket(),
                    customerTicket.getQuantity()
            ));
        }

        return dtoList;
    }
}
