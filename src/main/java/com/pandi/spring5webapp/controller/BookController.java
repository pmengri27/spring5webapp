package com.pandi.spring5webapp.controller;


import com.pandi.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //this annotation tells Spring that this is a controller
public class BookController {

    private BookRepository bookRepository;

    //Constructor for the book repository
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //
    //here we are passing in the model so Spring can use the model object. Therefore spring will pass in the implementation of the model at runtime
    @RequestMapping("/books")
    public String getBooks(Model model){
        //tells spring data jpa to find all books in the repository
        model.addAttribute("books", bookRepository.findAll());

        return "books"; //this associates it with a thymeleaf view named "books"
    }
}
