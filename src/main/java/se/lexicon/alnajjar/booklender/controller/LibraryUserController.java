package se.lexicon.alnajjar.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.alnajjar.booklender.dto.LibraryUserDto;
import se.lexicon.alnajjar.booklender.service.LibraryUserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/libraryUser")
public class LibraryUserController {

    LibraryUserService libraryUserService;

    @Autowired
    public LibraryUserController(LibraryUserService libraryUserService) {
        this.libraryUserService = libraryUserService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<LibraryUserDto> findById(@PathVariable("userId") int userId) {
        System.out.println(" UserId = " + userId);
        LibraryUserDto libraryUserDto = libraryUserService.findById(userId);
        return ResponseEntity.ok(libraryUserDto);
    }

    @GetMapping("/{email}")
    public ResponseEntity<LibraryUserDto> findByEmail(@PathVariable("email") String email) {
        System.out.println(" Email =" + email);
        LibraryUserDto libraryUserDto = libraryUserService.findByEmail(email);
        return ResponseEntity.ok(libraryUserDto);
    }

    @GetMapping("/")
    public ResponseEntity<List<LibraryUserDto>> findAll() {
        List<LibraryUserDto> libraryUserDto = libraryUserService.findAll();
        return ResponseEntity.ok(libraryUserDto);
    }

    @PostMapping("/")
    public ResponseEntity<LibraryUserDto> create(@RequestBody @Valid LibraryUserDto dto) {
        System.out.println("dto.toString() = " + dto.toString());
        LibraryUserDto userDto = libraryUserService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @PutMapping("/")
    public ResponseEntity<LibraryUserDto> update(@RequestBody LibraryUserDto dto) {
        LibraryUserDto libraryUserDto = libraryUserService.update(dto);
        return ResponseEntity.ok(libraryUserDto);
    }
}
