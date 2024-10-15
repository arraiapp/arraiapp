package com.br.arraiapp.rest.service.implementation;


import com.br.arraiapp.domain.entity.Stallholder;
import com.br.arraiapp.domain.dto.StallholderDTO;
import com.br.arraiapp.domain.repository.StallholdersRepository;
import com.br.arraiapp.rest.service.StallholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StallholderServiceImp implements StallholderService {

    @Autowired
    private StallholdersRepository repository;

    public StallholderDTO save(StallholderDTO stallholderDTO) {
        Stallholder stallholder = DTOToEntity(stallholderDTO);
        repository.save(stallholder);
        return stallholderDTO;
    }

    public StallholderDTO login(StallholderDTO stallholderDTO){
        return EntityToDTO(repository
                .findByCpfAndPassword(stallholderDTO.cpf(), stallholderDTO.password())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "CPF ou senha inválidos")));
    }

    public Stallholder DTOToEntity (StallholderDTO stallholderDTO) {
        return new Stallholder(
                stallholderDTO.name(),
                stallholderDTO.email(),
                stallholderDTO.password(),
                stallholderDTO.cpf(),
                stallholderDTO.Admin()
        );
    }

    public StallholderDTO EntityToDTO (Stallholder stallholder) {
        return new StallholderDTO(
                stallholder.getName(),
                stallholder.getEmail(),
                stallholder.getEmail(),
                stallholder.getCpf(),
                stallholder.getAdmin()
        );
    }
}
