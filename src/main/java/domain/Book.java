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
    private BookDetail detail;
    private Double rate;
    private List<Event> events;

    private InMemoryEventStore eventStore = InMemoryEventStore.getInstance();

    public Book() {
        this.rate = 0.0;
        this.events = new ArrayList<>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDetail(BookDetail detail) {
        this.detail = detail;
    }

    public void create(String id, BookDetail detail) {
        if (detail.isComplete()) {
            applyNewEvent(new BookCreated(id, detail));
        }
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
