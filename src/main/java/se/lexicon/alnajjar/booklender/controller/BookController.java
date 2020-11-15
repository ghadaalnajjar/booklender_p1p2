package se.lexicon.alnajjar.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.alnajjar.booklender.dto.BookDto;
import se.lexicon.alnajjar.booklender.service.BookService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private List<BookDto> books = new ArrayList<>();

    private BookService bookService;

    private BookDto bookDto;

    @Autowired
    public void BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/")
    public ResponseEntity<BookDto> create(@RequestBody @Valid BookDto dto) {
        if (bookDto == null) {
            throw new IllegalArgumentException("Book can't be null");
        }
        System.out.println("dto.toString() = " + dto.toString());
        BookDto bookDto = bookService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDto);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> findById(@PathVariable("bookId") int bookId) {
        BookDto bookDto = bookService.findById(bookId);
        return ResponseEntity.ok(bookDto);   // another solution
        }

    @GetMapping("/")
    public ResponseEntity<List<BookDto>> findAll() {
        List<BookDto> bookDtoList = bookService.findAll();
        return ResponseEntity.ok(bookDtoList);
    }

    // http://localhost:8080/api/student/search?title=test
    @GetMapping("/search")
    public ResponseEntity <List<BookDto>> findBy_Title_Available_Reserved_Description(@RequestParam (value ="title", defaultValue = "none") String title,
                                                                           @RequestParam (value= "available", required = false, defaultValue = "true") boolean available,
                                                                           @RequestParam (value = "maxLoansDays", defaultValue = "none") int maxLoansDays,
                                                                           @RequestParam (value = "description", defaultValue = "none") String description) {

        System.out.println(" title = " + title);
        System.out.println(" available = " + available);
        System.out.println(" maxLoansDays = " + maxLoansDays);
        System.out.println(" description = " + description);

        if (!title.equalsIgnoreCase("none")) { //search by Title
            List<BookDto> dtoList = books.stream().filter(dto -> dto.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        } else if (!available == false) {  //search by Available
            return ResponseEntity.ok().build();
        } else if (maxLoansDays == 30) {
            return ResponseEntity.notFound().build(); //search by maxLoansDays
        } else if (!description.equalsIgnoreCase("none")) { //search by Description
            List<BookDto> dtoList = books.stream().filter(dto -> dto.getDescription().equalsIgnoreCase(description)).collect(Collectors.toList());
            return ResponseEntity.ok(dtoList);
        } else {
            throw new IllegalArgumentException("Parameters are not valid");
            }
        }

    @PutMapping("/")
    public ResponseEntity<BookDto> update(@RequestBody BookDto dto) {
        BookDto bookDto = bookService.update(dto);
        return ResponseEntity.ok(bookDto);
    }
}
