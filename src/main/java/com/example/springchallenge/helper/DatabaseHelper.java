package com.example.springchallenge.helper;

import com.example.springchallenge.entity.Article;
import com.example.springchallenge.entity.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

public abstract class DatabaseHelper {
    private static final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private static final String PATH_ARTICLE = "database.json";
    private static final String PATH_CLIENT = "clients.json";

    public static List<Article> getDatabaseArticle() {
        try {
            File file = new File(PATH_ARTICLE);
            FileInputStream is = new FileInputStream(file);

            return Arrays.asList(objectMapper.readValue(is, Article[].class));
        } catch (Exception e) {
            System.err.println(e.getMessage());

            return null;
        }
    }

    public static List<Client> getDatabaseClient() {
        try {
            File file = new File(PATH_CLIENT);
            FileInputStream is = new FileInputStream(file);

            return Arrays.asList(objectMapper.readValue(is, Client[].class));
        } catch (Exception e) {
            System.err.println(e.getMessage());

            return null;
        }
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public static String getDatabasePath() {
        return PATH_ARTICLE;
    }

    public static String getDatabasePathClients() {
        return PATH_CLIENT;
    }
}