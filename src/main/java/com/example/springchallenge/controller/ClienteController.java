package com.example.springchallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springchallenge.dto.ClienteDTO;
import com.example.springchallenge.entity.Cliente;
import com.example.springchallenge.service.ClienteService;

@RestController
@RequestMapping()
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping("/client/listAll")
	public ResponseEntity<List<ClienteDTO>> getAll() {
		List<Cliente> clientes = service.getAll();

		return ResponseEntity.ok().body(ClienteDTO.convertToList(clientes));
	}

	@GetMapping(value = "/client", params = { "state" })
	public ResponseEntity<List<ClienteDTO>> getByState(@RequestParam String state) {
		return ResponseEntity.ok().body(ClienteDTO.convertToList(service.getClientByState(state)));
	}

	@PostMapping("/client/insert")
	public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
		Cliente cliente = service.save(ClienteDTO.convertToEntity(clienteDTO));

		return ResponseEntity.ok().body(ClienteDTO.convertToDTO(cliente));
	}
}
