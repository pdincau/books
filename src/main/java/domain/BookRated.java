package domain;

public class BookRated extends Event {

    private final Integer rate;
    private final String description;
    private final String userId;

    public BookRated(Integer id, Integer rate, String description, String userId) {
        super(id);
        this.rate = rate;
        this.description = description;
        this.userId = userId;
    }
}
