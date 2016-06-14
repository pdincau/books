import actions.AddBook;
import actions.RateBook;
import actions.BooksActionHandler;
import com.spotify.apollo.Environment;
import com.spotify.apollo.RequestContext;
import com.spotify.apollo.Response;
import com.spotify.apollo.httpservice.HttpService;
import com.spotify.apollo.httpservice.LoadingException;
import com.spotify.apollo.route.Route;
import domain.Rating;
import okio.ByteString;

import static com.spotify.apollo.Status.CREATED;


public class Apollo {

    private static String BOOK_ID = "any isbn";
    private static BooksActionHandler actiondHandler = new BooksActionHandler();

    public static void main(String[] args) throws LoadingException {
        HttpService.boot(Apollo::init, "apollo", args);
    }

    static void init(Environment environment) {
        environment.routingEngine()
                .registerAutoRoute(Route.sync("GET", "/books/add", Apollo::addBook))
                .registerAutoRoute(Route.sync("GET", "/books/<id>/rate", Apollo::rateBook));
    }

    private static Response<ByteString> addBook(RequestContext context)  {
        actiondHandler.handle(new AddBook(BOOK_ID));
        return Response.forStatus(CREATED);
    }

    private static Response<ByteString> rateBook(RequestContext context)  {
        String id = context.pathArgs().get("id")
        Rating rating = new Rating("a description", 5, "a user id");
        actiondHandler.handle(new RateBook(id, rating));
        return Response.forStatus(CREATED);
    }
}
