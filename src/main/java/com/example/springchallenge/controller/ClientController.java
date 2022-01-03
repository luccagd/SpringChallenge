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

import com.example.springchallenge.dto.ClientDTO;
import com.example.springchallenge.entity.Client;
import com.example.springchallenge.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/listAll")
    public ResponseEntity<List<ClientDTO>> getAll() {
        List<Client> clients = service.getAll();

        return ResponseEntity.ok().body(ClientDTO.convertToList(clients));
    }

    @GetMapping(value = "/list", params = { "state" })
    public ResponseEntity<List<ClientDTO>> getByState(@RequestParam String state) {
        return ResponseEntity.ok().body(ClientDTO.convertToList(service.getClientByState(state)));
    }

    @PostMapping("/insert")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        Client client = service.save(ClientDTO.convertToEntity(clientDTO));

        return ResponseEntity.ok().body(ClientDTO.convertToDTO(client));
    }
}
