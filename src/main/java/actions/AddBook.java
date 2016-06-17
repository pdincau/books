package actions;

import domain.BookDetail;

public class AddBook {

    private final String bookId;
    private final BookDetail detail;

    public AddBook(String bookId, BookDetail detail) {
        this.bookId = bookId;
        this.detail = detail;
    }

    public String getBookId() {
        return bookId;
    }

    public BookDetail getBookDetail() {
        return detail;
    }
}
