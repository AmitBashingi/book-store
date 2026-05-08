package com.ab.book_store.service;

import com.ab.book_store.dto.BookDto;
import com.ab.book_store.entity.Book;

import java.util.List;

public interface BookService {
    public List<BookDto> getAllBooks();

    public BookDto getBookById(String bookId);

    public BookDto createBook(BookDto bookDto);

    public BookDto updateBook(BookDto bookDto);

    public void deleteBookById(String bookId);
}
