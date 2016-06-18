package infrastructure.queue;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
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
        LOG.info("Publishing event: {}", event);
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            EventDto eventDto = EventDtoFactory.createFrom(event);
            String message = new Gson().toJson(eventDto);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            LOG.info("Event published as json: {}", message);
            channel.close();
            connection.close();
        } catch (IOException e) {
            LOG.error("Failed while publishing event: {}", event);
        }
    }
}
