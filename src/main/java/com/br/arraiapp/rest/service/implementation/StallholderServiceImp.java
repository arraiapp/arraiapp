package com.br.arraiapp.rest.service.implementation;


import com.br.arraiapp.domain.dto.stallholder.StallholderMapper;
import com.br.arraiapp.domain.entity.Stallholder;
import com.br.arraiapp.domain.dto.stallholder.StallholderRequestDTO;
import com.br.arraiapp.domain.exception.ResourceNotFoundException;
import com.br.arraiapp.domain.repository.StallholdersRepository;
import com.br.arraiapp.rest.service.StallholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StallholderServiceImp implements StallholderService {

    @Autowired
    private StallholdersRepository repository;
    private final StallholderMapper mapper = new StallholderMapper();

    public StallholderRequestDTO save(StallholderRequestDTO stallholderRequestDTO) {
        Stallholder stallholder = mapper.toEntity(stallholderRequestDTO);
        repository.save(stallholder);
        return stallholderRequestDTO;
    }

    public StallholderRequestDTO login(StallholderRequestDTO stallholderRequestDTO){
        return mapper.toDtoRequest(repository
                .findByCpfAndPassword(stallholderRequestDTO.cpf(), stallholderRequestDTO.password())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Dados incorretos")));
    }

}
