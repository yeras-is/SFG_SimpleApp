package com.github.yerasis.simpleWebApp.repositories;

import com.github.yerasis.simpleWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
