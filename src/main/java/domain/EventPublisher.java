package domain;

import domain.events.Event;

public interface EventPublisher {

    void publish(Event event);
}
