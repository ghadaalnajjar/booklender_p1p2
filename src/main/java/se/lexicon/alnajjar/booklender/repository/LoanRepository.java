package se.lexicon.alnajjar.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.alnajjar.booklender.entity.Book;
import se.lexicon.alnajjar.booklender.entity.LibraryUser;
import se.lexicon.alnajjar.booklender.entity.Loan;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

   Loan findByLoanTakerUserId (int userId);

   Loan findByBookBookId (int bookId);

   List<Loan> findByTerminate (boolean terminate);
}
