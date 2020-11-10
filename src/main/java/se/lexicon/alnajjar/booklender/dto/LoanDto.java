package se.lexicon.alnajjar.booklender.dto;

import se.lexicon.alnajjar.booklender.entity.Book;
import se.lexicon.alnajjar.booklender.entity.LibraryUser;

import java.time.LocalDate;

public class LoanDto {
    private long loanId;
    private LibraryUser loanTaker;
    private Book book;
    private LocalDate loanDate;
    private boolean terminate;

    public LoanDto() {
    }

    public LoanDto(long loanId, LibraryUser loanTaker, Book book, LocalDate loanDate, boolean terminate) {
        this.loanId = loanId;
        this.loanTaker = loanTaker;
        this.book = book;
        this.loanDate = loanDate;
        this.terminate = terminate;
    }

    public LoanDto(long loanId, LocalDate loanDate, boolean terminate) {
        this.loanId = loanId;
        this.loanDate = loanDate;
        this.terminate = terminate;
    }

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
    }

    public LibraryUser getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUser loanTaker) {
        this.loanTaker = loanTaker;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public boolean isTerminate() {
        return terminate;
    }

    public void setTerminate(boolean terminate) {
        this.terminate = terminate;
    }

    @Override
    public String toString() {
        return "LoanDto{" +
                "loanId=" + loanId +
                ", loanTaker=" + loanTaker +
                ", book=" + book +
                ", loanDate=" + loanDate +
                ", terminate=" + terminate +
                '}';
    }
}
