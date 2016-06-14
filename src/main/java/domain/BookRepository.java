package domain;

import domain.Book;

public interface BookRepository {

    Book find(Integer bookId);

    void save(Book book);
}
