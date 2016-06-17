package actions;

import domain.Book;
import domain.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BooksActionHandler {

    static final Logger LOG = LoggerFactory.getLogger(BooksActionHandler.class);

    BookRepository repository;

    public BooksActionHandler() {
        this(new BookRepository());
    }

    public BooksActionHandler(BookRepository repository) {
        this.repository = repository;
    }

    public void handle(AddBook action) {
        LOG.info("Handle command: {}", action);
        Book book = new Book();
        book.create(action.getBookId(), action.getTitle(), action.getAuthor(), action.getIsbn());
    }

    public void handle(RateBook action) {
        LOG.info("Handle command: {}", action);
        Book book = repository.findBy(action.getBookId());
        book.rate(action.getRating());
    }
}
