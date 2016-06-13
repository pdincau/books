package actions;

public class RateBook {

    private final String bookId;
    private final String description;
    private final Integer rate;
    private String userId;

    public RateBook(String bookId, String description, Integer rate, String userId) {
        this.bookId = bookId;
        this.description = description;
        this.rate = rate;
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public Integer getRate() {
        return rate;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getUserId() {
        return userId;
    }
}
