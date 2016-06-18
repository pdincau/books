import actions.AddBook;
import actions.BooksActionHandler;
import actions.RateBook;
import com.google.gson.Gson;
import com.spotify.apollo.Environment;
import com.spotify.apollo.RequestContext;
import com.spotify.apollo.Response;
import com.spotify.apollo.httpservice.HttpService;
import com.spotify.apollo.httpservice.LoadingException;
import com.spotify.apollo.route.Route;
import domain.BookDetail;
import infrastructure.rest.CreationRequest;
import infrastructure.rest.DetailFactory;
import infrastructure.rest.RateRequest;
import domain.Rating;
import infrastructure.rest.RatingFactory;
import okio.ByteString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.spotify.apollo.Status.CREATED;

public class Books {

    private static final String BOOK_ID = "anybookid";

    private static final Logger LOG = LoggerFactory.getLogger(Books.class);
    private static BooksActionHandler actiondHandler = new BooksActionHandler();

    public static void main(String[] args) throws LoadingException {
        HttpService.boot(Books::init, "books", args);
    }

    static void init(Environment environment) {
        environment.routingEngine()
                .registerAutoRoute(Route.sync("POST", "/books/add", Books::addBook))
                .registerAutoRoute(Route.sync("POST", "/books/<id>/rate", Books::rateBook));
    }

    private static Response<ByteString> addBook(RequestContext context)  {
        LOG.info("Received request to add a book");
        CreationRequest request = creationRequestFrom(context);
        BookDetail detail = DetailFactory.createFrom(request);
        actiondHandler.handle(new AddBook(BOOK_ID, detail));
        return Response.forStatus(CREATED);
    }

    private static Response<ByteString> rateBook(RequestContext context)  {
        LOG.info("Received request to rate a book");
        String id = context.pathArgs().get("id");
        RateRequest request = rateRequestFrom(context);
        Rating rating = RatingFactory.createFrom(request);
        actiondHandler.handle(new RateBook(id, rating));
        return Response.forStatus(CREATED);
    }

    private static CreationRequest creationRequestFrom(RequestContext context) {
        String payload = context.request().payload().orElse(ByteString.EMPTY).utf8();
        return new Gson().fromJson(payload, CreationRequest.class);
    }

    private static RateRequest rateRequestFrom(RequestContext context) {
        String payload = context.request().payload().orElse(ByteString.EMPTY).utf8();
        return new Gson().fromJson(payload, RateRequest.class);
    }
}