package domain;

import org.apache.commons.lang3.StringUtils;

public class BookDetail {

    private final String title;
    private final String author;
    private final String isbn;

    public BookDetail(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public Boolean isComplete() {
        return StringUtils.isAnyEmpty(title, author, isbn);
    }
}
