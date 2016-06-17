package infrastructure.rest;

import domain.Rating;

public class RatingFactory {

    public static Rating from(RateRequest request) {
        return new Rating(request.getDescription(), request.getRate(), request.getUserId());
    }
}
