package com.pandi.spring5webapp.controller;

import com.pandi.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //this annotates this class as a controller
public class AuthorController {

    private AuthorRepository authorRepository;
    //constructor for the author repository
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    @RequestMapping("/authors") //map to localhost:8080/authors
    public String getAuthors(Model model){
        model.addAttribute("authors",authorRepository.findAll());

        return "authors"; //it will render the "authors" thymeleaf view
    }
}
