package domain.events;

import domain.Book;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
        long howManyRates = book.getEvents().stream()
                .filter(event -> "BookRated".equals(event.getName()))
                .count();

        Double newRate = ((book.getRate() * howManyRates) + rate) / (howManyRates + 1);
        book.setRate(newRate);
    }

}
