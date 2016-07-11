package actions;

import domain.Book;
import domain.BookRepository;
import domain.IdGenerator;
import infrastructure.DummyIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BooksActionHandler {

    static final Logger LOG = LoggerFactory.getLogger(BooksActionHandler.class);

    private BookRepository repository;
    private IdGenerator idGenerator;

    public BooksActionHandler() {
        this(new BookRepository(), new DummyIdGenerator());
    }

    public BooksActionHandler(BookRepository repository, IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public void handle(AddBook action) {
        LOG.info("Handling command: {}", action);
        Book book = new Book();
        book.create(idGenerator.nextId(), action.getBookDetail());
    }

    public void handle(RateBook action) {
        LOG.info("Handling command: {}", action);
        Book book = repository.findBy(action.getBookId());
        book.rate(action.getRating());
    }
}
