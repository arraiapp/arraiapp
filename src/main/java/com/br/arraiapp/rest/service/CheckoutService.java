package com.br.arraiapp.rest.service;

import com.br.arraiapp.domain.dto.CustomerTicket.CustomerTicketDTO;
import org.springframework.http.ResponseEntity;

public interface CheckoutService {

    public ResponseEntity<String> createCheckout(CustomerTicketDTO checkoutData);
}
