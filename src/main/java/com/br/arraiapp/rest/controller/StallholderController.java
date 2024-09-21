package com.br.arraiapp.rest.controller;

import com.br.arraiapp.domain.entity.dto.StallholderDTO;
import com.br.arraiapp.service.implementation.StallholderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

//Cross origin temporário, depois temos que acertar isso lá nas permissões, com a URL de verdade.
@CrossOrigin("http://localhost:5000/")
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
    public StallholderDTO save(@RequestBody StallholderDTO stallholderDTO) {
        return stallholderServiceImp.save(stallholderDTO);
    }

    @RequestMapping(value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StallholderDTO login(@RequestBody StallholderDTO stallholderDTO){
        return stallholderServiceImp.login(stallholderDTO);
    }

}
