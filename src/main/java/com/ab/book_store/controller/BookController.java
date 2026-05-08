package com.ab.book_store.controller;

import com.ab.book_store.dto.BookDto;
import com.ab.book_store.service.serviceImpl.BookServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book-store")
public class BookController {

    BookServiceImpl bookServiceimpl;
    public BookController(BookServiceImpl bookServiceimpl) {
        this.bookServiceimpl = bookServiceimpl;
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeMessage() {
        return new ResponseEntity<>("Welcome to Book Store", HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = new ArrayList<>();
        books = bookServiceimpl.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping ("/{bookId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<BookDto> getBook(@PathVariable String bookId){
        BookDto bookDto = bookServiceimpl.getBookById(bookId);
        return  new ResponseEntity<>(bookDto,HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        List<BookDto> book = new ArrayList<>();
        BookDto bookDto1 = bookServiceimpl.createBook(bookDto);
        return new ResponseEntity<>(bookDto1,HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BookDto> updateBook (@RequestBody BookDto bookDto){
        List<BookDto> book = new ArrayList<>();
        BookDto bookDto1 = bookServiceimpl.createBook(bookDto);
        return new ResponseEntity<>(bookDto1,HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteBookById(@PathVariable String bookId){
        bookServiceimpl.deleteBookById(bookId);
        return new ResponseEntity<>("Book Deleted Successfully",HttpStatus.OK);
    }
}
