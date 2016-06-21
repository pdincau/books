package domain.events;

import domain.Book;

public class BookRated extends Event {

    private final Integer rate;
    private final String description;
    private final String userId;

    public BookRated(String bookId, Integer rate, String description, String userId) {
        super(bookId);
        this.rate = rate;
        this.description = description;
        this.userId = userId;
    }

    @Override
    public void mutate(Book book) {
        long howManyRates = book.getEvents()
                .stream()
                .filter(event -> "BookRated".equals(event.getName()))
                .count();

        Double newRate = ((book.getRate() * howManyRates) + rate) / (howManyRates + 1);
        book.setRate(newRate);
    }

}
