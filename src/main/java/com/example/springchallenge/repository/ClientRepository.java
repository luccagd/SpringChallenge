package com.example.springchallenge.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.springchallenge.entity.Client;
import com.example.springchallenge.helper.DatabaseHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ClientRepository {
	private ObjectMapper objectMapper = DatabaseHelper.getObjectMapper();
    private String PATHCLI = DatabaseHelper.getDatabasePathClients();
    private List<Client> clients = new ArrayList<>(DatabaseHelper.getDatabaseClient());


    public List<Client> getAllClients()
    {
    	return new ArrayList<>(clients);
    }
    
    private void updateFile()
    {
    	try {
    	     objectMapper.writeValue(new File(PATHCLI), this.clients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Client insertClient(Client client)
    {
    	client.setClientId((long) this.clients.size() +1);
    	clients.add(client);
    	updateFile();
    	return client;

    }

	public List<Client> getClientByState(String state) {
		return clients.stream().filter(c -> c.getState().equals(state)).collect(Collectors.toList());
	}
    
}

