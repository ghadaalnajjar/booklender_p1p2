package se.lexicon.alnajjar.booklender.service;

import se.lexicon.alnajjar.booklender.dto.LoanDto;

import java.util.List;

public interface LoanService {

    LoanDto findById (long loanId);

    List<LoanDto> findByBookId (int bookId);

    List<LoanDto> findByUserId (int userId);

    List<LoanDto> findByTerminate (boolean terminate);

    List<LoanDto> findAll();

    LoanDto create (LoanDto loandto);

    LoanDto update (LoanDto loanDto);

    boolean delete (long loanId);
}
