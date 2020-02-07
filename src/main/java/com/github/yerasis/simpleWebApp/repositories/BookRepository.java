package com.github.yerasis.simpleWebApp.repositories;

import com.github.yerasis.simpleWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {


}
