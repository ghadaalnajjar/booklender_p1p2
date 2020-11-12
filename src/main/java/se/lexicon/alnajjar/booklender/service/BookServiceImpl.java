package se.lexicon.alnajjar.booklender.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.alnajjar.booklender.dto.BookDto;
import se.lexicon.alnajjar.booklender.entity.Book;
import se.lexicon.alnajjar.booklender.repository.BookRepository;

import java.util.List;
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
        List<Book> bookList = (List<Book>) bookRepository.findByReserved(reserved);
        List<BookDto> bookDtoList = bookList.stream().map(book -> mapper.map(bookRepository, BookDto.class)).collect(Collectors.toList());
        return bookDtoList;
    }

    @Override
    public List<BookDto> findByAvailable(boolean available) {
        List<Book> bookList = (List<Book>) bookRepository.findByAvailable(available);
        List<BookDto> bookDtoList = bookList.stream().map(book -> mapper.map(bookRepository, BookDto.class)).collect(Collectors.toList());
        return bookDtoList;
    }

    @Override
    public List<BookDto> findByTitle(String title) {
        List<Book> bookList = (List<Book>) bookRepository.findByTitle(title);
        List<BookDto> bookDtoList = bookList.stream().map(book -> mapper.map(bookRepository, BookDto.class)).collect(Collectors.toList());
        return bookDtoList;
    }

    @Override
    public BookDto findById(int bookId) {
        return mapper.map(findById(bookId), BookDto.class);
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> bookList = (List<Book>) bookRepository.findAll();
        //stream get object - mapper
        List<BookDto> bookDtoList = bookList.stream().map(book -> mapper.map(bookRepository, BookDto.class)).collect(Collectors.toList());
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
        return mapper.map(bookDto.getBookId(), BookDto.class);
    }

    @Override
    public boolean delete(int bookId) {
        mapper.map(delete(bookId), BookDto.class);
        return true;
    }
}
