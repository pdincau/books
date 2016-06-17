package domain;

public class NullBook extends Book {

    @Override
    public void create(String id, String title, String author, String isbn) {
        throw new RuntimeException();
    }
    
    @Override
    public void rate(Rating rating) {
        throw new RuntimeException();
    }
}
