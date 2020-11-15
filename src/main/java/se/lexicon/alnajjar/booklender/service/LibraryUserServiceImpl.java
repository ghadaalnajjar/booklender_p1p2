package se.lexicon.alnajjar.booklender.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.alnajjar.booklender.dto.LibraryUserDto;
import se.lexicon.alnajjar.booklender.entity.LibraryUser;
import se.lexicon.alnajjar.booklender.repository.LibraryUserRepository;

import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibraryUserServiceImpl implements LibraryUserService {

    LibraryUserRepository libraryUserRepository;
    ModelMapper mapper;

    @Autowired
    public LibraryUserServiceImpl(LibraryUserRepository libraryUserRepository, ModelMapper mapper) {
        this.libraryUserRepository = libraryUserRepository;
        this.mapper = mapper;
    }

    @Override
    public LibraryUserDto findById(int userId) {
        Optional<LibraryUser> libraryUser = libraryUserRepository.findById(userId);
        if (libraryUser.isPresent()) {
            return mapper.map(libraryUser, LibraryUserDto.class);
        }
        return null;
    }

    @Override
    public LibraryUserDto findByEmail(String email) {
        if (email == null || email.trim().length() <= 1) {  // used 1 not 0
            throw new IllegalArgumentException("Email cannot be null");
        }
        Optional<LibraryUser> libraryUser = libraryUserRepository.findByEmailIgnoreCase(email);
        if (libraryUser.isPresent()) {
            LibraryUserDto dto = mapper.map(libraryUser.get(), LibraryUserDto.class);
            return dto;
        } else {
            throw new IllegalArgumentException("Email :[" + email + "] Dose not exist");
        }
    }

    @Override
    public List<LibraryUserDto> findAll() {
        List<LibraryUser> bookList = (List<LibraryUser>) libraryUserRepository.findAll();
        //stream get object - mapper (this used stream)
        // List<LibraryUserDto> bookDtoList = bookList.stream().map(libraryUser -> mapper.map(libraryUser ,LibraryUserDto.class)).collect(Collectors.toList());
        //return bookDtoList;

        List<LibraryUserDto> bookDtoList = new ArrayList<>(); // this is another basic solution
        for (int i = 0; i < bookList.size(); i++) {
            LibraryUser libraryUser = bookList.get(i);

            LibraryUserDto libraryUserDto = mapper.map(libraryUser, LibraryUserDto.class);
            bookDtoList.add(libraryUserDto);
        }
        return bookDtoList;
    }

    @Override
    public LibraryUserDto create(LibraryUserDto libraryUserDto) {
        LibraryUser entityLibraryUser = mapper.map(libraryUserDto, LibraryUser.class);
        LibraryUser saveLibraryUser = libraryUserRepository.save(entityLibraryUser);
        return mapper.map(saveLibraryUser, LibraryUserDto.class);
    }

    @Override
    public LibraryUserDto update(LibraryUserDto libraryUserDto) {
        LibraryUser entityLibraryUser = mapper.map(libraryUserDto, LibraryUser.class);
        LibraryUser saveLibraryUser = libraryUserRepository.save(entityLibraryUser);
        return mapper.map(saveLibraryUser, LibraryUserDto.class);
    }

    @Override
    public boolean delete(int userId) {
        libraryUserRepository.deleteById(userId);
        return true;
    }
}
