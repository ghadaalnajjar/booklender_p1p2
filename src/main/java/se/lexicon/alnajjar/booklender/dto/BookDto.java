package se.lexicon.alnajjar.booklender.dto;

import java.math.BigDecimal;

public class BookDto {
    private int bookId;
    private String title;
    private boolean available;
    private boolean reserved;
    private int maxLoansDays;
    private BigDecimal finePerDay;
    private String description;

    public BookDto() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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
    public String toString() {
        return "BookDto{" +
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
