package domain;

public class NullBook extends Book {

    @Override
    public void create(String id, BookDetail detail) {
        throw new RuntimeException();
    }

    @Override
    public void rate(Rating rating) {
        throw new RuntimeException();
    }
}
