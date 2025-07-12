package com.example.Library.service;

import com.example.Library.model.Book;
import com.example.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired private BookRepository bookRepository;

    //1. Adding a new book
    public Book addBook(Book book) {
        List<Book> existing = bookRepository.findByIsbn(book.getIsbn());

        if (!existing.isEmpty()) {
            throw new RuntimeException("Book with this ISBN already exists.");
        }
        return bookRepository.save(book);
    }

    //2. Retrieving the list of all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //3. Getting details of a book by its ID
    public Book getBookById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
    }

    //4. Deleting a book
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    //5. Update availability of the book
    public Book updateAvailability(Integer id, Boolean available) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
        book.setAvailable(available);
        return bookRepository.save(book);
    }




}
