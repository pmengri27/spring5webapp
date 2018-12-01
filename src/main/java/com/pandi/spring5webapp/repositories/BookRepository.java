package com.pandi.spring5webapp.repositories;

import com.pandi.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

//This connects to our Author entity class model and allows us to use CRUD operations
public interface BookRepository extends CrudRepository<Book, Long> {
}
