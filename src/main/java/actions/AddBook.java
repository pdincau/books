package actions;

public class AddBook {

    private final String title;
    private final String author;
    private final String isbn;
    private final String bookId;

    public AddBook(String bookId, String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getBookId() {
        return bookId;
    }
}
