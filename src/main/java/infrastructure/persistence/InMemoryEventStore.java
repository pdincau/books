package infrastructure.persistence;

import domain.EventPublisher;
import domain.events.Event;
import domain.EventStore;
import infrastructure.queue.RabbitMQEventPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class InMemoryEventStore implements EventStore {

    private static final Logger LOG = LoggerFactory.getLogger(InMemoryEventStore.class);

    private static InMemoryEventStore instance = null;
    private final EventPublisher eventPublisher;

    private List<Event> events;

    public static InMemoryEventStore getInstance() {
        if(instance == null) {
            instance = new InMemoryEventStore();
        }
        return instance;
    }

    private InMemoryEventStore() {
        this(new RabbitMQEventPublisher());
    }

    private InMemoryEventStore(EventPublisher eventPublisher) {
        this.events = new ArrayList<>();
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void save(Event event) {
        LOG.info("Saving event: {}", event);
        events.add(event);
        eventPublisher.publish(event);
    }

    @Override
    public List<Event> findBy(String id) {
        LOG.info("Reading events for id: {}", id);
        return events.stream().filter(e -> id.equals(e.getId())).collect(toList());
    }
}
