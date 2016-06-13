package domain;

public class Book {

    private Integer id;

    public void rate(Rating rating) {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean hasId(Integer bookId) {
        return id.compareTo(bookId) == 0;
    }
}
