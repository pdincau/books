package domain;

public class Rating {

    private final String description;
    private final Integer rate;
    private final String userId;

    public Rating(String description, Integer rate, String userId) {
        this.description = description;
        this.rate = rate;
        this.userId = userId;
    }

    public Boolean inRange() {
        return (rate >= 0) && (rate <= 5);
    }
}
