package infrastructure.queue;

import java.io.IOException;

public class Producer extends EndPoint {

    public Producer(String endPointName) throws IOException {
        super(endPointName);
    }

    public void sendMessage(String object, String topic) throws IOException {
        channel.basicPublish(endPointName, topic, null, object.getBytes());
    }
}