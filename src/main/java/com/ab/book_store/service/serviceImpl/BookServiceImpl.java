package com.ab.book_store.service.serviceImpl;

import com.ab.book_store.dto.BookDto;
import com.ab.book_store.entity.Book;
import com.ab.book_store.exception.BookNotFoundException;
import com.ab.book_store.mapper.BookMapper;
import com.ab.book_store.repository.BookRepository;
import com.ab.book_store.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    @Override
    public List<BookDto> getAllBooks() {
        List<BookDto> Books = new ArrayList<>();
        List<Book> AllBooks = new ArrayList<>();
        AllBooks = bookRepository.findAll();
        for(Book book:AllBooks){
            Books.add(BookMapper.toDto(book));
        }
        return Books;
    }

    @Override
    public BookDto getBookById(String bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Requested Book does not exist"));

        return BookMapper.toDto(book);
    }

    @Override
    public BookDto createBook(BookDto bookDto) {

        bookRepository.save(BookMapper.toBook(bookDto));
        Optional<Book> book = bookRepository.findById(bookDto.getBookId());
        return BookMapper.toDto(book.orElse(null));
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        bookRepository.save(BookMapper.toBook(bookDto));
        Optional<Book> book = bookRepository.findById(bookDto.getBookId());
        return BookMapper.toDto(book.orElse(null));
    }

    @Override
    public void deleteBookById(String bookId) {
        bookRepository.deleteById(bookId);
    }
}
