package com.example.springchallenge.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cliente {

	private Long clientId;
	private String name;
	private String cpf;
	private String state;
	private String email;

}
