package se.lexicon.alnajjar.booklender.service;

import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.alnajjar.booklender.dto.LibraryUserDto;
import se.lexicon.alnajjar.booklender.entity.LibraryUser;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryUserServiceUnitTest {

    @Autowired

    private LibraryUserDto libraryUserDto;

    private ModelMapper mapper = new ModelMapper();

    private LibraryUser libraryUser = new LibraryUser();

    @Test
    public void create() {
        libraryUser.setRegDate(LocalDate.now());
        libraryUser.setName("Maha");
        libraryUser.setEmail("t@yahoo.com");

        LibraryUserDto libraryUserDto = mapper.map(libraryUser, LibraryUserDto.class);

        libraryUser.setRegDate(LocalDate.now());
        assertEquals(libraryUser.getName(), libraryUserDto.getName());
        assertEquals(libraryUser.getEmail(), libraryUserDto.getEmail());
    }

    @Test
    public void findByName() {
        libraryUserDto = mapper.map(libraryUser, LibraryUserDto.class);
        assertEquals(libraryUserDto.getName(), libraryUser.getName());
    }

    @Test
    public void findById() {
        libraryUserDto = mapper.map(libraryUser, LibraryUserDto.class);
        assertEquals(libraryUserDto.getUserId(), libraryUser.getUserId());
    }

    @Test
    public void findByEmail() {
        libraryUserDto = mapper.map(libraryUser, LibraryUserDto.class);
        assertEquals(libraryUserDto.getEmail(), libraryUser.getEmail());
    }
  }

