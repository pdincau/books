package domain;

import java.util.List;

public interface EventStore {

    void save(Event event);

    List<Event> findBy(String id);

}
