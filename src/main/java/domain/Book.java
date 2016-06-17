package domain;

import domain.events.BookCreated;
import domain.events.BookRated;
import domain.events.Event;
import infrastructure.persistence.InMemoryEventStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Book {

    static final Logger LOG = LoggerFactory.getLogger(Book.class);

    private String id;
    private Integer rate;
    private List<Event> events;

    private InMemoryEventStore eventStore = InMemoryEventStore.getInstance();

    public Book() {
        this.rate = 0;
        this.events = new ArrayList<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void create(String id) {
        applyNewEvent(new BookCreated(id));
    }

    public void rate(Rating rating) {
        if (rating.hasCorrectValue()) {
            applyNewEvent(new BookRated(id, rating.getRate(), rating.getDescription(), rating.getUserId()));
        }
    }

    public void replay(List<Event> events) {
        LOG.info("Replaying: {} events", events.size());
        events.forEach(event -> applyEvent(event));
    }

    private void applyNewEvent(Event event) {
        applyEvent(event);
        eventStore.save(event);
    }

    private void applyEvent(Event event) {
        LOG.info("Applying event: {}", event);
        event.mutate(this);
        events.add(event);
    }

}
