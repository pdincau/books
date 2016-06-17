package infrastructure.queue;

import domain.EventPublisher;
import domain.events.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RabbitMQEventPublisher implements EventPublisher {

    static final Logger LOG = LoggerFactory.getLogger(RabbitMQEventPublisher.class);

    @Override
    public void publish(Event event) {
        LOG.info("Publishing event: {}", event);
    }
}
