package actions;

import domain.Book;

public class AddBook {

    private Book book;

    public AddBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
