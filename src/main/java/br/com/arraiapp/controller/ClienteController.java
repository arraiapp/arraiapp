package br.com.arraiapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import br.com.arraiapp.model.Cliente;
import br.com.arraiapp.service.ClienteService;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
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

	@RequestMapping("/cadastro")
	public void CadastraCliente(@RequestParam Integer id, String nome, String email,  String senha , String cpf) {
		this.clienteService.cadastraCliente(id, nome, email, senha, cpf);
	}

	@RequestMapping("/login")
	public Cliente LoginCliente(@RequestParam String cpf, String senha) {

		Optional<Cliente> cliente = this.clienteService.loginCliente(cpf, senha);

		if(cliente.isPresent()) {
			return (Cliente) cliente.get();
		}
		return null;

	}
}
