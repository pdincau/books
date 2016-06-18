package infrastructure.queue;

import java.io.IOException;

public class Producer extends EndPoint {

    public Producer(String endPointName) throws IOException {
        super(endPointName);
    }

    public void sendMessage(String object) throws IOException {
        channel.basicPublish("", endPointName, null, object.getBytes());
    }
}