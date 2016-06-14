package domain;

import infrastructure.InMemoryEventStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookRepository {

    static final Logger LOG = LoggerFactory.getLogger(BookRepository.class);

    private InMemoryEventStore eventStore;

    public BookRepository() {
        this(InMemoryEventStore.getInstance());
    }

    public BookRepository(InMemoryEventStore eventStore) {
        this.eventStore = eventStore;
    }

    public Book findBy(String bookId) {
        LOG.info("Find book with id: {}", bookId);
        Book book = new Book();
        book.setId(bookId);
        book.replay(eventStore.findBy(bookId));
        return book;
    }

}
