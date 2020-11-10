package se.lexicon.alnajjar.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.alnajjar.booklender.entity.*;
import se.lexicon.alnajjar.booklender.entity.Loan;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

   List<Loan> findByLoanTakerUserId (int userId);

   Loan findByBookBookId (int bookId);

   List<Loan> findByTerminate (boolean terminate);
}
