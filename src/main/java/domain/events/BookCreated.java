package domain.events;

import domain.BookDetail;
import domain.Book;

public class BookCreated extends Event {

    private final BookDetail bookDetail;

    public BookCreated(String bookId, BookDetail bookDetail) {
        super(bookId);
        this.bookDetail = bookDetail;
    }

    @Override
    public void mutate(Book book) {
        book.setId(id);
        book.setDetail(bookDetail);
    }
}
