package com.pandi.spring5webapp.bootstrap;


import com.pandi.spring5webapp.model.Author;
import com.pandi.spring5webapp.model.Book;
import com.pandi.spring5webapp.model.Publisher;
import com.pandi.spring5webapp.repositories.AuthorRepository;
import com.pandi.spring5webapp.repositories.BookRepository;
import com.pandi.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//This is a class that helps us populate our dev DB using bootstrap (similar to liquibase)
@Component //this annotates it as a spring component so it gets auto wired in
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    //bringing in our repositories
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    //constructors


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    //This runs our initData method when we refresh
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){
        //create new publisher, set new publishers name and address, and save
        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisher.setAddress("123");
        publisherRepository.save(publisher);


        //Eric
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book ("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book ("J2EE Development without EJB", "23444", publisher);
        eric.getBooks().add(ddd);
        rod.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
