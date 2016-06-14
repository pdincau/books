package domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class EventStore {

    static final Logger LOG = LoggerFactory.getLogger(EventStore.class);

    private static EventStore instance = null;

    List<Event> events;

    public static EventStore getInstance() {
        if(instance == null) {
            instance = new EventStore();
        }
        return instance;
    }

    public EventStore() {
        events = new ArrayList<>();
    }

    public void save(Event event) {
        LOG.info("Saving event: {}", event);
        events.add(event);
    }

    public List<Event> findBy(String id) {
        LOG.info("Reading events for id: {}", id);
        return events.stream().filter(e -> id.equals(e.getId())).collect(toList());
    }
}
