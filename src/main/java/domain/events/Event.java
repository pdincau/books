package domain.events;

import domain.Book;

import java.util.Date;

public abstract class Event {

    protected final String id;
    private final Date date;
    
    public abstract void mutate(Book book);

    public Event(String id) {
        this.id = id;
        this.date = new Date();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return getClass().getSimpleName();
    }
}
