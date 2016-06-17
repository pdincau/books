package infrastructure.rest;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CreationRequest {

    private String title;
    private String author;
    private String isbn;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
