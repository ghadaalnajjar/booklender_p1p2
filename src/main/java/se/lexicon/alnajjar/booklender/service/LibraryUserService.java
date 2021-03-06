package se.lexicon.alnajjar.booklender.service;

import se.lexicon.alnajjar.booklender.dto.LibraryUserDto;

import java.util.List;

public interface LibraryUserService {

    LibraryUserDto findById (int userId);

    LibraryUserDto findByEmail (String email);

    List<LibraryUserDto> findAll();

    LibraryUserDto create (LibraryUserDto libraryUserDto);

    LibraryUserDto update (LibraryUserDto libraryUserDto);

    boolean delete (int userId);
}
