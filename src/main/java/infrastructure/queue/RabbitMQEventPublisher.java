package infrastructure.queue;

import com.google.gson.Gson;
import domain.EventPublisher;
import domain.events.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RabbitMQEventPublisher implements EventPublisher {

    static final Logger LOG = LoggerFactory.getLogger(RabbitMQEventPublisher.class);

    private final static String QUEUE_NAME = "book_events";

    @Override
    public void publish(Event event) {
        try {
            LOG.info("Publishing event: {}", event);
            Producer producer = new Producer(QUEUE_NAME);
            EventDto eventDto = EventDtoFactory.createFrom(event);
            String message = new Gson().toJson(eventDto);
            producer.sendMessage(message);
            LOG.info("Event published as json: {}", message);
        } catch (IOException e) {
            LOG.error("Failed while publishing event: {}", event);
        }
    }
}
