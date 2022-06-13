package com.example.auchanbooksrenderer.endpoints;

import com.example.auchanbooksrenderer.service.BookService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@JsonIgnoreProperties(ignoreUnknown=true)
public class BooksController {

    private final BookService bookService;

    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    String getBooks(Model model) throws JsonProcessingException {
        model.addAttribute("title", "Ma bibliothèque : ");
        model.addAttribute("retrievedBooks", bookService.getBooks());

        return "books";
    }

}
