package se.lexicon.alnajjar.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.alnajjar.booklender.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByReserved (boolean reserved);

    List<Book> findByAvailable (boolean available);

    List<Book> findByTitle (String title);
}
