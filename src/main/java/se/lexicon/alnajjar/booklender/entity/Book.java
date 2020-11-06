package se.lexicon.alnajjar.booklender.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String title;
    private boolean available;
    private boolean reserved;
    private int maxLoansDays;
    private BigDecimal finePerDay;
    private String description;

    public Book() {
    }

    public Book(String title, int maxLoansDays, BigDecimal finePerDay, String description) {
        this.title = title;
        this.maxLoansDays = maxLoansDays;
        this.finePerDay = finePerDay;
        this.description = description;
    }

    public Book(int bookId, String title, boolean available, boolean reserved, int maxLoansDays, BigDecimal finePerDay, String description) {
        this.bookId = bookId;
        this.title = title;
        this.available = available;
        this.reserved = reserved;
        this.maxLoansDays = maxLoansDays;
        this.finePerDay = finePerDay;
        this.description = description;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getMaxLoansDays() {
        return maxLoansDays;
    }

    public void setMaxLoansDays(int maxLoansDays) {
        this.maxLoansDays = maxLoansDays;
    }

    public BigDecimal getFinePerDay() {
        return finePerDay;
    }

    public void setFinePerDay(BigDecimal finePerDay) {
        this.finePerDay = finePerDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId &&
                available == book.available &&
                reserved == book.reserved &&
                maxLoansDays == book.maxLoansDays &&
                Objects.equals(title, book.title) &&
                Objects.equals(finePerDay, book.finePerDay) &&
                Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, available, reserved, maxLoansDays, finePerDay, description);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", available=" + available +
                ", reserved=" + reserved +
                ", maxLoansDays=" + maxLoansDays +
                ", finePerDay=" + finePerDay +
                ", description='" + description + '\'' +
                '}';
    }
}
