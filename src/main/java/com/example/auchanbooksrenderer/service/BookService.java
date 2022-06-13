package com.example.auchanbooksrenderer.service;

import com.example.auchanbooksrenderer.model.BookModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final String API_LINK = "http://localhost:8080";
    private WebClient booksApi = getWebClient();

    private WebClient getWebClient() {
        return WebClient.create(API_LINK);
    }

    @Autowired
    private ObjectMapper objectMapper;

    public List<BookModel> getBooks() throws JsonProcessingException {
        String booksApiResult = booksApi.get().uri("/books").retrieve().bodyToMono(String.class).block();
        return List.of(objectMapper.readValue(booksApiResult, BookModel[].class));
    }

}


