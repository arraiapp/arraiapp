package com.br.arraiapp.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/customer-ticket")
public class CustomerTicketController {

    @PostMapping("/getPaymentData")
    public JsonNode getPaymentData(String json) throws JsonProcessingException {
        ObjectMapper objMapper = new ObjectMapper();
        return objMapper.readTree(json);
    }

}
