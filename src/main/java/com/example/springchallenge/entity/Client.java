package com.example.springchallenge.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Client {

	private Long clientId;
	private String name;
	private String cpf;
	private String state;
	private String email;

}
