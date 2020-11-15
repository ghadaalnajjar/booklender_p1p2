package se.lexicon.alnajjar.booklender.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class BookDto {
    private int bookId;
    @NotNull(message = "'name' cannot be null")
    @Size(min = 2,max = 40)
    private String title;
    private boolean available;
    private boolean reserved;
    @Min(value = 30,message = " 'maxLoansDays' must be grater than 30")
    private int maxLoansDays;
    private BigDecimal finePerDay;
    @NotNull(message = "'name' cannot be null")
    @Size(min = 2,max = 40)
    private String description;

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
