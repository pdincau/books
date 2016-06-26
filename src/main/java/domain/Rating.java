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

    public Boolean isValid() {
        return (rate >= 0) && (rate <= 5);
    }

    public Integer getRate() {
        return rate;
    }

    public String getDescription() {
        return description;
    }

    public String getUserId() {
        return userId;
    }

}
