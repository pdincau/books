package actions;

import domain.Book;
import infrastructure.InMemoryBookRepository;

public class BooksActiondHandler {

    BookRepository repository;

    public BooksActiondHandler() {
        this(new InMemoryBookRepository());
    }

    public BooksActiondHandler(BookRepository repository) {
        this.repository = repository;
    }

    public void handle(AddBook action) {
        repository.save(action.getBook());
    }

    public void handle(RateBook action) {
        Book book = repository.find(action.getBookId());
        book.rate(action.getRating());
    }
}
