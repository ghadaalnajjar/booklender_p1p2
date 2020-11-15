package se.lexicon.alnajjar.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.alnajjar.booklender.entity.LibraryUser;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryUserRepository extends CrudRepository<LibraryUser, Integer> {

    List<LibraryUser> findByEmail(String email);

    Optional<LibraryUser> findByEmailIgnoreCase(String email);
}
