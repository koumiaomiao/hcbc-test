package com.kmj.hcbc.service;

import com.kmj.hcbc.model.Book;
import com.kmj.hcbc.repository.BookRepository;
import com.kmj.hcbc.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public ResponseEntity<String> create(Book book) {
        bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(Constants.CREATE_SUCCESS);
    }

    @Transactional
    public Book find(Integer id) {
        return Optional.of(bookRepository.findById(id)).get().orElseThrow();
    }

    public ResponseEntity<String> delete(Integer id) {
        bookRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Constants.DELETE_SUCCESS);
    }

    public void update(Integer id, Book book) {
        book.setId(id);
        bookRepository.save(book);
    }
}
