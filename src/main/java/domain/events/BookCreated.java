package domain.events;

import domain.Book;

public class BookCreated extends Event {

    private final String title;
    private final String author;
    private final String isbn;

    public BookCreated(String bookId, String title, String author, String isbn) {
        super(bookId);
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public void mutate(Book book) {
        book.setId(id);
        book.setTitle(title);
        book.setAuthor(title);
        book.setIsbn(isbn);
    }
}
