package actions;

import domain.Rating;

public class RateBook {

    private final String bookId;
    private final Rating rating;

    public RateBook(String bookId, Rating rating) {
        this.bookId = bookId;
        this.rating = rating;
    }

    public Rating getRating() {
        return rating;
    }

    public String getBookId() {
        return bookId;
    }
}
