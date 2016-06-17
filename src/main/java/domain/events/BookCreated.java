package domain.events;

public class BookCreated extends Event {

    public BookCreated(String bookId) {
        super(bookId);
    }
}
