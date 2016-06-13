package infrastructure;

import actions.BookRepository;
import domain.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRepository implements BookRepository {

    List<Book> books;
    Integer sequence;

    public InMemoryBookRepository() {
        this.books = new ArrayList<>();
        this.sequence = 0;
    }

    @Override
    public Book find(Integer bookId) {
        Book book = books.stream().filter(b -> b.hasId(bookId)).findFirst().orElse(new Book());
        return book;
    }

    @Override
    public void save(Book book) {
        book.setId(sequence);
        books.add(book);
    }
}
