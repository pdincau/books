package infrastructure;

import domain.IdGenerator;

public class DummyIdGenerator implements IdGenerator {

    int counter;

    public DummyIdGenerator() {
        this.counter = 0;
    }

    @Override
    public String nextId() {
        counter++;
        return String.valueOf(counter);
    }
}
