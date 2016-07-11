package actions;

import domain.BookDetail;

public class AddBook {

    private final BookDetail detail;

    public AddBook(BookDetail detail) {
        this.detail = detail;
    }

    public BookDetail getBookDetail() {
        return detail;
    }
}
