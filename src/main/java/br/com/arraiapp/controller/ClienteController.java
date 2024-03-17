package br.com.arraiapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.arraiapp.model.Cliente;
import br.com.arraiapp.service.ClienteService;

@RestController
public class ClienteController {
	
	
	private ClienteService clienteService;
	
	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	
	@GetMapping("/cliente")
	public Cliente getCliente(@RequestParam Integer id) {
		Optional<Cliente> cliente = clienteService.getCliente(id);
		if(cliente.isPresent()) {
			return (Cliente) cliente.get();
		}
		return null;
	}
}
