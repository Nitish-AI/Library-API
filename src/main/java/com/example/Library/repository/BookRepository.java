package com.example.Library.repository;

import com.example.Library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByIsbn(String isbn);
    Optional<Book> findById(Integer id);

}
