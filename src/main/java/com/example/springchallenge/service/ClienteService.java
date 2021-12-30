package com.example.springchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springchallenge.entity.Cliente;
import com.example.springchallenge.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> getAll() {
		return clienteRepository.getAllClientes();
	}
	public List<Cliente> getClientByState(String state) {
		return clienteRepository.getClientByState(state);
	}
	public List<Cliente> insertAllClient(List<Cliente> clientes) {
		return clienteRepository.insertAllClients(clientes);
	}
	
	public Cliente save(Cliente cliente)
	{
		return clienteRepository.insertCliente(cliente);
	}
}
