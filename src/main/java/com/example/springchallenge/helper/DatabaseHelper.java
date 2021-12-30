package com.example.springchallenge.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

import com.example.springchallenge.entity.Cliente;
import com.example.springchallenge.entity.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public abstract class DatabaseHelper {
	private static ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	private static final String PATH = "database.json";
	private static final String PATHCLI = "clients.json";

	public static List<Produto> getDatabase() {
		try {
			File file = new File(PATH);
			FileInputStream is = new FileInputStream(file);

			return Arrays.asList(objectMapper.readValue(is, Produto[].class));
		} catch (Exception e) {
			System.err.println(e.getMessage());

			return null;
		}
	}

//verificar depois
	public static List<Cliente> getDatabaseClientes() {
		try {
			File file = new File(PATHCLI);
			FileInputStream is = new FileInputStream(file);

			return Arrays.asList(objectMapper.readValue(is, Cliente[].class));
		} catch (Exception e) {
			System.err.println(e.getMessage());

			return null;
		}
	}

	public static ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public static String getDatabasePath() {
		return PATH;
	}

	public static String getDatabasePathClientes() {
		return PATHCLI;
	}
}