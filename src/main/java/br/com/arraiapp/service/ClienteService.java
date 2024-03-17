package br.com.arraiapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.arraiapp.model.Cliente;

@Service
public class ClienteService {
	
	private List <Cliente> clienteList;
	
	public ClienteService() {
		clienteList = new ArrayList<>();
		Cliente cliente = new Cliente(1,"Roberto","teste@teste.com","123", "123123123-12");
		Cliente cliente2 = new Cliente(2,"Nicholas","teste@teste.com","123", "123123123-12");
		Cliente cliente3 = new Cliente(3,"Cleitinho","teste@teste.com","123", "123123123-12");
		
		clienteList.addAll(Arrays.asList(cliente,cliente2,cliente3));
	}
	
	public Optional<Cliente> getCliente(Integer id) {
		Optional<Cliente> optional = Optional.empty();
		for (Cliente cliente: clienteList) {
			if(id == cliente.getId()) {
				optional = Optional.of(cliente);
				return optional;
			}
		}
		return optional;
	}

}
