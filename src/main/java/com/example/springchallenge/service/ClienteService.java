package com.example.springchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.springchallenge.entity.Cliente;
import com.example.springchallenge.exception.AppErrorException;
import com.example.springchallenge.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> getAll() {
		return clienteRepository.getAllClientes();
	}

	public List<Cliente> getClientByState(String state) {
		try {
			return clienteRepository.getClientByState(state);
		} catch (Exception e) {
			throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Não foi possível listar os clientes por estado!", e.getMessage());
		}

	}

	public Cliente save(Cliente cliente) {
		try {
			return clienteRepository.insertCliente(cliente);

		} catch (Exception e) {
			throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Não foi possível cadastrar o cliente!",
					e.getMessage());
		}
	}
}
