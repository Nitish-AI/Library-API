package com.example.Library.controller;

import com.example.Library.model.Book;
import com.example.Library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {
    @Autowired private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody @Valid Book book) {
        try {
            Book savedBook = bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
        } catch (RuntimeException ex) {
            // Return 400 Bad Request with the exception message
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllBooks(){
        try{
            List<Book> books = bookService.getAllBooks();
            return ResponseEntity.ok(books); // 200 OK with book list
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBook(@PathVariable Integer id) {
        try {
            Book book = bookService.getBookById(id);
            return ResponseEntity.ok(book);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id){
        try{
            bookService.deleteBook(id);
            return ResponseEntity.ok("Book deleted successfully."); // 200 OK
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PatchMapping("/{id}/availability")
    public Book updateAvailability(@PathVariable Integer id, @RequestParam Boolean available) {
        return bookService.updateAvailability(id, available);
    }



}
