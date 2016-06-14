package infrastructure;

import domain.BookRepository;
import domain.Book;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InMemoryBookRepository implements BookRepository {

    static final Logger LOG = LoggerFactory.getLogger(InMemoryBookRepository.class);

    List<Book> books;
    Integer sequence;

    public InMemoryBookRepository() {
        this.books = new ArrayList<>();
        this.sequence = 1;
    }

    @Override
    public Book find(Integer bookId) {
        LOG.info("Find book with id: {}", bookId);
        return books.stream().filter(b -> b.hasId(bookId)).findFirst().orElse(new Book());
    }

    @Override
    public void save(Book book) {
        LOG.info("Save book using id: {}", sequence);
        book.setId(nextId());
        books.add(book);
    }

    Integer nextId() {
        return sequence++;
    }
}
