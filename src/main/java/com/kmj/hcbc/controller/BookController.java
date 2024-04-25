package com.kmj.hcbc.controller;

import com.kmj.hcbc.model.Book;
import com.kmj.hcbc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public ResponseEntity create(@RequestBody Book book)  {
        return bookService.create(book);
    }

    @GetMapping("/books/{id}")
    public Book find(@PathVariable Integer id) {
        return bookService.find(id);
    }

    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity delete(@PathVariable Integer id)  {
        return bookService.delete(id);
    }

    @PutMapping(value = "/books/update/{id}")
    public void update(
            @PathVariable Integer id,
            @RequestBody Book book) {
        bookService.update(id, book);
    }
}
