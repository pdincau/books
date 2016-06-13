package actions;

import domain.Rating;

public class RateBook {

    private Integer bookId;
    private final Rating rating;

    public RateBook(Integer bookId, Rating rating) {
        this.bookId = bookId;
        this.rating = rating;
    }

    public Rating getRating() {
        return rating;
    }

    public Integer getBookId() {
        return bookId;
    }
}
