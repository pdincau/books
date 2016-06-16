package domain;

public class NullBook extends Book {

    @Override
    public void create(String id) {
        throw new RuntimeException();
    }

    @Override
    public void rate(Rating rating) {
        throw new RuntimeException();
    }
}
