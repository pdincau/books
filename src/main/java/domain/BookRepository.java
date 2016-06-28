package domain;

import domain.events.Event;
import infrastructure.persistence.InMemoryEventStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
        LOG.info("Findind book with id: {}", bookId);
        List<Event> events = eventStore.findBy(bookId);
        return Book.from(events);
    }

}
