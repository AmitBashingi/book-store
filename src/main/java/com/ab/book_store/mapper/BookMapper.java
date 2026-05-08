package com.ab.book_store.mapper;

import com.ab.book_store.dto.BookDto;
import com.ab.book_store.entity.Book;

public class BookMapper {

    public static BookDto toDto(Book book){
        BookDto bookDto = new BookDto(book.getBookId(),book.getBookName(),book.getAuthor(),book.getDescription(),book.getPrice());
        return bookDto;
    }

    public static Book toBook(BookDto bookDto)
    {
        Book book = new Book(bookDto.getBookId(),bookDto.getBookName(),bookDto.getAuthor(),bookDto.getDescription(),bookDto.getPrice());
        return book;
    }

}
