package se.lexicon.alnajjar.booklender.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.alnajjar.booklender.dto.BookDto;
import se.lexicon.alnajjar.booklender.dto.LibraryUserDto;
import se.lexicon.alnajjar.booklender.dto.LoanDto;
import se.lexicon.alnajjar.booklender.entity.Loan;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanServiceUnitTest {

    @Autowired

    private LoanDto loanDto;

    private ModelMapper mapper = new ModelMapper();

    private LoanDto testObject;
    private LibraryUserDto testLibraryUser;
    private BookDto testBook;

    private Loan loan = new Loan();


    @BeforeEach
    void setUp() {
        testLibraryUser = new LibraryUserDto();
        testBook = new BookDto();
        testObject = new LoanDto();
    }

    @Test
    public void create() {
        testObject.setLoanId(10);
        testObject.setLoanDate(LocalDate.now());
        testObject.setTerminate(false);

        LoanDto loanDto = mapper.map(loan, LoanDto.class);

        assertEquals(loan.getLoanId(), loanDto.getLoanId());
        assertEquals(loan.isTerminate(), loanDto.isTerminate());
    }

    @Test
    public void findByBookId() {
        LoanDto loanDto = mapper.map(loan, LoanDto.class);
        assertEquals(loanDto.getBook(), loan.getBook());
    }

    @Test
    public void findByUserId() {
        LoanDto loanDto = mapper.map(loan, LoanDto.class);
        assertEquals(loanDto.getLoanTaker(), loan.getLoanTaker());
    }

    @Test
    public void findByTerminate() {
        LoanDto loanDto = mapper.map(loan, LoanDto.class);
        assertEquals(loanDto.isTerminate(), loan.isTerminate());
    }
}
