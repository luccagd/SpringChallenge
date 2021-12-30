package com.example.springchallenge.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.springchallenge.entity.Cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClienteDTO {

	private Long clientId;
	private String name;
	private String cpf;
	private String state;
	private String email;

	public static Cliente convertToEntity(ClienteDTO dto)
	{
		Cliente cliente = Cliente.builder().name(dto.getName())
				.cpf(dto.getCpf()).state(dto.getState()).email(dto.getEmail()).build();
		return cliente;
	}
	
	public static ClienteDTO convertToDTO(Cliente cliente)
	{
		return ClienteDTO.builder().clientId(cliente.getClientId()).name(cliente.getName())
				.cpf(cliente.getCpf()).state(cliente.getState()).email(cliente.getEmail()).build();
		 
	}
	
	public static List<ClienteDTO> convertToList(List<Cliente> clientes)
	{
		return clientes.stream().map(cliente -> convertToDTO(cliente)).collect(Collectors.toList());
	}
	
	public static List<ClienteDTO> entityListToDTO(List<Cliente> clientes) {
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        for (Cliente cliente : clientes) {
            clientesDTO.add(convertToDTO(cliente));
        }

        return clientesDTO;
    }

    public static List<Cliente> dtoListToEntity(List<ClienteDTO> clientesDTO) {
        List<Cliente> clientes = new ArrayList<>();
        for (ClienteDTO clienteDTO : clientesDTO) {
            clientes.add(convertToEntity(clienteDTO));
        }

        return clientes;
    }
}
