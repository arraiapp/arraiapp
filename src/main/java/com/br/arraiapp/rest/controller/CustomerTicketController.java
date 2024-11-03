package com.br.arraiapp.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@CrossOrigin
@RestController
@RequestMapping("api/customer-ticket")
public class CustomerTicketController {

    @PostMapping("/redirect-to-app")
    @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    public ResponseEntity<?> redirectToApp(String json) throws JsonProcessingException, URISyntaxException {

        URI uri = new URI("x");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);

        return new ResponseEntity<>(httpHeaders, HttpStatus.TEMPORARY_REDIRECT);
    }

    @PostMapping("/get-paymentData")
    public JsonNode getPaymentData(@RequestBody String json) throws JsonProcessingException {
        ObjectMapper objMapper = new ObjectMapper();
        JsonNode jsonNode = objMapper.readTree(json);
        System.out.println(jsonNode);
        return jsonNode;
    }

}
