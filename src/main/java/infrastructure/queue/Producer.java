package infrastructure.queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public class Producer {

    private Channel channel;
    private String endPointName;

    public Producer(String endpointName) throws IOException {
        this.endPointName = endpointName;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        channel = connection.createChannel();
        channel.exchangeDeclare(endpointName, "direct");
    }

    public void sendMessage(String object, String topic) throws IOException {
        channel.basicPublish(endPointName, topic, null, object.getBytes());
    }
}