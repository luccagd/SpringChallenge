package com.example.springchallenge.dto;

import com.example.springchallenge.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientDTO {

	private Long clientId;
	private String name;
	private String cpf;
	private String state;
	private String email;

	public static Client convertToEntity(ClientDTO dto)
	{
		Client client = Client.builder().name(dto.getName())
				.cpf(dto.getCpf()).state(dto.getState()).email(dto.getEmail()).build();
		return client;
	}
	
	public static ClientDTO convertToDTO(Client client)
	{
		return ClientDTO.builder().clientId(client.getClientId()).name(client.getName())
				.cpf(client.getCpf()).state(client.getState()).email(client.getEmail()).build();
		 
	}
	
	public static List<ClientDTO> convertToList(List<Client> clients)
	{
		return clients.stream().map(cliente -> convertToDTO(cliente)).collect(Collectors.toList());
	}
}
