package domain.events;

import domain.Book;

public abstract class Event {

    public abstract void mutate(Book book);

    protected final String id;

    public Event(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
