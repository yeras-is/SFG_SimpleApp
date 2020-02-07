package com.github.yerasis.simpleWebApp.repositories;

import com.github.yerasis.simpleWebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
