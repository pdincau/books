package actions;

import domain.Book;
import infrastructure.InMemoryBookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BooksActiondHandler {

    static final Logger LOG = LoggerFactory.getLogger(BooksActiondHandler.class);

    BookRepository repository;

    public BooksActiondHandler() {
        this(new InMemoryBookRepository());
    }

    public BooksActiondHandler(BookRepository repository) {
        this.repository = repository;
    }

    public void handle(AddBook action) {
        LOG.info("Handle command: {}", action);
        repository.save(action.getBook());
    }

    public void handle(RateBook action) {
        LOG.info("Handle command: {}", action);
        Book book = repository.find(action.getBookId());
        book.rate(action.getRating());
    }
}
