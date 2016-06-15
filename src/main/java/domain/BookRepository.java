package domain;

import infrastructure.persistence.InMemoryEventStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookRepository {

    static final Logger LOG = LoggerFactory.getLogger(BookRepository.class);

    private EventStore eventStore;

    public BookRepository() {
        this(InMemoryEventStore.getInstance());
    }

    public BookRepository(EventStore eventStore) {
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
