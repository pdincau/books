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
    private List<Event> events;

    private InMemoryEventStore eventStore = InMemoryEventStore.getInstance();
    private List<String> reviewers;

    public static Book from(List<Event> events) {
        if (events.isEmpty()) {
            return new NullBook();
        }
        return new Book().replay(events);
    }

    public Book() {
        this.reviewers = new ArrayList<>();
        this.events = new ArrayList<>();
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
        //here i should probably contact a user service
        //what can i do to show error?
        if (rating.isValid() && doesNotHaveReviewFrom(rating.getUserId())) {
            applyNewEvent(new BookRated(id, rating.getRate(), rating.getDescription(), rating.getUserId()));
        }
    }

    public void addReviewer(String userId) {
        reviewers.add(userId);
    }

    private Boolean doesNotHaveReviewFrom(String userId) {
        return !reviewers.contains(userId);
    }

    private Book replay(List<Event> events) {
        LOG.info("Replaying: {} events", events.size());
        events.forEach(event -> applyEvent(event));
        return this;
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
