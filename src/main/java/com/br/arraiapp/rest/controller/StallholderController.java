package com.br.arraiapp.rest.controller;

import com.br.arraiapp.domain.dto.stallholder.StallholderRequestDTO;
import com.br.arraiapp.rest.service.implementation.StallholderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

//Cross origin temporário, depois temos que acertar isso lá nas permissões, com a URL de verdade.
@CrossOrigin
@RestController
@RequestMapping("/api/stallholder")
public class StallholderController {

    @Autowired
    private StallholderServiceImp stallholderServiceImp;

    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.CREATED)
    public StallholderRequestDTO save(@RequestBody StallholderRequestDTO stallholderRequestDTO) {
        return stallholderServiceImp.save(stallholderRequestDTO);
    }

    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StallholderRequestDTO login(@RequestBody StallholderRequestDTO stallholderRequestDTO){
        return stallholderServiceImp.login(stallholderRequestDTO);
    }

}
