package com.example.springchallenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.springchallenge.entity.Client;
import com.example.springchallenge.exception.AppErrorException;
import com.example.springchallenge.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAll() {
		return clientRepository.getAllClients();
	}

	public List<Client> getClientByState(String state) {
		try {
			return clientRepository.getClientByState(state);
		} catch (Exception e) {
			throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Não foi possível listar os clientes por estado!", e.getMessage());
		}

	}

	public Client save(Client client) {
		try {
			return clientRepository.insertClient(client);

		} catch (Exception e) {
			throw new AppErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Não foi possível cadastrar o cliente!",
					e.getMessage());
		}
	}
}
