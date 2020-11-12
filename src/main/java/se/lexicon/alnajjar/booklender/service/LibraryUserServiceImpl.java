package se.lexicon.alnajjar.booklender.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.alnajjar.booklender.dto.LibraryUserDto;
import se.lexicon.alnajjar.booklender.entity.LibraryUser;
import se.lexicon.alnajjar.booklender.repository.LibraryUserRepository;

import java.util.List;
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
        return mapper.map(findById(userId), LibraryUserDto.class);
    }

    @Override
    public LibraryUserDto findByEmail(String email) {
        if (email == null || email.trim().length() <= 1){
            throw new IllegalArgumentException("Email cannot be null");
        }
        List<LibraryUser> libraryUser = libraryUserRepository.findByEmail(email);
        if (libraryUser.isEmpty()) {
            LibraryUserDto libraryUserDto = mapper.map(libraryUser.get(1), LibraryUserDto.class);
            return libraryUserDto;
        } else {
            throw new IllegalArgumentException("Email :["+email+"] Dose not exist");
        }
    }

    @Override
    public List<LibraryUserDto> findAll() {
        List<LibraryUser> bookList = (List<LibraryUser>) libraryUserRepository.findAll();
        //stream get object - mapper
        List<LibraryUserDto> bookDtoList = bookList.stream().map(libraryUser -> mapper.map(libraryUserRepository ,LibraryUserDto.class)).collect(Collectors.toList());
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
        return mapper.map(libraryUserDto.getUserId(), LibraryUserDto.class);
    }

    @Override
    public boolean delete(int userId) {
        mapper.map(delete(userId), LibraryUserDto.class);
        return false;
    }
}
