package domain.events;

import domain.Book;

public class BookRated extends Event {

    private final Integer rate;
    private final String description;
    private final String userId;

    public BookRated(String bookId, Integer rate, String description, String userId) {
        super(bookId);
        this.rate = rate;
        this.description = description;
        this.userId = userId;
    }

    @Override
    public void mutate(Book book) {
        book.addReviewer(userId);
    }

}
