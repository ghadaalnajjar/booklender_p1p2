package se.lexicon.alnajjar.booklender.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.alnajjar.booklender.dto.BookDto;
import se.lexicon.alnajjar.booklender.entity.Book;
import se.lexicon.alnajjar.booklender.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    ModelMapper mapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ModelMapper mapper) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    @Override
    public List<BookDto> findByReserved(boolean reserved) {
        List<Book> bookList = bookRepository.findByReserved(reserved);
        return bookList.stream().map(book -> mapper.map(book, BookDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByAvailable(boolean available) {
        List<Book> bookList = bookRepository.findByAvailable(available);
        return bookList.stream().map(book -> mapper.map(book, BookDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> findByTitle(String title) {
        List<Book> bookList = bookRepository.findByTitle(title);
        return bookList.stream().map(book -> mapper.map(book, BookDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookDto findById(int bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            return mapper.map(book, BookDto.class);
        }
        return null;
    }

    @Override
    public List<BookDto> findAll() {
       // List<Book> bookList = (List<Book>) bookRepository.findAll();
       // return bookList.stream().map(book -> mapper.map(book, BookDto.class)).collect(Collectors.toList());

        List<Book> bookList = (List<Book>) bookRepository.findAll(); //this is another basic solution
        List<BookDto> bookDtoList = new ArrayList<>();
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);

            BookDto bookDto = mapper.map(book, BookDto.class);
            bookDtoList.add(bookDto);
        }
        return bookDtoList;
    }

    @Override
    public BookDto create(BookDto bookDto) {
        Book entityBook = mapper.map(bookDto, Book.class);
        Book savedBook = bookRepository.save(entityBook);
        return mapper.map(savedBook, BookDto.class);
    }

    @Override
    public BookDto update(BookDto bookDto) {
        Book entityBook = mapper.map(bookDto, Book.class);
        Book savedBook =bookRepository.save(entityBook);
        return mapper.map(savedBook, BookDto.class);
    }

    @Override
    public boolean delete(int bookId) {
        bookRepository.deleteById(bookId);
        return true;
    }
}
