package infrastructure.persistence;

import domain.Event;
import domain.EventStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class InMemoryEventStore implements EventStore {

    static final Logger LOG = LoggerFactory.getLogger(InMemoryEventStore.class);

    private static InMemoryEventStore instance = null;

    List<Event> events;

    public static InMemoryEventStore getInstance() {
        if(instance == null) {
            instance = new InMemoryEventStore();
        }
        return instance;
    }

    public InMemoryEventStore() {
        events = new ArrayList<>();
    }

    @Override
    public void save(Event event) {
        LOG.info("Saving event: {}", event);
        events.add(event);
    }

    @Override
    public List<Event> findBy(String id) {
        LOG.info("Reading events for id: {}", id);
        return events.stream().filter(e -> id.equals(e.getId())).collect(toList());
    }
}
