package com.manos.repositories;

import com.manos.model.Book;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
