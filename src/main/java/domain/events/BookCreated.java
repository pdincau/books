package domain.events;

import domain.Book;

public class BookCreated extends Event {

    public BookCreated(String bookId) {
        super(bookId);
    }

    @Override
    public void mutate(Book book) {
        book.setId(id);
    }
}
