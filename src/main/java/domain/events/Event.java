package domain.events;

public abstract class Event {

    protected final String id;

    public Event(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
