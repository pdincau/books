package infrastructure.rest;

import domain.BookDetail;

public class DetailFactory {

    public static BookDetail from(CreationRequest request) {
        return new BookDetail(request.getTitle(), request.getAuthor(), request.getIsbn());
    }
}
