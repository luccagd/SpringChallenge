package com.example.springchallenge.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.springchallenge.entity.Cliente;
import com.example.springchallenge.helper.DatabaseHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ClienteRepository {
	private ObjectMapper objectMapper = DatabaseHelper.getObjectMapper();
    private String PATHCLI = DatabaseHelper.getDatabasePathClientes();
    private List<Cliente> clientes = new ArrayList<>(DatabaseHelper.getDatabaseClientes());


    public List<Cliente> getAllClientes()
    {
    	return new ArrayList<>(clientes);
    }
    
    private void updateFile()
    {
    	try {
    	     objectMapper.writeValue(new File(PATHCLI), this.clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Cliente insertCliente(Cliente cliente)
    {
    	cliente.setClientId((long) this.clientes.size() +1);
    	clientes.add(cliente);
    	updateFile();
    	return cliente;

    }

	public List<Cliente> getClientByState(String state) {
		return clientes.stream().filter(c -> c.getState().equals(state)).collect(Collectors.toList());
	}
    
}

